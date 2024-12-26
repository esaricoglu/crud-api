package com.esaricoglu.handler;

public class ApiError<E> {

    private Integer status;

    private Exception<E> exception;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Exception<E> getException() {
        return exception;
    }

    public void setException(Exception<E> exception) {
        this.exception = exception;
    }
}
