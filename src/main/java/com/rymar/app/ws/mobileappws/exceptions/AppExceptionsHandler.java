package com.rymar.app.ws.mobileappws.exceptions;/*
 *
 *autor Sergey on 06.11.2019 7:21
 */

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
    return new ResponseEntity<>(ex,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
