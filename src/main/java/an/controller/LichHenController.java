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

import an.model.LichHen;
import an.service.AuthenticationService;
import an.service.LichHenSevice;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lich_hen")
public class LichHenController {
	@Autowired
	private LichHenSevice lichHenSevice;
	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping("/getAllByDay")
	public Object getAllToDay(@RequestHeader("tokenAC") String token, @RequestParam String inputdate)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (result) {
			System.out.println("object: " + result);
			List<LichHen> kq = lichHenSevice.getListLichHenByDay(inputdate);
			if (kq.isEmpty()) {
				map.put("statusCode", 1000);
				return map;
			}
			return kq;
		}
		map.put("statusCode", 404);
		return map;
	}

	@GetMapping("/deleteLichHen")
	public Object deleteLichHen(@RequestHeader("tokenAC") String token, @RequestParam int idLH)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (result) {
			System.out.println("object: " + result);
			return lichHenSevice.deleteLichHenById(idLH);
		}
		map.put("statusCode", 404);
		return map;
	}

	@PostMapping(path = "/addOne", consumes = "application/json", produces = "application/json")
	public Object addOne(@RequestHeader("tokenAC") String token, @RequestBody LichHen lichhen)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (result) {
			System.out.println("Ngày Hẹn Lịch: " + lichhen.getDate());
			return lichHenSevice.save(lichhen);
		}
		map.put("statusCode", 404);
		return map;
	}
}
