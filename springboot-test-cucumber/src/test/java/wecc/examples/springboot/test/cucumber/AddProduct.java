package wecc.examples.springboot.test.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import wecc.examples.springboot.test.cucumber.entities.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AddProduct {

    Map<String, Product> products = new HashMap<String, Product>();

    Product product = new Product();

    @Given("^I have a product <Product>$")
    public void i_have_a_product_Product() throws Throwable {
        product.setCode("CODE001");
        product.setName("Lata de coca-cola");
        product.setDescription("Lata de coca-cola de 33cl");
        product.setPrice(new BigDecimal(0.51));
    }

    @When("^Save the product <Product>$")
    public void save_the_product_Product() throws Throwable {
        products.put(product.getCode(), product);
    }

    @Then("^Returns <Product>$")
    public void returns_Product() throws Throwable {
        Product product = products.get("CODE001");
        Assert.assertEquals(product, this.product);
    }

}
