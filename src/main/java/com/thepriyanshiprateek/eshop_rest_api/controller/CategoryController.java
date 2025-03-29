package com.thepriyanshiprateek.eshop_rest_api.controller;

import com.thepriyanshiprateek.eshop_rest_api.entity.Category;
import com.thepriyanshiprateek.eshop_rest_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/controller")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id"))
}
