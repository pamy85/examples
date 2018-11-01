package wecc.examples.springboot.test.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wecc.examples.springboot.test.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private Map<String, Product> products;

    public ProductController(Map<String, Product> products) {
        this.products = products;
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> products() {
        return products.values().stream().collect(Collectors.toList());
    }

    @GetMapping("/product/{code}")
    public ResponseEntity<Product> productByCode(@PathVariable String code){
        Product product = products.get(code);
        if (Objects.isNull(product)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

}

