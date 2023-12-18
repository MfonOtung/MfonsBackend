package com.mfon.mfonbackend.model.dao;

import com.mfon.mfonbackend.model.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserDAO extends ListCrudRepository<User,Long> {
}
