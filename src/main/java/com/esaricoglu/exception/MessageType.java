package com.esaricoglu.exception;

public enum MessageType {

    NO_RECORD_EXIST("1001","Record not found"),
    GENERAL_EXCEPTION("9999","General Exception");

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
