package an.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.LichHen;
import an.respository.LichHenRepository;


@Service
public class LichHenSevice {
	 @PersistenceUnit
	 private EntityManagerFactory emf;
	
	@Autowired
	LichHenRepository lichHenRepository;
	
	public Iterable<LichHen> findAll() {
		return lichHenRepository.findAll();
	}
	
	public List<LichHen> getListLichHenByDay(String date){
		return (List<LichHen>) lichHenRepository.getListLichHenByDay(date);
	}	
	
	public LichHen  save(LichHen lichhen) {
		return lichHenRepository.save(lichhen);
	}
	public LichHen findOneId(int id_lich_hen) {
		LichHen hen1 = new LichHen(); 
		List<LichHen> list = (List<LichHen>) lichHenRepository.findAll();
		for(LichHen hen :list) {
			if(hen.getId()==id_lich_hen) {
				return hen;
			}
		}
		return hen1;
	}

}
