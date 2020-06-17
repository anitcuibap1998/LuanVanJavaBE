package an.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private UserService userService;

	@GetMapping("/getAll")
	public Object getAll(@RequestHeader("tokenAC") String token) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		//gọi hàm xác thực authentication
		Map<String, Integer> result =(Map<String, Integer>) TokenAC.xacThucUser(token);
		if(result!=null) {
		System.out.println("object: "+result);
		System.out.println("Mã Code-->: "+result.get("statusCode"));
		
		return (List<User>) userService.findAll();
		}else {
			Map<String, Integer> map = new HashMap<String, Integer>();
			return map.put("statusCode", 404);
		}
	}

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public Object getOneUserCustom(@RequestBody User user) {
		//khởi tạo biến kiểm soát logic
		boolean flag = true;
		Map<String, Object> mapResult = new HashMap<>(); 
		//sử lý code logic 
		User getuser = userService.getOneUser(user.getUsername(), MD5.getMd5(user.getPass()));
		System.out.println("---> " + getuser);
		if (getuser != null) {
			// goi ham create token
			String token = "";
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
			if (flag == true) {
				getuser.setToken(token);
				// lưu token mới tạo vào database để check
				int result = userService.updateTokenByUserName(token, getuser.getUsername());
			}
			return getuser;
		} else {
			mapResult.put("statusCode",404);
			return mapResult;
		}
	}
}
