package an.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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

import com.google.gson.Gson;

import an.model.BenhNhan;
import an.model.ChiTietToaThuoc;
import an.model.ToaThuoc;
import an.service.AuthenticationService;
import an.service.ThuocService;
import an.service.ToaThuocService;
import dto.OneToa;
import dto.ToaThuocGSON;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/toa_thuoc")
public class ToaThuocController {
	@Autowired
	ToaThuocService toaThuocService;
	@Autowired
	ThuocService thuocService;
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping(path="/addOneNull" ,consumes = "application/json", produces = "application/json")
	public Object addOne11(@RequestBody Object object) {
		System.out.println(object);
		System.out.println((object.getClass().getName()));
		System.out.println(object.getClass());
		System.out.println((object.getClass().getName()));
		
		Gson gson = new Gson();
		String jsonInString = object.toString();
		System.out.println(jsonInString);
		ToaThuocGSON resut= gson.fromJson(jsonInString, ToaThuocGSON.class);
		System.out.println(resut.getToaThuoc());
		System.out.println(resut.getListThuoc().get(0).getTenThuoc());
		return resut ;
	}
	@GetMapping("/getAll")
	public List<ToaThuoc> getAll() {
		System.out.println((List<ToaThuoc>) toaThuocService.findAll());
		return (List<ToaThuoc>) toaThuocService.findAll();
	}
	@PostMapping(path="/addOne" ,consumes = "application/json", produces = "application/json")
	public Object addOne(@RequestHeader("tokenAC") String token,@RequestBody ToaThuoc toaThuoc) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(result) {
			System.out.println("toa Thuoc: "+ toaThuoc);			
			Date ngay = new Date();
			toaThuoc.setNgay_ke_toa(ngay);
			toaThuoc=toaThuocService.saveOne(toaThuoc);
			return toaThuoc ;
		}
		map.put("statusCode", 404);
		return map;
		
	}
	@GetMapping(path="/getAllByIdLichHen")
	public ToaThuoc getAllByIdLichHen(@RequestParam int id) {
		ToaThuoc toaThuoc = toaThuocService.findAllByIdToa(id);
		return toaThuoc;
	}
	@GetMapping(path="/getAllByIdBenhNhan")
	public Object getAllByIdBenhNhan(@RequestParam int id) {
		ToaThuoc toaThuoc = toaThuocService.findAllByIdToa(id);
		return toaThuoc;
	}
	
}
