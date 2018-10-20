package wecc.examples.springboot.security.advanced.repositories;

import org.springframework.data.repository.CrudRepository;
import wecc.examples.springboot.security.advanced.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
