package an.controller;

import java.util.List;

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

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService ;
	
	@PostMapping(path="/getOne" ,consumes = "application/json", produces = "application/json")
	public User getAll(
//			@RequestHeader("token") String token,
			@RequestBody User user) {
		//mã hóa MD5 password
//		System.out.println("mã token: "+token);
		String hashpass=MD5.getMd5(user.getPass());
		System.out.println(hashpass);
		User user2= new User();
		System.out.println("===Debug===");
		System.out.println(user);
		List<User> ds= (List<User>) userService.findAll();
		for(User u : ds) {
			if(u.getUsername().equals(user.getUsername())&& u.getPass().equals(hashpass)) {
					u.setPass("Đã Ẩn");
					return u;
			}
		}
		return user2;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll(@RequestHeader("token") String token) {
		System.out.println(token);
		System.out.println((List<User>) userService.findAll());
		return (List<User>) userService.findAll();
	}
}
