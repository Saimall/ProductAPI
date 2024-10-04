package com.example.productAPI_04_10_2024.repository;

import com.example.productAPI_04_10_2024.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel,Long> {

}
