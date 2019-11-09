package com.rymar.app.ws.mobileappws.userservice;/*
 *
 *autor Sergey on 09.11.2019 15:37
 */

import com.rymar.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.rymar.app.ws.mobileappws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetailsRequestModel);
}
