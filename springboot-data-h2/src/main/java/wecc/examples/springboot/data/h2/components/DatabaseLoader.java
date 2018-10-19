package wecc.examples.springboot.data.h2.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wecc.examples.springboot.data.h2.repositories.ProductRepository;
import wecc.examples.springboot.data.h2.entities.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@Component
public class DatabaseLoader {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    private void initDatabase(){

        productRepository.save(
                new Product("001ABC","Coca-cola","Bebida", new BigDecimal(51.6))
        );

        productRepository.save(
                new Product("123123","Fanta","Bebida", new BigDecimal(45.3))
        );

        List<Product> productList = productRepository.findAll();
        productList.stream().forEach(product -> System.out.println("Code: " + product.getCode()));

    }

}
