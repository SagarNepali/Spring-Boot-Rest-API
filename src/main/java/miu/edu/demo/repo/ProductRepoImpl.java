package miu.edu.demo.repo;

import miu.edu.demo.domain.Product;
import miu.edu.demo.domain.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepository{

    private static List<Product> products;

    static {

        products = new ArrayList<>(){{
            add(new Product(1,"Aphone",100.22F,new ArrayList<>(){{
                add(new Review(1,"Very good",4));
                add(new Review(2,"Satisfactory",5));
                add(new Review(3,"Worst",2));
            }}));
            add(new Product(2,"Bphone",122.34F,new ArrayList<>(){{
                add(new Review(1,"Very good",4));
                add(new Review(2,"Satisfactory",5));
                add(new Review(3,"Worst",2));
            }}));
            add(new Product(3,"Cphone",233.43F,new ArrayList<>(){{
                add(new Review(4,"Satisfactory",5));
                add(new Review(5,"Expensive",2));
            }}));
        }};

    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        return products.stream().filter(p -> p.getId()==id).findAny().orElse(null);
    }
}
