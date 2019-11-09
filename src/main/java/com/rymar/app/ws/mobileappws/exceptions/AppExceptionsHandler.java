package com.rymar.app.ws.mobileappws.exceptions;/*
 *
 *autor Sergey on 06.11.2019 7:21
 */

import com.rymar.app.ws.mobileappws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
        String errorMessageDiscription=ex.getLocalizedMessage();
        if (errorMessageDiscription==null) errorMessageDiscription=ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDiscription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        String errorMessageDiscription=ex.getLocalizedMessage();
        if (errorMessageDiscription==null) errorMessageDiscription=ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDiscription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
        String errorMessageDiscription=ex.getMessage();
        if (errorMessageDiscription==null) errorMessageDiscription=ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDiscription);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
