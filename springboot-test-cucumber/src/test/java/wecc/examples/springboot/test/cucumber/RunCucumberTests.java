package wecc.examples.springboot.test.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        plugin = {
                "pretty"
        }
)
public class RunCucumberTests {
}
