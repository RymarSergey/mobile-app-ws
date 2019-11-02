package com.rymar.app.ws.mobileappws.ui.model.request;/*
 *
 *autor Sergey on 02.11.2019 19:37
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
