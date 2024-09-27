package org.example.bai_tap_1.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }
}
