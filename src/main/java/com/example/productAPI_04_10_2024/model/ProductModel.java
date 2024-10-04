package com.example.productAPI_04_10_2024.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;




@Data  //generates all setters and getter and toString  and default constructor from lambok . if we dont want that we can say @setter and @getter . if we want constructour for all varaibles we can use @AllArgsConstructor
@AllArgsConstructor
@NoArgsConstructor //this is used for deafult construtor
@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String brand;
    private  String description;

    private  int qty;
    private  int price;
}
