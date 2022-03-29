package miu.edu.demo.service;

import miu.edu.demo.domain.Product;
import miu.edu.demo.domain.dto.ProductDto;
import miu.edu.demo.repo.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ModelMapper modelMapper;

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAll() {

        return productRepository.getAll()
                .stream()
                .map(p -> modelMapper.map(p, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(int id) {
        return modelMapper.map(productRepository.getById(id),ProductDto.class);
    }
}
