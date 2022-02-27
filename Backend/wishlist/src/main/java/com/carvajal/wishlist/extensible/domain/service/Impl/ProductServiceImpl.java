package com.carvajal.wishlist.extensible.domain.service.Impl;

import com.carvajal.wishlist.extensible.domain.model.Product;
import com.carvajal.wishlist.extensible.domain.repository.ProductRepository;
import com.carvajal.wishlist.extensible.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
