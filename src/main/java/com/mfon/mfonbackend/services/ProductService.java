package com.mfon.mfonbackend.services;

import com.mfon.mfonbackend.dto.ProductDetails;
import com.mfon.mfonbackend.model.Product;
import com.mfon.mfonbackend.model.User;
import com.mfon.mfonbackend.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return productDAO.findAll();
    }

    public Product addProduct(ProductDetails newProduct){
        Product order = new Product();
        order.setName(newProduct.getName());
        order.setId(newProduct.getId());
        order.setPrice(newProduct.getPrice());
        order.setDescription(newProduct.getDescription());


        return productDAO.save(order);
    }
}
