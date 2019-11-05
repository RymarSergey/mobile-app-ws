package com.rymar.app.ws.mobileappws.ui.model.request;/*
 *
 *autor Sergey on 05.11.2019 0:16
 */

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class UpdateUserDetailsRequestModel {
    @NotNull(message = "message can not be null")
    @Size(min=2,message = "First Name must be >=2 ")
    private String firstName;
    @NotNull(message = "message can not be null")
    @Size(min=2,message = "Last Name must be >=2 ")
    private String lastName;
}
