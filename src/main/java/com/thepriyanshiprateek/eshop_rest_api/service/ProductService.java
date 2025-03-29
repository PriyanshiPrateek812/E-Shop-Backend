package com.thepriyanshiprateek.eshop_rest_api.service;

import com.thepriyanshiprateek.eshop_rest_api.entity.Product;

import java.util.List;

public interface ProductService {
    ... getProductsByCategoryId(Long categoryId);

    List<Product> getAllProducts();
}
