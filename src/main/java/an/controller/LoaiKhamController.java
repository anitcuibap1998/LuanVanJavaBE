package an.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import an.model.LoaiKham;
import an.service.LoaiKhamService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/loai_kham")
public class LoaiKhamController {

	@Autowired
	private LoaiKhamService loaiKhamService;
	
	@GetMapping("/getAll")
	public List<LoaiKham> getAll() {
		System.out.println((List<LoaiKham>) loaiKhamService.findAll());
		
		return (List<LoaiKham>) loaiKhamService.findAll();
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
