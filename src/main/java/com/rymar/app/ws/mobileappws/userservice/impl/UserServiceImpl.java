package com.rymar.app.ws.mobileappws.userservice.impl;/*
 *
 *autor Sergey on 09.11.2019 15:43
 */

import com.rymar.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.rymar.app.ws.mobileappws.ui.model.response.UserRest;
import com.rymar.app.ws.mobileappws.userservice.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    private Map<String,UserRest> users;
    @Override
    public UserRest createUser(UserDetailsRequestModel userDetailsRequestModel) {
        UserRest userRest = new UserRest();
        userRest.setEmail(userDetailsRequestModel.getEmail());
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setLastName(userDetailsRequestModel.getLastName());

        String userId= String.valueOf(UUID.randomUUID());
        userRest.setUserId(userId);
        if (users==null) users = new HashMap<>();
        users.put(userRest.getUserId(),userRest);
        return userRest;
    }
}
