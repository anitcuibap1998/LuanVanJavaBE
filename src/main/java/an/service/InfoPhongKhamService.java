package an.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.InfoPhongKham;
import an.respository.InfoPhongKhamRepository;

@Service
public class InfoPhongKhamService {

	@Autowired
	InfoPhongKhamRepository infoPhongKhamRepository;

	public InfoPhongKham getOne() {
		return infoPhongKhamRepository.getOne();
	}
}
