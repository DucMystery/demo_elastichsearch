package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NewspaperNotFoundException extends RuntimeException {

    public NewspaperNotFoundException(){
        super();
    }

    public NewspaperNotFoundException(String message,Throwable cause){
        super(message,cause);
    }

    public NewspaperNotFoundException(String message){
        super(message);
    }

    public NewspaperNotFoundException(Throwable cause){
        super(cause);
    }
}
