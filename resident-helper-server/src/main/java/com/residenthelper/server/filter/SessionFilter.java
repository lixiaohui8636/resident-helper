package com.residenthelper.server.filter;

/**
 * Created by jaygao on 29/05/2018.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.residenthelper.server.common.ApiErrorCode;
import com.residenthelper.server.common.ApiException;
import com.residenthelper.server.common.ApiResponse;
import com.residenthelper.server.service.token.TokenService;
import com.residenthelper.server.service.token.bean.TokenBean;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lixiaohui
 */
public class SessionFilter implements Filter {
    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private TokenService tokenService;

    public SessionFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        //web跨域 content-type application/json 会先发送一个options请求
        if("OPTIONS".equals(httpRequest.getMethod())){
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        if (httpRequest.getRequestURI().contains("/loginWithWechat")){
            chain.doFilter(req, res);
            return;
        }

        //log.warn("Invalid session");
        ServletRequestWrapper requestWrapper = new MultiReadableHttpServletRequestWrapper((HttpServletRequest) req);
        byte[] httpBody = IOUtils.toByteArray(requestWrapper.getInputStream());
        String httpBodyStr = new String(httpBody);
        TokenBean tokenBean = gson.fromJson(httpBodyStr, TokenBean.class);
        if(tokenBean == null){
            ApiResponse apiResponse = ApiResponse.ApiResponseBuilder.anApiResponseBuilder()
                    .withApiErrorCode(ApiErrorCode.USER_TOKEN_EXPIRED)
                    .build();
            writeExcaliburResponse(httpResponse,apiResponse);
            return;
        }
        String token = tokenBean.getToken();
        try {
            long userId = tokenService.findUserIdByToken(token);
            if(userId <= 0 || tokenBean.getUserId() != userId){
                ApiResponse apiResponse = ApiResponse.ApiResponseBuilder.anApiResponseBuilder()
                        .withApiErrorCode(ApiErrorCode.USER_TOKEN_EXPIRED)
                        .build();
                writeExcaliburResponse(httpResponse,apiResponse);
                return;
            }
        }catch (ApiException e){
            ApiResponse apiResponse = ApiResponse.ApiResponseBuilder.anApiResponseBuilder()
                    .withApiErrorCode(ApiErrorCode.USER_TOKEN_EXPIRED)
                    .build();
            writeExcaliburResponse(httpResponse,apiResponse);
            return;
        }
        chain.doFilter(requestWrapper, res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Component
    public static class SessionFilterFactory {
        @Autowired
        private TokenService tokenService;

        @Bean
        public FilterRegistrationBean createSessionFilter() {
            FilterRegistrationBean registration = new FilterRegistrationBean();
            registration.setFilter(new SessionFilter(tokenService));
            registration.setEnabled(true);
            registration.addUrlPatterns("/api/*");
            return registration;
        }

    }

    public void writeExcaliburResponse(HttpServletResponse response, ApiResponse data) throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.append(gson.toJson(data));
    }

}
