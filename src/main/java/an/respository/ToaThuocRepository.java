package an.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import an.model.ToaThuoc;

public interface ToaThuocRepository extends JpaRepository<ToaThuoc, Integer> {
	
	@Query(value = "SELECT * FROM Toa_thuoc ORDER BY id DESC", nativeQuery = true)
	List<ToaThuoc> getAllDESC();
	
	@Query(value = "SELECT * FROM Toa_thuoc Where id = ?1", nativeQuery = true)
	ToaThuoc getToaThuocById(int id);
	
}
