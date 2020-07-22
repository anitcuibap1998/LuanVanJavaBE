package an.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import an.model.LichHen;

public interface LichHenRepository extends JpaRepository<LichHen, Integer>{
	@Query(value="SELECT * FROM lich_hen  WHERE date = ?1 ORDER BY time " , nativeQuery = true)
	List<LichHen> getListLichHenByDay(String date);
	
	@Query(value="SELECT * FROM lich_hen  WHERE id = ?1 " , nativeQuery = true)
	LichHen findOneId(int id);
	@Transactional
	@Modifying
	@Query(value="DELETE FROM lich_hen WHERE id = ?1",nativeQuery = true)
	int deleteLichHenById(int idLH);
}
