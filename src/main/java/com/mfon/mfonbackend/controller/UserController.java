package com.mfon.mfonbackend.controller;

import com.mfon.mfonbackend.dto.RegistrationBody;
import com.mfon.mfonbackend.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get-one-user")
    public String getUser(){

        return "this is a test";
    }

    // TODO: create a method called getUsers and shall return a string array
    @GetMapping("/get-many-users")
    public String[] getUsers(){
        return new String[]{"Users"};
    }

    //TODO: create a method called createUSer and shall post a string
    @PostMapping("/create-a-user")
    public User createUser(@RequestBody RegistrationBody user1){

        User customer = new User();
        customer.setName(user1.getName());
        customer.setUsername(user1.getUsername());
        customer.setPassword(user1.getPassword());

        return  customer;
    }

    // TODO: create a method called updateUSer and shall return an int
    @PutMapping("/input-update")
    public int updateUser(){

        return 0;
    }

    // TODO: create a method called deleteUSer and shall return a boolean
    @DeleteMapping("/delete-user")
    public boolean deleteUser() {

        return true;
    }
}
