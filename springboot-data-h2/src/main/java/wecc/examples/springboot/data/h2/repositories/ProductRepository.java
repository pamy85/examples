package wecc.examples.springboot.data.h2.repositories;

import org.springframework.data.repository.CrudRepository;
import wecc.examples.springboot.data.h2.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findAll();

}
