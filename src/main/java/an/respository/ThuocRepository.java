package an.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import an.model.Thuoc;

public interface ThuocRepository extends CrudRepository<Thuoc, Integer>{
	
	@Query(value = "SELECT * FROM thuoc  WHERE 	ten_thuoc like %?1%  ORDER BY ten_thuoc ", nativeQuery = true)
	List<Thuoc> findAllThuocByName(String keysearch);
	
}
