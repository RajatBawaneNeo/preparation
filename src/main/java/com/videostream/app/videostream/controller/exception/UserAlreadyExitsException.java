package com.videostream.app.videostream.controller.exception;

public class UserAlreadyExitsException extends RuntimeException {

        private static final long serialVersionUID = 1L;
      public UserAlreadyExitsException(String msg) {
          super(msg);



    }
}
