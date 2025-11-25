package com.example.Proiect_Data.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ExceptionComanda extends RuntimeException {
    public ExceptionComanda(String message) {
        super(message);
    }
}
