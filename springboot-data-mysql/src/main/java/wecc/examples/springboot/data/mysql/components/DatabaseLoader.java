package wecc.examples.springboot.data.mysql.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wecc.examples.springboot.data.mysql.entities.Product;
import wecc.examples.springboot.data.mysql.repositories.ProductRepository;

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
