package wecc.examples.springboot.test.mockito.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import wecc.examples.springboot.test.mockito.entities.Product;
import wecc.examples.springboot.test.mockito.repositories.ProductRepository;

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
        // TODO: change to database
        return productRepository.findAll();
    }

}

