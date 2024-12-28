package com.esaricoglu.exception;

import org.springframework.http.HttpStatus;

public enum MessageType {

    USER_NOT_FOUND("1001","User not found"),
    INVALID_CREDENTIALS("1002","Username or password is incorrect"),
    VALIDATION_ERROR("1003","Validation error"),
    USERNAME_ALREADY_EXISTS("1004","Username already exists");

    private String code;

    private String message;


    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
