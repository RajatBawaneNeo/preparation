package com.videostream.app.videostream.controller.exception;

public class InvalidInputFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public InvalidInputFoundException(String msg) {
        super(msg);

    }
}
