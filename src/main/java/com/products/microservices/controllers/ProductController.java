package com.products.microservices.controllers;

import com.products.microservices.models.entity.Product;
import com.products.microservices.models.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list_products")
    public ResponseEntity<?> listProducts() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Product> detail(@PathVariable Long id) {
        Optional<Product> o = productService.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
        Product productDb = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDb);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Long id){
        Optional<Product> obj = productService.findById(id);
        if(obj.isEmpty()){
            ResponseEntity.notFound().build();
        }
        Product productDb = obj.get();
        productDb.setName(product.getName());
        productDb.setPrice(product.getPrice());
        productDb.setStatus(product.getStatus());
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDb));
    }
}
