package an.service;

import java.util.ArrayList;
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

	public ChiTietToaThuoc  save(ChiTietToaThuoc benhnhan) {
		return chiTietToaThuocRepository.save(benhnhan);
	}
	public List<ChiTietToaThuoc> findAllByIdToa(int id) {
		List<ChiTietToaThuoc> list1 = new ArrayList<ChiTietToaThuoc>();
		List<ChiTietToaThuoc> list = (List<ChiTietToaThuoc>) chiTietToaThuocRepository.findAll();
		for(ChiTietToaThuoc chiTietToaThuoc : list) {
			if(chiTietToaThuoc.getId_toa_thuoc()==id) {
				list1.add(chiTietToaThuoc);
			}
		}	
		
		 return list1;
	}
	public List<ChiTietToaThuoc> findAllByIdLichHen(int id) {
		List<ChiTietToaThuoc> list1 = new ArrayList<ChiTietToaThuoc>();
		List<ChiTietToaThuoc> list = (List<ChiTietToaThuoc>) chiTietToaThuocRepository.findAll();
		for(ChiTietToaThuoc chiTietToaThuoc : list) {
//			if(chiTietToaThuoc.==id) {
//				list1.add(chiTietToaThuoc);
//			}
		}	
		
		 return list1;
	}

}
