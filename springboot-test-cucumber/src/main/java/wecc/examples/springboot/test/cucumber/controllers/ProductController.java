package wecc.examples.springboot.test.cucumber.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wecc.examples.springboot.test.cucumber.entities.Product;
import wecc.examples.springboot.test.cucumber.repositories.ProductRepository;

import java.util.List;

@RestController
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> products() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{code}")
    @ResponseStatus(HttpStatus.OK)
    public Product productByCode(@PathVariable String code) {
        return productRepository.findById(code).orElse(null);
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void product(@RequestBody Product product){
        productRepository.save(product);
    }

}

