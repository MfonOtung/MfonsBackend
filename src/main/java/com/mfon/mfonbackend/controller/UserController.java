package com.mfon.mfonbackend.controller;

import com.mfon.mfonbackend.dto.RegistrationBody;
import com.mfon.mfonbackend.exceptions.UserAlreadyExistsException;
import com.mfon.mfonbackend.model.User;
import com.mfon.mfonbackend.model.dao.UserDAO;
import com.mfon.mfonbackend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

   UserService userService;

    public UserController(UserService uService){
        userService = uService;
    }

    @GetMapping("/get-one-user")
    public String getUser(){

        return "this is a test";
    }

    // TODO: create a method called getUsers and shall return a string array
    @GetMapping("/get-all-users")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    //TODO: create a method called createUSer and shall post a string
    @PostMapping("/create-a-user")
    public User createUser(@RequestBody RegistrationBody userComingFromFrontEnd){

        try {
            return  userService.registerUser(userComingFromFrontEnd);
        } catch (UserAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: create a method called updateUSer and shall return an int
    @PutMapping("/input-update")
    public int updateUser(int value1, String name, String[] arr){

        return 0;
    }

    // TODO: create a method called deleteUSer and shall return a boolean
    @DeleteMapping("/delete-user")
    public boolean deleteUser() {

        return true;
    }
}
