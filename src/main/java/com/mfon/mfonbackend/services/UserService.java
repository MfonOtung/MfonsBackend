package com.mfon.mfonbackend.services;

import com.mfon.mfonbackend.dto.RegistrationBody;
import com.mfon.mfonbackend.exceptions.UserAlreadyExistsException;
import com.mfon.mfonbackend.model.UserModel;
import com.mfon.mfonbackend.model.dao.UserDAO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserModel registerUser(RegistrationBody newUser) throws UserAlreadyExistsException {

        // TODO: check if a user with the same email or username already exists
        if(userDAO.findByUsernameIgnoreCase(newUser.getUsername()).isPresent()
                || userDAO.findByEmailIgnoreCase(newUser.getEmail()).isPresent()
        ){
            throw new UserAlreadyExistsException();
        }

        UserModel customer = new UserModel();
        customer.setFirstname(newUser.getFirstname());
        customer.setLastname(newUser.getLastname());
        customer.setUsername(newUser.getUsername());
        customer.setAddress(newUser.getAddress());
        customer.setEmail(newUser.getEmail());

        // TODO: encrypt the password before saving it
        customer.setPassword(newUser.getPassword());

        return userDAO.save(customer);
    }


    public List<UserModel> getAllUsers(){
        return userDAO.findAll();
    }


    public Optional<UserModel> getOneUser(Long id){
        return userDAO.findById(id);
    }

    public UserModel updateUserInfo(Long id, UserModel user) throws Exception {

        // Find if the user exist in our database. If not, throw an exception
        Optional<UserModel> userDB = getOneUser(id) ; // userDAO.findById(id);
        UserModel updatedUser = new UserModel();

        if(userDB.isPresent() ){
            updatedUser = userUpdateHelper(userDB, user, updatedUser);
            userDAO.save(updatedUser);

        }else{
            throw new Exception("User does not exist");
        }

        return updatedUser;
    }

    private UserModel userUpdateHelper(Optional<UserModel> userDB, UserModel user, UserModel updatedUser){
        UserModel userFromDB = userDB.get();

        updatedUser.setId(userFromDB.getId());

        // update firstname
        if(user.getFirstname() == null || user.getFirstname() == ""){
            updatedUser.setFirstname(userFromDB.getFirstname());
        }else{
            updatedUser.setFirstname(user.getFirstname());
        }

        if(user.getLastname() == null || user.getLastname() == ""){
            updatedUser.setLastname(userFromDB.getLastname());
        }else{
            updatedUser.setLastname(user.getLastname());
        }

        if(user.getEmail() == null || user.getEmail() == ""){
            updatedUser.setEmail(userFromDB.getEmail());
        }else{
            updatedUser.setEmail(user.getEmail());
        }

        if(user.getAddress() == null || user.getAddress() == ""){
            updatedUser.setAddress(userFromDB.getAddress());
        }else{
            updatedUser.setAddress(user.getAddress());
        }

        if(user.getPassword() == null || user.getPassword() == ""){
            updatedUser.setPassword(userFromDB.getPassword());
        }else{
            updatedUser.setPassword(user.getPassword());
        }

        if(user.getUsername() == null || user.getUsername() == ""){
            updatedUser.setUsername(userFromDB.getUsername());
        }else{
            updatedUser.setUsername(user.getUsername());
        }

        if(user.getPhone() == null || user.getPhone() == ""){
            updatedUser.setPhone(userFromDB.getPhone());
        }else{
            updatedUser.setPhone(user.getPhone());
        }

        // birthdate
        if(user.getBirthdate() == null){
            updatedUser.setBirthdate(userFromDB.getBirthdate());
        }else{
            updatedUser.setBirthdate(user.getBirthdate());
        }
        return updatedUser;
    }

    public String deleteOneUser(Long id) throws Exception {
       var userDB = getOneUser(id);
       if (userDB.isPresent()){
           UserModel userToDele = userDB.get();
           userDAO.delete(userToDele);
           return "User successfully deleted";
       }else{
           throw new Exception("User does not exist.");
       }
    }
}
