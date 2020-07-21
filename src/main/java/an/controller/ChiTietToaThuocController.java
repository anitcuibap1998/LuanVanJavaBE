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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import an.model.ChiTietToaThuoc;
import an.model.Thuoc;
import an.model.ToaThuoc;
import an.service.AuthenticationService;
import an.service.ChiTietToaThuocService;
import an.service.ThuocService;
import an.service.ToaThuocService;
import dto.OneToa;
import dto.OneToa2;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/chi_tiet_toa_thuoc")
public class ChiTietToaThuocController {
	@Autowired
	ChiTietToaThuocService chiTietThuocService;
	@Autowired
	ToaThuocService toaThuocService;
	@Autowired
	ThuocService thuocService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping(path="/addOne" ,consumes = "application/json", produces = "application/json")
	public Object addOne(@RequestHeader("tokenAC") String token,@RequestBody List<ChiTietToaThuoc> list) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(result) {
			for(ChiTietToaThuoc chiTietToaThuoc : list) {
				chiTietThuocService.save(chiTietToaThuoc);
			}
			return list ;
		}
		map.put("statusCode", 404);
		return map;
		
	}
	@GetMapping(path="/getAll")
	public List<ChiTietToaThuoc> getAll() {
		return (List<ChiTietToaThuoc>) chiTietThuocService.findAll();
	}
	
	

	
}
