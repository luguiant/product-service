package com.products.microservices.models.service.product;

import com.products.microservices.models.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    public Iterable<Product> findAll();
    public Optional<Product> findById(Long id);
    public Product save(Product p);
    public void deletedById(Long id);
    
}
