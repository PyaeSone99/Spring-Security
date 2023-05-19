package com.example.apisecurity.controller;

import com.example.apisecurity.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler({InvalidEmailError.class, NoBearerError.class, PasswordNotMatchError.class, UnAuthenticatedError.class})
    public ResponseEntity handleException(Throwable throwable)throws Exception{
        if (throwable instanceof InvalidEmailError error){
            return ResponseEntity.badRequest()
                    .body(error.getMessage());
        }else if (throwable instanceof NoBearerError error){
            return ResponseEntity.badRequest()
                    .body(error.getMessage());
        } else if (throwable instanceof PasswordNotMatchError error) {
            return ResponseEntity.badRequest()
                    .body(error.getMessage());
        } else if (throwable instanceof UnAuthenticatedError error) {
            return ResponseEntity.badRequest()
                    .body(error.getMessage());
        }
        return null;
    }
}
