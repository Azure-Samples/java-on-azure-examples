package com.asmexple.demoredis;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public Product getProduct(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts(){
        Iterable<Product> iterable = productRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
        .collect(Collectors.toList());
    }




}
