package an.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import an.dto.ToaThuocDTO;
import an.model.LichHen;
import an.model.ToaThuoc;
import an.service.LichHenSevice;
import an.service.ToaThuocService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lich_su")
public class OtherController {
	@Autowired
	ToaThuocService toaThuocService;
	
	@Autowired
	LichHenSevice lichHenSevice;
	
	@GetMapping("/getAllByIdBenhNhan")
	public List<ToaThuocDTO> getAllByIdBenhNhan(@RequestParam int id) {
		List<ToaThuocDTO> list1 = new ArrayList<ToaThuocDTO>();
		System.out.println((List<ToaThuoc>) toaThuocService.findAll());
		List<ToaThuoc> list =(List<ToaThuoc>) toaThuocService.findAll();
		for(ToaThuoc toaThuoc : list) {
			if(toaThuoc.getId_benh_nhan()==id) {
				ToaThuocDTO dto = new ToaThuocDTO();
			
				LichHen  lichhen = lichHenSevice.findOneId(toaThuoc.getId_lich_hen());
				System.out.println(lichhen);
				dto.setLichHen(lichhen);
				dto.setChuan_doan(toaThuoc.getChuan_doan());
				dto.setId(toaThuoc.getId());
				dto.setId_bac_si(toaThuoc.getId_bac_si());
				dto.setId_benh_nhan(toaThuoc.getId_benh_nhan());
				dto.setId_gia_kham(toaThuoc.getId_gia_kham());
				
				dto.setId_lich_hen(toaThuoc.getId_lich_hen());
				dto.setNgay_ke_toa(toaThuoc.getNgay_ke_toa());
				list1.add(dto);
			}
		}
		return list1;
	}
	
	
	
	

}
