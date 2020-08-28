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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import an.model.BenhNhan;
import an.service.AuthenticationService;
import an.service.BenhNhanService;
import an.util.JavaEmailSender;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/benh_nhan")
public class BenhNhanController {

	@Autowired
	private BenhNhanService benhNhanService;

	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping("/getAll")
	public Object getAll(@RequestHeader("tokenAC") String token, @RequestParam int index, @RequestParam int pageSize)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (result) {
			System.out.println("object: " + result);
			return (List<BenhNhan>) benhNhanService.findAll(index, pageSize);
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
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("object: " + result);
		if (result) {

//			BenhNhan benhNhanCheck = benhNhanService.getOnePhone(benhnhan.getPhone());		
//			if(benhNhanCheck!=null) {
//				map.put("statusCode", 999);
//				map.put("message", "Số Điện Thoại Đã Tồn Tại");
//				return map;
//			}
//			benhNhanCheck = benhNhanService.getOneMail(benhnhan.getMail());
//			if(benhNhanCheck!=null) {
//				map.put("statusCode", 999);
//				map.put("message", "Email Đã Tồn Tại");
//				return map;
//			}
			BenhNhan bn = benhNhanService.save(benhnhan);
			if (bn.getMail() != null) {
				String email = bn.getMail();
				String tieuDe = "Phòng Khám Xin Thông Báo";
				String content = "Tạo Thành Công Bệnh Nhân Với Thông Tin Bạn Công Cấp, Mã Bệnh Nhân Của Bạn Là: "
						+ bn.getId();
				JavaEmailSender.sendMailUtil(email, tieuDe, content);
			}

			return bn;
		}
		map.put("statusCode", 404);
		map.put("message", "Bạn Không Có Đủ Quyền Để Thực Hiện Thao Tác Này !!!");
		return map;
	}

	@PutMapping(path = "/editOne", consumes = "application/json", produces = "application/json")
	public Object editOne(@RequestHeader("tokenAC") String token, @RequestBody BenhNhan benhnhan,@RequestParam int idBenhNhan)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("object: " + result);
		if (result) {
			BenhNhan bnBeforeEdit = benhNhanService.getOne(idBenhNhan);
			System.out.println("aaaa");
			System.out.println(bnBeforeEdit);
			System.out.println(bnBeforeEdit.getUser_update());
			System.out.println(bnBeforeEdit.getCreate_date());
			System.out.println("aaaa");
//			BenhNhan benhNhanCheck = benhNhanService.getOnePhone(benhnhan.getPhone());		
//			if(benhNhanCheck!=null) {
//				map.put("statusCode", 999);
//				map.put("message", "Số Điện Thoại Đã Tồn Tại");
//				return map;
//			}
//			benhNhanCheck = benhNhanService.getOneMail(benhnhan.getMail());
//			if(benhNhanCheck!=null) {
//				map.put("statusCode", 999);
//				map.put("message", "Email Đã Tồn Tại");
//				return map;
//			}
			benhnhan.setUser_create(bnBeforeEdit.getUser_update());
			benhnhan.setCreate_date(bnBeforeEdit.getCreate_date());
			BenhNhan bn = benhNhanService.save(benhnhan);
			if (bn.getMail() != null) {
				String email = bn.getMail();
				String tieuDe = "Phòng Khám Xin Thông Báo";
				String content = "Sửa Thành Công Bệnh Nhân Với Thông Tin Bạn Công Cấp, Mã Bệnh Nhân Bạn Sửa Là: "
						+ bn.getId();
				JavaEmailSender.sendMailUtil(email, tieuDe, content);
			}
			return bn;
		}
		map.put("statusCode", 404);
		map.put("message", "Bạn Không Có Đủ Quyền Để Thực Hiện Thao Tác Này !!!");
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
