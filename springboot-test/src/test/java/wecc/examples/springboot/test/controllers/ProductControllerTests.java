package wecc.examples.springboot.test.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wecc.examples.springboot.test.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTests {

    private ProductController productController;
    private Map<String, Product> testData = new HashMap<>();

    @Before
    public void setUp(){
        testData.put("CODE001", new Product("CODE001","Lata de coca-cola","Lata de coca-cola de 33cl", new BigDecimal(0.51)));
        testData.put("CODE002", new Product("CODE002","Huevos de campo","Huevos de campo 12 unidades", new BigDecimal(2.54)));
        productController = new ProductController(testData);
    }

    @Test
    public void getProductsOK(){
        List<Product> result = productController.products();
        List<Product> expected = testData.values().stream().collect(Collectors.toList());

        Assert.assertEquals(result, expected);
    }

    @Test
    public void getProductByCodeOK(){
        String codeTest = "CODE001";
        ResponseEntity<Product> result = productController.productByCode(codeTest);
        Product expected = testData.get(codeTest);

        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result.getBody(), expected);
    }

    @Test
    public void getProductByCodeKO(){
        String codeTest = "invented";
        ResponseEntity<Product> result = productController.productByCode(codeTest);

        Assert.assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
    }

}
