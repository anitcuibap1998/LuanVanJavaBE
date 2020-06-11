package an.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import an.model.City;
import an.service.CitySevice;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/city")
public class CityController {
	@Autowired
	private CitySevice citySevice;
	
//lấy tất cả
	@GetMapping("/getAll")
	public List<City> getAll() {
		
		System.out.println((List<City>) citySevice.findAll());
		return (List<City>) citySevice.findAll();
	}
}
