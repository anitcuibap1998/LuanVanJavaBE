package an.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import an.model.Thuoc;
import an.service.ThuocService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/thuoc")
public class ThuocController {
	@Autowired
	private ThuocService thuocService;
	
	@GetMapping("/getAll")
	public List<Thuoc> getAll() {
		System.out.println((List<Thuoc>) thuocService.findAll());
		return (List<Thuoc>) thuocService.findAll();
	}
	
	@PostMapping(path="/addOne" ,consumes = "application/json", produces = "application/json")
	public Thuoc addOne(@RequestBody Thuoc thuoc) {
		Thuoc thuoc2 = new Thuoc();
		
		thuoc2 = thuocService.save(thuoc);
		return thuoc2 ;
	}
	
}
