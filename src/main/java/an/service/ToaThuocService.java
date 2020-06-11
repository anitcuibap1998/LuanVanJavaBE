package an.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.ToaThuoc;
import an.respository.ToaThuocRepository;

@Service
public class ToaThuocService {
	@Autowired
	ToaThuocRepository ToaThuocRepository;

	public Iterable<ToaThuoc> findAll() {
		return ToaThuocRepository.findAll();
	}
	public ToaThuoc saveOne(ToaThuoc toathuoc) {
		return ToaThuocRepository.save(toathuoc);
	}
	public ToaThuoc findAllByIdToa(int id) {
		ToaThuoc toathuoc1 = new ToaThuoc();
		List<ToaThuoc> list = (List<ToaThuoc>) ToaThuocRepository.findAll();
		for(ToaThuoc toathuoc: list) {
			if(toathuoc.getId()== id) {
				return toathuoc;
			}
		}
		return toathuoc1;
	}
}
