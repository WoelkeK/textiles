package com.ambitious.team.textiles.config.api.exception;

public class BagNotFoundException extends Exception {
    public BagNotFoundException(String message) {
        super(message);
    }

    public BagNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
