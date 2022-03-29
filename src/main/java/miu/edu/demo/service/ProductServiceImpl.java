package miu.edu.demo.service;

import miu.edu.demo.domain.Product;
import miu.edu.demo.domain.dto.ProductDto;
import miu.edu.demo.repo.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
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

    @Override
    public void save(ProductDto productDto) {
        productRepository.save(modelMapper.map(productDto,Product.class));
    }

    @Override
    public void update(int id, ProductDto productDto) {
        ProductDto dto = findById(id);
        productDto.setId(dto.getId());
        if(Optional.of(dto).isPresent()){
           productRepository.update(modelMapper.map(productDto,Product.class));
        }
    }

    @Override
    public void delete(int id) {
        ProductDto productDto = findById(id);
        if(Optional.of(productDto).isPresent()){
            productRepository.delete(id);
        }
    }
}
