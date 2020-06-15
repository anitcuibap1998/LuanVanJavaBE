package an.respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import an.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username = ?1 and u.pass = ?2")
	User findUserByStatusAndName(String name, String pass);

}
