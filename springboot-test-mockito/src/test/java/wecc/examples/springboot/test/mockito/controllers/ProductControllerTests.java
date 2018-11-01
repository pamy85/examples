package wecc.examples.springboot.test.mockito.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wecc.examples.springboot.test.mockito.entities.Product;
import wecc.examples.springboot.test.mockito.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTests {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductController productController;

    private Product product1;
    private Product product2;

    @Before
    public void setUp(){
        product1 = new Product("CODE001","Lata de coca-cola","Lata de coca-cola de 33cl", BigDecimal.valueOf(0.51));
        product2 = new Product("CODE002","Huevos de campo","Huevos de campo 12 unidades", BigDecimal.valueOf(2.54));
        productController = new ProductController(productRepository);
    }

    @Test
    public void getProductsOK(){

        // given
        List<Product> expected = new LinkedList<>();
        expected.add(product1);
        expected.add(product2);

        // mock
        when(productRepository.findAll()).thenReturn(expected);

        // then
        List<Product> result = productController.products();

        // check
        Assert.assertEquals(result, expected);

    }

}
