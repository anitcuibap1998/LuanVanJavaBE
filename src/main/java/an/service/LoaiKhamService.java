package an.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.LoaiKham;
import an.respository.LoaiKhamRepository;

@Service
public class LoaiKhamService {
	@Autowired
	LoaiKhamRepository khamRepository;

	public Iterable<LoaiKham> findAll() {
		return khamRepository.findAll();
	}
	public LoaiKham save(LoaiKham kham) {
		return khamRepository.save(kham);
	}
}
