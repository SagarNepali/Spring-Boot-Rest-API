package miu.edu.demo.service;

import miu.edu.demo.domain.Product;
import miu.edu.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{


    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.getAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.getById(id);
    }
}
