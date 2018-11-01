package wecc.examples.springboot.test.mockito.repositories;

import org.springframework.data.repository.CrudRepository;
import wecc.examples.springboot.test.mockito.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findAll();

}
