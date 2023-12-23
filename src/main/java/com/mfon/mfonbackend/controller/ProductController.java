package com.mfon.mfonbackend.controller;

import com.mfon.mfonbackend.dto.ProductDetails;
import com.mfon.mfonbackend.model.Product;
import com.mfon.mfonbackend.model.User;
import com.mfon.mfonbackend.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/get-all-products")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping("/create-product")
    public Product createProduct(@RequestBody ProductDetails availableProduct) {

        try {
            return productService.addProduct(availableProduct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get-one-product/{productId}")
    public Optional<Product> getProduct(@PathVariable Long productId){
        return productService.getOneProduct(productId);
    }

}
