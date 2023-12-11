package com.mfon.mfonbackend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get-one-user")
    public String getUser(){

        return "this is a test";
    }

    public String[] getUsers(){
        return new String[]{"Users"};
    }

    // TODO: cre


    //TODO: create a method called createUSer and shall post a string
    @PostMapping("/create-a-user")
    public String createUser (){
        return "Input username";
    }

    // TODO: create a method called updateUSer and shall return an int
    @PutMapping("input-update")
    public int updateUser (){
        return 0;
    }

    // TODO: create a method called deleteUSer and shall return a boolean
    @DeleteMapping("delete-user")
    public Boolean deleteUser() {
        return null;
    }
}
