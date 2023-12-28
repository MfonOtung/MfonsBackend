package com.mfon.mfonbackend.controller;

import com.mfon.mfonbackend.dto.ProductDetails;
import com.mfon.mfonbackend.model.ProductModel;
import com.mfon.mfonbackend.model.UserModel;
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
    public List<ProductModel> getAll() {
        return productService.getAllProducts();
    }

    @PostMapping("/create-product")
    public ProductModel createProduct(@RequestBody ProductDetails availableProduct) {

        try {
            return productService.addProduct(availableProduct);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get-one-product/{productId}")
    public Optional<ProductModel> getProduct(@PathVariable Long productId){
        return productService.getOneProduct(productId);
    }

    @PutMapping("/update-product/{productId}")
    public ProductModel updateProduct(@RequestBody ProductModel product, @PathVariable Long productId) throws Exception {
        return productService.updateProductInfo(productId, product);
    }

    @DeleteMapping("/delete-product/{productId}")
    public String deleteProduct(@PathVariable Long productId) throws Exception {
        return productService.deleteOneProduct(productId);
    }
}
