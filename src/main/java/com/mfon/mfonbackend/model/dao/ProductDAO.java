package com.mfon.mfonbackend.model.dao;

import com.mfon.mfonbackend.model.Product;
import com.mfon.mfonbackend.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ProductDAO extends ListCrudRepository<Product,Long> {


}