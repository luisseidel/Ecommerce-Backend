package com.seidelsoft.SpringEcommerceBackend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String name;

    private Double price;

    public Product(String id) {
        this.id = id;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
