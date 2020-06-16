package an.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import an.model.User;
import an.service.UserService;
import an.util.MD5;
import an.util.TokenAC;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService ;
	
//	@PostMapping(path="/getOne" ,consumes = "application/json", produces = "application/json")
//	public User getAll(
////			@RequestHeader("token") String token,
//			@RequestBody User user) {
//		//mã hóa MD5 pass
////		System.out.println("mã token: "+token);
//		String hashpass=MD5.getMd5(user.getPass());
//		System.out.println(hashpass);
//		User user2= new User();
//		System.out.println("===Debug===");
//		System.out.println(user);
//		List<User> ds= (List<User>) userService.findAll();
//		for(User u : ds) {
//			if(u.getUsername().equals(user.getUsername())&& u.getPass().equals(hashpass)) {
//					u.setPass("Đã Ẩn");
//					return u;
//			}
//		}
//		return user2;
//	}
	
	@GetMapping("/getAll")
	public List<User> getAll(@RequestHeader("tokenAC") String token) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		System.out.println(token);
		String userAC = TokenAC.decodeToken(token);
		System.out.println("giai Ma: "+userAC);
		System.out.println((List<User>) userService.findAll());
		return (List<User>) userService.findAll();
	}
	
	@PostMapping(path="/login" ,consumes = "application/json", produces = "application/json")
	public Object getOneUserCustom(@RequestBody User user) {
		boolean flag = true;	
		User getuser = userService.getOneUser(user.getUsername(), MD5.getMd5(user.getPass()));
		System.out.println("---> "+getuser);
		if(getuser !=null) {
			//goi ham create token 
			String token  ="";
				try {
					token = TokenAC.encodeToken(getuser);
				} catch (InvalidKeyException e) {
					flag = false;
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					flag = false;
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					flag = false;
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					flag = false;
					e.printStackTrace();
				} catch (BadPaddingException e) {
					flag = false;
					e.printStackTrace();
				}
				if(flag==true) {
					getuser.setToken(token);
				}
		return getuser;
		}
		else{
			return 404;
		}
	}
}
