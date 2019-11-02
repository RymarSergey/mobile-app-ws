package com.rymar.app.ws.mobileappws.ui.controller;

import com.rymar.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.rymar.app.ws.mobileappws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 *
 *autor Sergey on 02.11.2019 16:14
 */
@RestController
@RequestMapping("/users")//http://localhost:8080/users
public class UserController {
    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "25") int limit,
                           @RequestParam(value = "sort", required = false) String sort) {
        return " get users with page=" + page + " limit=" + limit + " sort =" + sort;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        UserRest userRest = new UserRest();
        userRest.setEmail("test@test.ua");
        userRest.setFirstName("Sergey");
        userRest.setLastName("Rymar");
        return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) {
        UserRest userRest = new UserRest();
        userRest.setEmail(userDetailsRequestModel.getEmail());
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setLastName(userDetailsRequestModel.getLastName());
        return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return " update user was colled";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was colled";
    }

}
