package com.thepriyanshiprateek.eshop_rest_api.controller;

import com.thepriyanshiprateek.eshop_rest_api.entity.Product;
import com.thepriyanshiprateek.eshop_rest_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/cat/{categoryId}")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable("categoryId") Long categoryId){
        return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId));
    }
    @PostMapping("/cat/{categoryId}")
    public ResponseEntity<Product> saveProduct(@PathVariable("categoryId") Long categoryId, @RequestBody Product){
        return ResponseEntity.ok(productService.saveProduct(categoryId, product));
    }
}
