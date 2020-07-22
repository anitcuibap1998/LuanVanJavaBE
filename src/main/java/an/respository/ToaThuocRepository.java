package an.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import an.model.ToaThuoc;

public interface ToaThuocRepository extends JpaRepository<ToaThuoc, Integer> {
	
	@Query(value = "SELECT * FROM Toa_thuoc Where id = ?1 ORDER BY id DESC", nativeQuery = true)
	ToaThuoc getToaThuocById(int id);
	
}
