package com.mfon.mfonbackend.controller;

import com.mfon.mfonbackend.dto.RegistrationBody;
import com.mfon.mfonbackend.model.User;
import com.mfon.mfonbackend.model.dao.UserDAO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    UserDAO userDAO;

    public UserController(UserDAO udao){
        userDAO = udao;
    }

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
        customer.setFirstname(user1.getFirstname());
        customer.setLastname(user1.getLastname());
        customer.setUsername(user1.getUsername());
        customer.setPassword(user1.getPassword());
        customer.setAddress(user1.getAddress());
        customer.setEmail(user1.getEmail());

        userDAO.save(customer);
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
