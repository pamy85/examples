package wecc.examples.springboot.test.cucumber.repositories;

import org.springframework.data.repository.CrudRepository;
import wecc.examples.springboot.test.cucumber.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findAll();

}
