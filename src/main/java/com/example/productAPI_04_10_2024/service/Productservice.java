package com.example.productAPI_04_10_2024.service;

import com.example.productAPI_04_10_2024.controllers.Product;
import com.example.productAPI_04_10_2024.model.ProductModel;
import com.example.productAPI_04_10_2024.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class Productservice {

    @Autowired
    private ProductRepo productRepo;


    public ProductModel addProduct(ProductModel prod){
        return productRepo.save(prod);
    }


    public List<ProductModel> getallproducts() {

        return productRepo.findAll();
    }

    public ProductModel updateproduct(long id , ProductModel prodM) {

        Optional<ProductModel> prod = productRepo.findById(id);

        if(prod.isPresent()){

            prod.get().setDescription(prodM.getDescription());
            prod.get().setBrand(prodM.getBrand());
            prod.get().setQty(prodM.getQty());
            prod.get().setPrice(prodM.getPrice());
        }
        return productRepo.save(prod.get());
    }

    public void deleteproduct(long id) {

        productRepo.deleteById(id);

    }
}
