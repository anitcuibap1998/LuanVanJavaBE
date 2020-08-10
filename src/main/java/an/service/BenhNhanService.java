package an.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.BenhNhan;
import an.respository.BenhNhanRepository;

@Service
public class BenhNhanService {

	@Autowired
	BenhNhanRepository benhNhanRepository;

	public List<BenhNhan> findAll(int index, int pageSize) {
		int totalPage = index * pageSize; 
		return benhNhanRepository.findAllDESC(totalPage,pageSize);
	}

	public BenhNhan  save(BenhNhan benhnhan) {
		return benhNhanRepository.save(benhnhan);
	}
	
	public BenhNhan getBNLasted() {
		return benhNhanRepository.findBenhNhanLasted();
	}
	public List<BenhNhan> timkiemTuongDoi(String keysearch){
		System.out.println("vào service bệnh nhân.");
		System.out.println(keysearch);
		return benhNhanRepository.timKiemTuongDoi(keysearch);
	}
	public BenhNhan getOne(int id) {
		return benhNhanRepository.getOneBenhNhan(id);
	}
	public BenhNhan getOnePhone(int phone) {
		return benhNhanRepository.getOneBenhNhanByPhone(phone);
	}
}
