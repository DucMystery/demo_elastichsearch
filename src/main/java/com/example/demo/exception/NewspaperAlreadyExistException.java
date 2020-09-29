package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NewspaperAlreadyExistException extends RuntimeException{

    public NewspaperAlreadyExistException(){
        super();
    }

    public NewspaperAlreadyExistException(String message,Throwable cause){
        super(message,cause);
    }

    public NewspaperAlreadyExistException(String message){
        super(message);
    }

    public NewspaperAlreadyExistException(Throwable cause){
        super(cause);
    }
}
