/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.springbootrestapi.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author Pedro
 */
public class BlogAPIException extends RuntimeException{
    
    private HttpStatus status;
    private String message;
    
    public BlogAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    
    public BlogAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
    
}
