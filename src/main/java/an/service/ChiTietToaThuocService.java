package an.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.ChiTietToaThuoc;
import an.respository.ChiTietToaThuocRepository;

@Service
public class ChiTietToaThuocService {
	@Autowired
	ChiTietToaThuocRepository chiTietToaThuocRepository;

	public Iterable<ChiTietToaThuoc> findAll() {
		return chiTietToaThuocRepository.findAll();
	}

	public ChiTietToaThuoc save(ChiTietToaThuoc chiTietToaThuoc) {
		return chiTietToaThuocRepository.save(chiTietToaThuoc);
	}
	public List<ChiTietToaThuoc> getListByToaThuoc(int id) {
		return chiTietToaThuocRepository.getListThuocByIdToa(id);
	}
	public int deleteByIdToaThuoc(int idToaThuoc) {
		return chiTietToaThuocRepository.deleteByIdToaThuoc(idToaThuoc);
	}
}