package wecc.examples.springboot.data.mongo.repositories;

import org.springframework.data.repository.CrudRepository;
import wecc.examples.springboot.data.mongo.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findAll();

}
