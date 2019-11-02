package com.rymar.app.ws.mobileappws.ui.model.request;/*
 *
 *autor Sergey on 02.11.2019 19:37
 */

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDetailsRequestModel {
    @NotNull(message = "message can not be null")
    private String firstName;
    @NotNull(message = "message can not be null")
    private String lastName;
    @NotNull(message = "message can not be null")
    @Email
    private String email;
    @NotNull(message = "message can not be null")
    @Size(min=8,max=16,message = "Password must be >=8 & <16 ")
    private String password;

}
