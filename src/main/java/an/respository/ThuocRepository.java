package an.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import an.model.Thuoc;

public interface ThuocRepository extends JpaRepository<Thuoc, Integer>{
	
	@Query(value = "SELECT * FROM thuoc  WHERE 	ten_thuoc like %?1%  ORDER BY ten_thuoc ", nativeQuery = true)
	List<Thuoc> findAllThuocByName(String keysearch);

	@Query(value = "SELECT * FROM thuoc  WHERE 	id = ?1", nativeQuery = true)
	Thuoc getThuocById(int id);
}
