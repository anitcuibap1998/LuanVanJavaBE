package an.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.ToaThuoc;
import an.respository.ToaThuocRepository;

@Service
public class ToaThuocService {
	@Autowired
	ToaThuocRepository toaThuocRepository;

	public List<ToaThuoc> findAll() {
		return toaThuocRepository.getAllDESC();
	}
	public ToaThuoc saveOne(ToaThuoc toathuoc) {
		return toaThuocRepository.save(toathuoc);
	}
	public ToaThuoc getOne(int id) {
		return toaThuocRepository.getToaThuocById(id);
	}
	public List<ToaThuoc> getListByIdBenhNhan(int idBenhNhan){
		return toaThuocRepository.getListByIdBenhNhan(idBenhNhan);
	}
	public ToaThuoc getListByIdToaThuoc(int idToaThuoc){
		return toaThuocRepository.getOneByIdToaThuoc(idToaThuoc);
	}

}
