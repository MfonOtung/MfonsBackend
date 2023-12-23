package com.mfon.mfonbackend.controller;

import com.mfon.mfonbackend.dto.RegistrationBody;
import com.mfon.mfonbackend.exceptions.UserAlreadyExistsException;
import com.mfon.mfonbackend.model.User;
import com.mfon.mfonbackend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

   UserService userService;

    public UserController(UserService uService){
        userService = uService;
    }

    // CRUD operations
    // Create (POST) - Read (GET) - UPDATE (PUT) - DELETE ()
    @GetMapping("/get-one-user/{userId}")
    public Optional<User> getUser(@PathVariable Long userId){

        return userService.getOneUser(userId);
    }

    // TODO: create a method called getUsers and shall return a string array
    @GetMapping("/get-all-users")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/create-a-user")
    public User createUser(@RequestBody RegistrationBody comingUser){

        try {
            return userService.registerUser(comingUser);
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
