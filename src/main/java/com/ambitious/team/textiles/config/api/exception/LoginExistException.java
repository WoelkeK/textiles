package com.ambitious.team.textiles.config.api.exception;

public class LoginExistException extends Exception {
    public LoginExistException(String message) {
        super(message);
    }

    public LoginExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
