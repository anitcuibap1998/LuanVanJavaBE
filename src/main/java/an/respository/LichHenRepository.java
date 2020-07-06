package an.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import an.model.LichHen;

public interface LichHenRepository extends CrudRepository<LichHen, Integer>{
	@Query(value="SELECT * FROM lich_hen  WHERE date = ?1 ORDER BY time " , nativeQuery = true)
	List<LichHen> getListLichHenByDay(String date);
	@Transactional
	@Modifying
	@Query(value="DELETE FROM lich_hen WHERE id = ?1",nativeQuery = true)
	int deleteLichHenById(int idLH);
}
