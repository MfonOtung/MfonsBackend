package com.mfon.mfonbackend.services;

import com.mfon.mfonbackend.dto.ProductDetails;
import com.mfon.mfonbackend.model.Product;
import com.mfon.mfonbackend.model.User;
import com.mfon.mfonbackend.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return productDAO.findAll();
    }

    public Optional<Product> getOneProduct(Long id){
        return productDAO.findById(id);
    }

    public Product addProduct(ProductDetails newProduct){

        Product productToAdd = new Product();
        productToAdd.setName(newProduct.getName());
        productToAdd.setPrice(newProduct.getPrice());
        productToAdd.setDescription(newProduct.getDescription());


        return productDAO.save(productToAdd);
    }
}
