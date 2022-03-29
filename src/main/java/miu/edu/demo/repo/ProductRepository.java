package miu.edu.demo.repo;

import miu.edu.demo.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    Product getById(int id);
}
