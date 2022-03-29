package miu.edu.demo.repo;

import miu.edu.demo.domain.Product;
import miu.edu.demo.domain.dto.ProductDto;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    Product getById(int id);

    void save(Product p);

    void update(Product p);

    void delete(int id);
}
