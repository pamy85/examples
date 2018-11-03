package wecc.examples.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import wecc.examples.springboot.test.model.Product;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ExampleTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExampleTestApplication.class, args);
	}

	@Bean
	public Map<String, Product> products(){
		return new HashMap<>();
	}

}