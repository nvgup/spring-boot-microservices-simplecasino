package com.simplecasino.gameservice.exception;

public class ExternalServiceException extends RuntimeException {

    private ApiError apiError;

    public ExternalServiceException(ApiError apiError) {
        this.apiError = apiError;
    }

    public ExternalServiceException(ApiError apiError, String message) {
        super(message);
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }
}
