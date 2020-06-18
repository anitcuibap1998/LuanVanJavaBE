package an.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.User;
import an.respository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
    public User getOneUser(String username, String pass) {
    	return userRepository.findUserByNameAndPass(username, pass);
    }
    public int updateTokenByUserName(String token, String username) {
    	return userRepository.updateTokenByUserName(token, username);
    }
    
    public User getOneUserByToken(String username, String token) {
    	User user = new User();
    	user = userRepository.findUserByNameAndToken(username,token);
    	return user;
    }

}
