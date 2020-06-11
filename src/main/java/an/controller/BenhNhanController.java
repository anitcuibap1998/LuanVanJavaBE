package an.controller;

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
import an.service.BenhNhanService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/benh_nhan")
public class BenhNhanController {

	@Autowired
	private BenhNhanService benhNhanService;
	
	@GetMapping("/getAll")
	public List<BenhNhan> getAll() {
		System.out.println((List<BenhNhan>) benhNhanService.findAll());
		return (List<BenhNhan>) benhNhanService.findAll();
	}
	
	@PostMapping(path="/addOne" ,consumes = "application/json", produces = "application/json")
	public BenhNhan addOne(@RequestBody BenhNhan benhnhan) {
		BenhNhan benhnhan2 = new BenhNhan();
		System.out.println("-----aaa-----");
		System.out.println(benhnhan);
		System.out.println("-----bbb-----");
		benhnhan2 = benhNhanService.save(benhnhan);
		return benhnhan2 ;
	}
	
	@GetMapping("/getOne")
	public BenhNhan getOne(@RequestParam int id) {
		BenhNhan benhnhan = new BenhNhan();
		System.out.println((List<BenhNhan>) benhNhanService.findAll());
		List<BenhNhan> listbn = (List<BenhNhan>) benhNhanService.findAll();
		for(BenhNhan a : listbn) {
			if(a.getId()==id)
			{
				return a;
			}
		}
		return benhnhan;
	}
}
