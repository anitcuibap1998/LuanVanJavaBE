package an.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import an.model.ChiTietToaThuoc;
import an.model.Thuoc;
import an.model.ToaThuoc;
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
	@PostMapping(path="/addOne" ,consumes = "application/json", produces = "application/json")
	public List<ChiTietToaThuoc> addOne(@RequestBody List<ChiTietToaThuoc> list) {
		
		for(ChiTietToaThuoc chiTietToaThuoc : list) {
			chiTietThuocService.save(chiTietToaThuoc);
		}
		return list ;
	}
	@GetMapping(path="/getAll")
	public List<ChiTietToaThuoc> getAll() {
		return (List<ChiTietToaThuoc>) chiTietThuocService.findAll();
	}
	
	
	@GetMapping(path="/getAllByIdToa")
	public OneToa getAllByIdToa(@RequestParam int id) {
		OneToa toa = new OneToa();
		List<ChiTietToaThuoc> chiTiets = chiTietThuocService.findAllByIdToa(id);
		ToaThuoc toaThuoc = toaThuocService.findAllByIdToa(id);
		toa.setLists(chiTiets);
		toa.setToaThuoc(toaThuoc);
		return toa;
	}
	@GetMapping(path="/getAllByIdToaFull")
	public OneToa2 getAllByIdToaFull(@RequestParam int id) {
		OneToa2 toa = new OneToa2();
		List<Thuoc> listThuoc = new ArrayList<Thuoc>();
		List<ChiTietToaThuoc> chiTiets = chiTietThuocService.findAllByIdToa(id);
		for (ChiTietToaThuoc chiTietToaThuoc : chiTiets) {
			listThuoc.add(thuocService.getOneByIdThuoc(chiTietToaThuoc.getId_thuoc()));
		}
		ToaThuoc toaThuoc = toaThuocService.findAllByIdToa(id);
		toa.setLists(chiTiets);
		toa.setToaThuoc(toaThuoc);
		toa.setThuoc(listThuoc);
		return toa;
	}
	
}