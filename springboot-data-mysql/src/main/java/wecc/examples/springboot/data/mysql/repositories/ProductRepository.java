package wecc.examples.springboot.data.mysql.repositories;

import org.springframework.data.repository.CrudRepository;
import wecc.examples.springboot.data.mysql.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findAll();

}
