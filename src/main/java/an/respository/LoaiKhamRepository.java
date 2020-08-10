package an.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import an.model.LoaiKham;

public interface LoaiKhamRepository extends JpaRepository<LoaiKham, Integer>{
	@Query(value="SELECT * FROM gia_kham u WHERE u.id = ?1",nativeQuery = true)
	LoaiKham findLoaiKhamById(int id);
}
