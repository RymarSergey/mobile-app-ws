package com.rymar.app.ws.mobileappws.ui.model.response;/*
 *
 *autor Sergey on 09.11.2019 14:08
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private Date timestump;
    private String message;
}
