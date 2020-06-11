package an.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import an.model.ChiTietToaThuoc;
import an.model.ToaThuoc;
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
	public Object addOne(@RequestBody ToaThuoc toaThuoc) {
		ToaThuoc toaThuoc2 =new ToaThuoc();
		Date ngay = new Date();
		toaThuoc.setNgay_ke_toa(ngay);
		toaThuoc2=toaThuocService.saveOne(toaThuoc);
		return toaThuoc2 ;
	}
	@GetMapping(path="/getAllByIdLichHen")
	public ToaThuoc getAllByIdLichHen(@RequestParam int id) {
		ToaThuoc toaThuoc = toaThuocService.findAllByIdToa(id);
		return toaThuoc;
	}
	
}
