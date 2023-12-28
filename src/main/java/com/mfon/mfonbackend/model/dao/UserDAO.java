package com.mfon.mfonbackend.model.dao;

import com.mfon.mfonbackend.model.UserModel;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserDAO extends ListCrudRepository<UserModel,Long> {

    Optional<UserModel> findByUsernameIgnoreCase(String username);
    Optional<UserModel> findByEmailIgnoreCase(String email);

}
