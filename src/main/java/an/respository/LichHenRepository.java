package an.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import an.model.LichHen;

public interface LichHenRepository extends CrudRepository<LichHen, Integer>{
	@Query(value="SELECT * FROM lich_hen  WHERE date = ?1 ORDER BY time " , nativeQuery = true)
	List<LichHen> getListLichHenByDay(String date);
	
}
