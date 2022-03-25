package com.lmnoppy.api.covid.model;

public class AreaTypeNotSupportException extends RuntimeException {

    public AreaTypeNotSupportException(String message) {
        super(message);
    }

    public AreaTypeNotSupportException(String message, Throwable cause) {
        super(message, cause);
    }

}
