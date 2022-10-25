package com.investment.exception;


public class ExceptionResponse {

    private String errorMessage;
    private String requestedURI;

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void callerURL(final String requestedURI) {
        this.requestedURI = requestedURI;
    }
}
