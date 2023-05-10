package com.blogapplication.blogapplication.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public BlogAPIException(String arg0, HttpStatus status, String message) {
        super(arg0);
        this.status = status;
        this.message = message;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }


    

}
