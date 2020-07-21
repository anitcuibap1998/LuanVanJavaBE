package an.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.ToaThuoc;
import an.respository.ToaThuocRepository;

@Service
public class ToaThuocService {
	@Autowired
	ToaThuocRepository toaThuocRepository;

	public Iterable<ToaThuoc> findAll() {
		return toaThuocRepository.findAll();
	}
	public ToaThuoc saveOne(ToaThuoc toathuoc) {
		return toaThuocRepository.save(toathuoc);
	}
	public ToaThuoc getOne(int id) {
		return toaThuocRepository.getOne(id);
	}

}
