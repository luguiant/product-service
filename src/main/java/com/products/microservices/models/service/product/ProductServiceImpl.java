package com.products.microservices.models.service.product;

import com.products.microservices.models.dao.ProductDao;
import com.products.microservices.models.entity.Product;
import com.products.microservices.models.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product p){
       return productDao.save(p);
    }

    @Override
    @Transactional
    public  void deletedById(Long id) {
        productDao.deleteById(id);
    }


}
