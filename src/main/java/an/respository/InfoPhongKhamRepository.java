package an.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import an.model.InfoPhongKham;

public interface InfoPhongKhamRepository extends JpaRepository<InfoPhongKham, Integer> {

	@Query(value = "SELECT * FROM info_hospital  WHERE 	id = 1", nativeQuery = true)
	InfoPhongKham getOne();
}
