package an.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import an.model.ChiTietToaThuoc;

public interface ChiTietToaThuocRepository extends JpaRepository<ChiTietToaThuoc, Integer>{

	@Query(value = "SELECT * FROM chi_tiet_thuoc  WHERE id_toa_thuoc = ?1", nativeQuery = true)
	List<ChiTietToaThuoc> getListThuocByIdToa(int id);
}
