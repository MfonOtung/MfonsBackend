package com.mfon.mfonbackend.model.dao;

import com.mfon.mfonbackend.model.ProductModel;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<ProductModel,Long> {


}