package com.rymar.app.ws.mobileappws.ui.controller;

import com.rymar.app.ws.mobileappws.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

/*
 *
 *autor Sergey on 02.11.2019 16:14
 */
@RestController
@RequestMapping("/users")//http://localhost:8080/users
public class UserController {
    @GetMapping
    public String getUsers(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "limit",defaultValue = "25") int limit,
                           @RequestParam(value = "sort",required = false) String sort ){
        return " get users with page="+page+" limit="+limit +" sort ="+sort;
    }
    @GetMapping(path = "/{userId}")
    public UserRest getUser(@PathVariable String userId){
        UserRest userRest = new UserRest();
        userRest.setEmail("test@test.ua");
        userRest.setFirstName("Sergey");
        userRest.setLastName("Rymar");
        return userRest;
    }
    @PostMapping
    public String createUser(){
        return " create user was colled";
    }
    @PutMapping
    public String updateUser(){
        return " update user was colled";
    }
    @DeleteMapping
    public String deleteUser(){
        return "delete user was colled";
    }

}
