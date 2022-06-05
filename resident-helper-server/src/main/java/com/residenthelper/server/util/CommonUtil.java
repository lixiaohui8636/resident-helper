package com.residenthelper.server.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Lee
 * @Date: 6/21/21
 * @Desc:
 */
public class CommonUtil {
    public static boolean isValidPhone(String phone){
        if(StringUtils.isEmpty(phone)){
            return false;
        }
        Pattern pattern = Pattern.compile("^1\\d{10}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public static String phoneEncrypt(String phone) {
        if (StringUtils.isEmpty(phone) || (phone.length() != 11)) {
            return phone;
        }
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
}
