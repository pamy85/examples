package wecc.examples.springboot.test.selenium.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wecc.examples.springboot.test.selenium.environment.EnvironmentManager;
import wecc.examples.springboot.test.selenium.environment.RunEnvironment;

public class ProductTests {

    @Before
    public void startBrowser() {
//        EnvironmentManager.initChromeWebDriver();
        EnvironmentManager.initFirefoxWebDriver();
    }

    @Test
    public void addProduct() {
        WebDriver driver = RunEnvironment.getWebDriver();
        driver.get("http://localhost:8080");

        // add product
        driver.findElement(By.id("add")).click();
        driver.findElement(By.id("code")).sendKeys("CODE001");
        driver.findElement(By.id("name")).sendKeys("Lata de coca-cola");
        driver.findElement(By.id("description")).sendKeys("Lata de coca-cola de 33cl");
        driver.findElement(By.id("price")).sendKeys("0.51");
        driver.findElement(By.id("add")).click();

        Assert.assertEquals("CODE001",driver.getTitle());
    }

    @Test
    public void listProduct() {
        WebDriver driver = RunEnvironment.getWebDriver();
        driver.get("http://localhost:8080");

        // product list
        driver.findElement(By.id("list")).click();

        Assert.assertEquals("http://localhost:8080/list",driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }

}
