package com.project.traffic.api.exceptionhandler;

import com.project.traffic.domain.exception.BusinessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){

        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setTitle("One or more fields are invalid!");
        problemDetail.setType(URI.create("http://algatraffic.com/errors/invalid-fields"));

        return handleExceptionInternal(ex, problemDetail, headers, status, request);
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> capt(BusinessException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
