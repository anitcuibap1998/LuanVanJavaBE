package an.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import an.model.InfoPhongKham;
import an.model.ToaThuoc;
import an.service.AuthenticationService;
import an.service.BenhNhanService;
import an.service.ChiTietToaThuocService;
import an.service.InfoPhongKhamService;
import an.service.ThuocService;
import an.service.ToaThuocService;
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
	AuthenticationService authenticationService;
	@Autowired
	InfoPhongKhamService infoPhongKhamService;
	@Autowired
	BenhNhanService benhNhanService;
	@Autowired
	ChiTietToaThuocService chiTietToaThuocService;

	@PostMapping(path = "/addOneNull", consumes = "application/json", produces = "application/json")
	public Object addOne11(@RequestBody Object object) {
		System.out.println(object);
		System.out.println((object.getClass().getName()));
		System.out.println(object.getClass());
		System.out.println((object.getClass().getName()));

		Gson gson = new Gson();
		String jsonInString = object.toString();
		System.out.println(jsonInString);
		ToaThuocGSON resut = gson.fromJson(jsonInString, ToaThuocGSON.class);
		System.out.println(resut.getToaThuoc());
		System.out.println(resut.getListThuoc().get(0).getTenThuoc());
		return resut;
	}

	@GetMapping("/getAll")
	public List<ToaThuoc> getAll() {
		System.out.println((List<ToaThuoc>) toaThuocService.findAll());
		return (List<ToaThuoc>) toaThuocService.findAll();
	}

	@PostMapping(path = "/addOne", consumes = "application/json", produces = "application/json")
	public Object addOne(@RequestHeader("tokenAC") String token, @RequestBody ToaThuoc toaThuoc)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		boolean result = authenticationService.xacThucUser(token);
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (result) {
			System.out.println("toa Thuoc: " + toaThuoc);
			Date ngay = new Date();
			toaThuoc.setNgay_ke_toa(ngay);
			toaThuoc = toaThuocService.saveOne(toaThuoc);
			return toaThuoc;
		}
		map.put("statusCode", 404);
		return map;

	}

	// tạo ra 1 object về don thuoc gom co info user , info phong khám , toa thuoc ,
	// chi tiet thuoc.
	@GetMapping(path = "/detailDonThuoc")
	public Object getDetailDonThuoc(@RequestHeader("tokenAC") String token, @RequestParam int idToaThuoc)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {

		boolean result = authenticationService.xacThucUser(token);
		Map<String, Object> map = new HashMap<String, Object>();
		if (result) {
			// get info phong kham
			InfoPhongKham infoPhongKham = infoPhongKhamService.getOne();
			map.put("infoPhongKham", infoPhongKham);
			// getOne toa thuoc by id
			ToaThuoc toaThuoc = toaThuocService.getOne(idToaThuoc);
			map.put("infoToaThuoc", toaThuoc);
			// get info benh nhan
			BenhNhan benhNhan = benhNhanService.getOne((toaThuoc.getId_benh_nhan()));
			map.put("infoBenhNhan", benhNhan);
			// get list thuoc trong toa
			List<ChiTietToaThuoc> listThuocs = chiTietToaThuocService.getListByToaThuoc(idToaThuoc);
			map.put("listThuoc", listThuocs);
			return map;
		}
		map.put("statusCode", 404);
		return map;
	}

	@GetMapping(path = "/lichSuKhamAll")
	public Object lichSuKhamAll(@RequestHeader("tokenAC") String token) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

		boolean result = authenticationService.xacThucUser(token);
		Map<String, Object> map = new HashMap<String, Object>();
		ArrayList<Object> list = new ArrayList<>();
		if (result) {
			// Get List Toa Thuoc By All chưa có phân trang
			List<ToaThuoc> listObjectToaThuoc = (List<ToaThuoc>) toaThuocService.findAll();
			if (listObjectToaThuoc != null) {
				listObjectToaThuoc.forEach(item -> {
					// get user of toa thuoc
					BenhNhan benhNhan = benhNhanService.getOne(item.getId_benh_nhan());
					if(benhNhan==null) {
						benhNhan= new BenhNhan();
						benhNhan.setFull_name("Khong Tim Thay");
					}
					Map<String, Object> itemToaThuoc = new HashMap<String, Object>();
					String sex = "NAM";
					if (benhNhan.getSex() == 1) {
						sex = "Nam";
					} else if (benhNhan.getSex() == 1) {
						sex = "Nữ";
					} else {
						sex = "khác";
					}
					itemToaThuoc.put("maThuoc", item.getId());
					itemToaThuoc.put("tenBN", benhNhan.getFull_name());
					itemToaThuoc.put("sex", sex);
					itemToaThuoc.put("namSinh", benhNhan.getBirth_date());
					itemToaThuoc.put("chuanDoanBenh", item.getChuan_doan());
					itemToaThuoc.put("danDo", item.getDan_do());
					itemToaThuoc.put("ngayKeToa", item.getNgay_ke_toa());
					list.add(itemToaThuoc);
				});
				return list;
			} else {
				map.put("statusCode", 404);
				return map;
			}
		}
		map.put("statusCode", 404);
		return map;
	}
}
