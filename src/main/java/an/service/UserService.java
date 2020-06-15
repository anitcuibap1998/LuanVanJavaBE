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
    	return userRepository.findUserByStatusAndName(username, pass);
    }

}
