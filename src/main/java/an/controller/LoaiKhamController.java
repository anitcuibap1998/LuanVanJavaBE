package an.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import an.model.LoaiKham;
import an.service.AuthenticationService;
import an.service.LoaiKhamService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/loai_kham")
public class LoaiKhamController {

	@Autowired
	private LoaiKhamService loaiKhamService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@GetMapping("/getAll")
	public Object getAll(@RequestHeader("tokenAC") String token) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		boolean result = authenticationService.xacThucUser(token);
		if(result) {
			System.out.println("object: "+result);
			System.out.println((List<LoaiKham>) loaiKhamService.findAll());
			return (List<LoaiKham>) loaiKhamService.findAll();
		}
		map.put("statusCode", 404);
		return map;
	}
	@GetMapping("/getOneById")
	public LoaiKham getOne(@RequestParam int id) {
		LoaiKham loaiKham2 = new LoaiKham();
		List<LoaiKham> list = (List<LoaiKham>) loaiKhamService.findAll();
		System.out.println((List<LoaiKham>) loaiKhamService.findAll());
		for(LoaiKham loaiKham : list) {
			if(loaiKham.getId()==id) {
				return loaiKham;
			}
		}
		return loaiKham2;
	}
	
}
