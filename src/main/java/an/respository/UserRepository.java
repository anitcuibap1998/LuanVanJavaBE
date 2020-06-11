package an.respository;

import org.springframework.data.repository.CrudRepository;

import an.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
