package com.project.traffic.api.exceptionhandler;

import com.project.traffic.domain.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> capt(BusinessException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
