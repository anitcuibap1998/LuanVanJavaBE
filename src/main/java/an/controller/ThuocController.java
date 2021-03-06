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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import an.model.Thuoc;
import an.service.AuthenticationService;
import an.service.ThuocService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/thuoc")
public class ThuocController {
	@Autowired
	private ThuocService thuocService;
	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping("/getAll")
	public List<Thuoc> getAll() {
		System.out.println((List<Thuoc>) thuocService.findAll());
		return (List<Thuoc>) thuocService.findAll();
	}

	@PostMapping(path = "/addOne", consumes = "application/json", produces = "application/json")
	public Thuoc addOne(@RequestBody Thuoc thuoc) {
		Thuoc thuoc2 = new Thuoc();

		thuoc2 = thuocService.save(thuoc);
		return thuoc2;
	}

	// get List thuoc theo ten
	@GetMapping("/getListByName")
	public Object getListByName(@RequestHeader("tokenAc") String token, @RequestParam String name)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		boolean result = authenticationService.xacThucUser(token);
		if (name.isEmpty()) {
			map.put("statusCode", 1000);
			return map;
		}
		if (result) {
			System.out.println("object: " + result);
			// System.out.println((List<Thuoc>) thuocService.getListThuocByName(name);
			List<Thuoc> listThuoc = (List<Thuoc>) thuocService.getListThuocByName(name);
			if (listThuoc.isEmpty()) {
				map.put("statusCode", 1000);
				return map;
			}
			return listThuoc;
		}
		map.put("statusCode", 404);
		return map;
	}

	// get List thuoc all lazy load
	@GetMapping("/getListThuocLazyLoad")
	public Object getListThuocLazyLoad(@RequestHeader("tokenAc") String token, @RequestParam int index,
			@RequestParam int pageSize) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean result = authenticationService.xacThucUser(token);
		if (result) {
			System.out.println("Role: " + result);
			List<Thuoc> listThuoc = (List<Thuoc>) thuocService.getListThuocLazyLoad(index, pageSize);
			if (listThuoc.isEmpty()) {
				map.put("statusCode", 1000);
				map.put("message", "Không Còn Gì Để Load Nữa");
				return map;
			}
			return listThuoc;
		}
		map.put("statusCode", 403);
		map.put("message", "Bạn Không Có Đủ Quyền Để Thực Hiện Hành Động Này");
		return map;
	}

}
