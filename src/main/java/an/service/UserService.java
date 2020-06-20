package an.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.User;
import an.respository.UserRepository;
import an.util.TokenAC;

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
    
    public User getOneUserByName(String token) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
    	System.out.println("Vào Hàm getOneUserByName");
    	String giaimaToken = TokenAC.decodeToken(token);
    	String[] word = giaimaToken.split(",");
    	User user = userRepository.findUserByName(word[1].toString());
    	if(user!=null) {
    		return user;
    	}
    	User usernull = new User();
    	return usernull;
    }

}
