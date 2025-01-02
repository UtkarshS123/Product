package com.io.product.service;

import com.io.product.dto.UserDto;
import com.io.product.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);
    Product findOne(Long id);
    List<Product> findAll();
    UserDto getUser(Long id);
}
