package com.rymar.app.ws.mobileappws.exceptions;/*
 *
 *autor Sergey on 09.11.2019 14:40
 */

public class UserServiceException extends RuntimeException {
    private static final long serialVersionUID = -6692998289446209872L;

    public UserServiceException(String message){
        super(message);
    }
}
