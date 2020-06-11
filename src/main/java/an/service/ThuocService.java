package an.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.Thuoc;
import an.respository.ThuocRepository;

@Service
public class ThuocService {
	
	@Autowired
	ThuocRepository thuocRepository;

	public Iterable<Thuoc> findAll() {
		return thuocRepository.findAll();
	}
	
	public Thuoc save(Thuoc thuoc) {
		return thuocRepository.save(thuoc);
	}
	public Thuoc getOneByIdThuoc(int id) {
		Thuoc thuoc3 = new Thuoc();
		List<Thuoc> list =  (List<Thuoc>) thuocRepository.findAll();
		for(Thuoc thuoc: list) {
			if(thuoc.getId_thuoc()==id)
			{
				return thuoc;
			}
		}
		return thuoc3;
	}
}
