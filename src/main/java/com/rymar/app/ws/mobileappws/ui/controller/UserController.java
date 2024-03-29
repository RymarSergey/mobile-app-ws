package com.rymar.app.ws.mobileappws.ui.controller;

import com.rymar.app.ws.mobileappws.exceptions.UserServiceException;
import com.rymar.app.ws.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.rymar.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.rymar.app.ws.mobileappws.ui.model.response.UserRest;
import com.rymar.app.ws.mobileappws.userservice.UserService;
import com.rymar.app.ws.mobileappws.userservice.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/*
 *
 *autor Sergey on 02.11.2019 16:14
 */
@RestController
@RequestMapping("/users")//http://localhost:8080/users
public class UserController {
    private Map<String,UserRest> users;
    @Autowired
    UserService userService;
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "25") int limit,
                           @RequestParam(value = "sort", required = false) String sort) {
        return " get users with page=" + page + " limit=" + limit + " sort =" + sort;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
       if(true) throw new UserServiceException("Throw my exception");

       if (users.containsKey(userId)){
        return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
       } else return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel) {
        UserRest userRest= userService.createUser(userDetailsRequestModel);


        return new ResponseEntity<>(userRest, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId,
                             @Valid @RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {
        UserRest storedUserDetails=users.get(userId);
        storedUserDetails.setFirstName(updateUserDetailsRequestModel.getFirstName());
        storedUserDetails.setLastName(updateUserDetailsRequestModel.getLastName());
        users.put(userId,storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }

}
