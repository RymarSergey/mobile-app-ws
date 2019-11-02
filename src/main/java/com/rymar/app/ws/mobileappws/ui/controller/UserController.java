package com.rymar.app.ws.mobileappws.ui.controller;

import org.springframework.web.bind.annotation.*;

/*
 *
 *autor Sergey on 02.11.2019 16:14
 */
@RestController
@RequestMapping("users")//http://localhost:8080/users
public class UserController {
    @GetMapping
    public String getUser(){
        return " get user was colled ";
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
