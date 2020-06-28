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

import an.model.BenhNhan;
import an.model.LichHen;
import an.service.BenhNhanService;
import an.service.LichHenSevice;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/lich_hen")
public class LichHenController {
	@Autowired
	private LichHenSevice lichHenSevice;
	@Autowired
	private BenhNhanService benhNhanSevice;
	
	
	@GetMapping("/getAllByDate")
	public List<LichHen> getAll() {
		System.out.println((List<LichHen>) lichHenSevice.findAll());
		
		return (List<LichHen>) lichHenSevice.findAll();
	}
	@GetMapping("/getOneById")
	public LichHen getOne(@RequestParam int id) {
		LichHen lichHen = new LichHen();
		List<LichHen> lists=(List<LichHen>) lichHenSevice.findAll();
		System.out.println((List<LichHen>) lichHenSevice.findAll());
		for(LichHen lh : lists) {
			if(lh.getId()==id) {
				return lh;
			}
		}
		return lichHen;
	}
	@GetMapping("/getAllToDay")
	public List<LichHen> getAllToDay(@RequestParam String inputdate) {
		System.out.println(inputdate);
		System.out.println((List<LichHen>) lichHenSevice.findAll());
		List<LichHen> results = new ArrayList<LichHen>();
		List<LichHen> list=(List<LichHen>) lichHenSevice.findAll();
		for(LichHen lichhen : list) {
			  
			String[] words=lichhen.getDate().toString().split("\\s");//chia chuoi dua tren string phan cach nhau boi khoang trang (\\s) 
			//su dung vong lap foreach de in cac phan tu trong mang chuoi  
			System.out.println(words[0]);
			if(words[0].equals(inputdate)) {
				results.add(lichhen);
			}
			
		}
		return results;
	}
	
	@PostMapping(path="/addOne" ,consumes = "application/json", produces = "application/json")
	public LichHen addOne(@RequestBody LichHen lichhen) {
		LichHen lichhen2 = new LichHen();
		lichhen.setStatus("booked");
		System.out.println("-----aaa-----");
		System.out.println(lichhen);
		System.out.println("-----bbb-----");
		System.out.println(lichhen.getId_benh_nhan());
		//get all tim mot 
		List<BenhNhan> listbn = (List<BenhNhan>) benhNhanSevice.findAll();
		for(BenhNhan a : listbn) {
			if(a.getId()==lichhen.getId_benh_nhan())
			{
				lichhen.setLast_name(a.getFull_name());
			}
		}
		lichhen2 = lichHenSevice.save(lichhen);
		return lichhen2 ;
	}
}
