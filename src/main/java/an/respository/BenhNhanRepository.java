package an.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import an.model.BenhNhan;

public interface BenhNhanRepository extends JpaRepository<BenhNhan, Integer>{

	@Query(value = "SELECT * FROM Benh_nhan  ORDER BY id DESC LIMIT 1", nativeQuery = true)
	BenhNhan findBenhNhanLasted();
}
