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
		return thuocRepository.getThuocById(id);
	}
	//get list thuoc by name
	public List<Thuoc> getListThuocByName(String name){
		return thuocRepository.findAllThuocByName(name);
	}
	//get all list thuoc lazy load 
	public List<Thuoc> getListThuocLazyLoad(int index,int pageSize){
		int offset = index * pageSize;
		return thuocRepository.getListThuocLazyLoad(offset, pageSize);
	}
}
