package com.mfon.mfonbackend.services;

import com.mfon.mfonbackend.dto.ProductDetails;
import com.mfon.mfonbackend.model.ProductModel;
import com.mfon.mfonbackend.model.UserModel;
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

    public List<ProductModel> getAllProducts(){
        return productDAO.findAll();
    }

    public Optional<ProductModel> getOneProduct(Long id){
        return productDAO.findById(id);
    }

    public ProductModel addProduct(ProductDetails newProduct){

        ProductModel productToAdd = new ProductModel();
        productToAdd.setName(newProduct.getName());
        productToAdd.setPrice(newProduct.getPrice());
        productToAdd.setDescription(newProduct.getDescription());


        return productDAO.save(productToAdd);
    }

    public ProductModel updateProductInfo(Long id, ProductModel product) throws Exception {

        // Find if the user exist in our database. If not, throw an exception
        Optional<ProductModel> productDB = productDAO.findById(id);
        ProductModel updatedProduct = new ProductModel();

        if (productDB.isPresent()) {
            ProductModel productFromDB = productDB.get();

            updatedProduct.setId(productFromDB.getId());

            // update name
            if (product.getName() == null || product.getName() == "") {
                updatedProduct.setName(productFromDB.getName());
            } else {
                updatedProduct.setName(product.getName());
            }

            if (Double.isNaN(product.getPrice())) {
                updatedProduct.setPrice(productFromDB.getPrice());
            } else {
                updatedProduct.setPrice(product.getPrice());
            }

            if (product.getDescription() == null || product.getDescription() == "") {
                updatedProduct.setDescription(productFromDB.getDescription());
            } else {
                updatedProduct.setDescription(product.getDescription());
            }

            // communication with database
            productDAO.save(updatedProduct); // this line saves the data in the database
        } else {
            throw new Exception("This Product does not exist.");
        }
        return updatedProduct;
    }
    public String deleteOneProduct(Long id) throws Exception {
        var productDB = getOneProduct(id);
        if (productDB.isPresent()){
            ProductModel productToDelete = productDB.get();
            productDAO.delete(productToDelete);
            return "Product successfully deleted";
        }else{
            throw new Exception("Product does not exist.");
        }
    }
}

