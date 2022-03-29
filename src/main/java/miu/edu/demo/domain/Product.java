package miu.edu.demo.domain;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private float price;

    private List<Review> reviews;
}
