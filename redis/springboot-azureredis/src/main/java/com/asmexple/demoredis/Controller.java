package com.asmexple.demoredis;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class Controller {

private final ProductService productService;

@GetMapping("product/{id}")
public Product getproduct(@PathVariable String id){
    return productService.getProduct(id);
}

@PostMapping("/product/add")
public Product addProduct(@RequestBody Product product){
    return productService.addProduct(product);
}

@GetMapping("products")
public List<Product> getproducts(){
    return productService.getProducts();
}


}
