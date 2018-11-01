package wecc.examples.springboot.test.mockito.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wecc.examples.springboot.test.mockito.entities.Product;
import wecc.examples.springboot.test.mockito.repositories.ProductRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class DatabaseLoader {

    private ProductRepository productRepository;

    @Autowired
    public DatabaseLoader(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void initDatabase(){

        productRepository.save(
                new Product("CODE001","Lata de coca-cola","Lata de coca-cola de 33cl", BigDecimal.valueOf(0.51))
        );

        productRepository.save(
                new Product("CODE002","Huevos de campo","Huevos de campo 12 unidades", BigDecimal.valueOf(2.54))
        );

    }

}
