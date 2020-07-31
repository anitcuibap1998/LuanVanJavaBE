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

import an.model.BenhNhan;
import an.service.AuthenticationService;
import an.service.BenhNhanService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/benh_nhan")
public class BenhNhanController {

	@Autowired
	private BenhNhanService benhNhanService;

	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping("/getAll")
	public Object getAll(@RequestHeader("tokenAC") String token,@RequestParam int index,@RequestParam int pageSize) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (result) {
			System.out.println("object: " + result);
			return (List<BenhNhan>) benhNhanService.findAll(index,pageSize);
		}
		map.put("statusCode", 404);
		return map;
	}

	@GetMapping("/timkiemTuongDoi")
	public Object timkiemTuongDoi(@RequestHeader("tokenAC") String token, @RequestParam String keysearch)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (result) {
			System.out.println("object: " + result);
			System.out.println((List<BenhNhan>) benhNhanService.timkiemTuongDoi(keysearch));
			List<BenhNhan> dSBN = (List<BenhNhan>) benhNhanService.timkiemTuongDoi(keysearch);
			if (dSBN.isEmpty()) {
				map.put("statusCode", 1000);
				return map;
			}
			return dSBN;
		}
		map.put("statusCode", 404);
		return map;
	}

	@PostMapping(path = "/addOne", consumes = "application/json", produces = "application/json")
	public Object addOne(@RequestHeader("tokenAC") String token, @RequestBody BenhNhan benhnhan)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		System.out.println("object: " + result);
		if (result) {
			return benhNhanService.save(benhnhan);
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("statusCode", 404);
		return map;
	}

	@GetMapping("/getOneBNLasted")
	public Object getBNLasted(@RequestHeader("tokenAC") String token) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		System.out.println("object: " + result);
		if (result) {
			return benhNhanService.getBNLasted();
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("statusCode", 404);
		return map;
	}

}
