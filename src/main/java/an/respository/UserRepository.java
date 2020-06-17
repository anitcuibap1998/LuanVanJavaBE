package an.respository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import an.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username = ?1 and u.pass = ?2")
	User findUserByNameAndPass(String name, String pass);
	
	@Transactional
	@Modifying
	@Query("UPDATE User SET token = ?1 WHERE username = ?2")
	int updateTokenByUserName(String tokenAC, String username);
	
	@Query("SELECT u FROM User u WHERE u.username = ?1 and u.token = ?2")
	User findUserByNameAndToken(String name, String token);
	

}
