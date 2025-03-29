package com.thepriyanshiprateek.eshop_rest_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "products"
)
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String description;
    private String image;
    private double price;
    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name="category_id"
    )
    private Category category;
}
