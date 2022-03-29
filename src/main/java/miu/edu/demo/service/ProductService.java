package miu.edu.demo.service;

import miu.edu.demo.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(int id);
}
