package com.example.productAPI_04_10_2024.controllers;

import com.example.productAPI_04_10_2024.model.ProductModel;
import com.example.productAPI_04_10_2024.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // RESTCONTROLLER=Controller+Body //Spring MVC-Response-we return a ViewResolver-write to body of the html
@RequestMapping
public class Product {



    @Autowired
    Productservice productservice;

    ArrayList<ProductModel> productsList = new ArrayList<ProductModel>();
    {

        productsList.add(new ProductModel(101L,"Nike","good",10,15000));
        productsList.add(new ProductModel(102L,"Puma","good",20,15045));
    }


    @GetMapping("/")
    public String Greet(){
        return "Hello product application";
    }

    @GetMapping("/productsList")
    public ArrayList<ProductModel> getArrayproductList(){
        return productsList;
    }

    @GetMapping(value = "/product/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ProductModel> getByID(@PathVariable Long id){
        Optional<ProductModel>optional = productsList.stream().filter(product->product.getProductId()==id).findFirst();
        return ResponseEntity.ok().body(optional.get());
    }

    //strings comapreions use equals
    @GetMapping(value = "/product/brand/{brandname}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ProductModel> getBrandname(@PathVariable String brandname){
        Optional<ProductModel>optional = productsList.stream().filter(product->product.getBrand().equals( brandname)).findFirst();
        return ResponseEntity.ok().body(optional.get());
    }

    @PostMapping("/addproduct")
    public ProductModel addproduct(@RequestBody ProductModel pord){
        return productservice.addProduct(pord);
    }

    @GetMapping(value = "/getproduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductModel>> getproduct(){
        return ResponseEntity.status(200).body(productservice.getallproducts());

    }

    @PutMapping("/updatemapping/{id}")
    public ProductModel updateproduct(@PathVariable long id , @RequestBody ProductModel prod){
        return productservice.updateproduct(id,prod);
    }

    @DeleteMapping("/deletemapping/{id}")
    public void deleteproduct(@PathVariable long id){
      productservice.deleteproduct(id);
    }



}
