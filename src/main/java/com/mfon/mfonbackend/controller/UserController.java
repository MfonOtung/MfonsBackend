package com.mfon.mfonbackend.controller;

import com.mfon.mfonbackend.dto.RegistrationBody;
import com.mfon.mfonbackend.exceptions.UserAlreadyExistsException;
import com.mfon.mfonbackend.model.UserModel;
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
    public Optional<UserModel> getUser(@PathVariable Long userId){

        return userService.getOneUser(userId);
    }


    @GetMapping("/get-all-users")
    public List<UserModel> getAll(){
        return userService.getAllUsers();
    }

    @PostMapping("/create-a-user")
    public UserModel createUser(@RequestBody RegistrationBody comingUser){

        try {
            return userService.registerUser(comingUser);
        } catch (UserAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/update-user/{userId}")
    public UserModel updateUser(@RequestBody UserModel user, @PathVariable Long userId) throws Exception {
        return userService.updateUserInfo(userId, user);
    }

    @DeleteMapping("/delete-user/{userId}")
    public String deleteUser(@PathVariable Long userId) throws Exception {
        return userService.deleteOneUser(userId);
    }
}
