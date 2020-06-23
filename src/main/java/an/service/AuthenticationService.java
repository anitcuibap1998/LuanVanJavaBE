package an.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.User;
import an.respository.UserRepository;
import an.util.TokenAC;

@Service
public class AuthenticationService {

	@Autowired
	UserRepository userRepository;
	public  boolean xacThucUser(String encrypted) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		System.out.println("vào hàm xác thực user--->");
		
		String object = TokenAC.decodeToken(encrypted);
		boolean flag = true;
		System.out.println("object to String: "+object.toString());
		//xử lý logic code xac thuc user
		if(object.equals("404")) {
			return false;
		}else {
			String[] words = object.toString().split(",");
			String username = words[1].trim();
			System.out.println("username: "+username);
			System.out.println("token: "+encrypted);
			try {
			encrypted = encrypted.trim();
			User result = userRepository.findUserByNameAndToken(username, encrypted);
			}catch (Exception e) {
				flag = false;
				System.out.println("lỗi: "+e);
			}finally {
				if(flag==true) {
					User result = userRepository.findUserByNameAndToken(username, encrypted);
					if(result != null) {
						System.out.println("Kết Quả: "+result);
						return true;
					}
				}
			}
		}
		return false;
	}
}
