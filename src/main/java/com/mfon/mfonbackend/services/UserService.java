package com.mfon.mfonbackend.services;

import com.mfon.mfonbackend.dto.RegistrationBody;
import com.mfon.mfonbackend.exceptions.UserAlreadyExistsException;
import com.mfon.mfonbackend.model.User;
import com.mfon.mfonbackend.model.dao.UserDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User registerUser(RegistrationBody newUser) throws UserAlreadyExistsException {

        // TODO: check if a user with the same email or username already exists
        if(userDAO.findByUsernameIgnoreCase(newUser.getUsername()).isPresent()
                || userDAO.findByEmailIgnoreCase(newUser.getEmail()).isPresent()
        ){
            throw new UserAlreadyExistsException();
        }

        User customer = new User();
        customer.setFirstname(newUser.getFirstname());
        customer.setLastname(newUser.getLastname());
        customer.setUsername(newUser.getUsername());
        customer.setAddress(newUser.getAddress());
        customer.setEmail(newUser.getEmail());
        customer.setId(newUser.getId());

        // TODO: encrypt the password before saving it
        customer.setPassword(newUser.getPassword());

        return userDAO.save(customer);
    }

    // TODO: create a method called getAllUsers. Then use that method in UserController

    public List<User> getAllUsers(){
        return userDAO.findAll();
    }

}
