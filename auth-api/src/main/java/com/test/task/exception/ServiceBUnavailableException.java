package com.test.task.exception;

public class ServiceBUnavailableException extends RuntimeException {
    public ServiceBUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
