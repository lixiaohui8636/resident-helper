// Copyright 2016 ubestkid Inc. All rights reserved.

package com.residenthelper.server.common;

/**
 * The rest response.
 *
 * @author Snakecon (snakecon@gmail.com)
 */
public class ApiResponse<R> {

    private String errorMessage;
    private long errorCode;
    private R result;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiResponse<?> that = (ApiResponse<?>) o;

        if (errorCode != that.errorCode) return false;
        if (errorMessage != null ? !errorMessage.equals(that.errorMessage) : that.errorMessage != null) return false;
        return result != null ? result.equals(that.result) : that.result == null;
    }

    @Override
    public int hashCode() {
        int result1 = errorMessage != null ? errorMessage.hashCode() : 0;
        result1 = 31 * result1 + (int) (errorCode ^ (errorCode >>> 32));
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorCode=" + errorCode +
                ", result=" + result +
                '}';
    }

    public static class ApiResponseBuilder<R> {

        private String errorMessage;
        private long errorCode;
        private R result;

        public ApiResponseBuilder() {
        }

        public static <R> ApiResponseBuilder anApiResponseBuilder() {
            return new ApiResponseBuilder<R>();
        }

        public static <R> ApiResponseBuilder anApiResponseBuilder(R result) {
            return new ApiResponseBuilder<R>().withResult(result);
        }

        public ApiResponseBuilder withErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        public ApiResponseBuilder withErrorCode(long errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ApiResponseBuilder withApiException(ApiException apiException) {
            this.errorCode = apiException.getApiErrorCode().getErrorCode();
            this.errorMessage = apiException.getMessage();
            return this;
        }

        public ApiResponseBuilder withApiErrorCode(ApiErrorCode apiErrorCode) {
            this.errorCode = apiErrorCode.getErrorCode();
            this.errorMessage = apiErrorCode.getMessage();
            return this;
        }

        public ApiResponseBuilder withResult(R result) {
            this.result = result;
            return this;
        }

        public ApiResponse<R> build() {
            ApiResponse<R> apiResponse = new ApiResponse<R>();
            apiResponse.setErrorMessage(errorMessage);
            apiResponse.setErrorCode(errorCode);
            apiResponse.setResult(result);
            return apiResponse;
        }
    }
}
