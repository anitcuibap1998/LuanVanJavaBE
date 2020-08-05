package an.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import an.model.ChiTietToaThuoc;

public interface ChiTietToaThuocRepository extends JpaRepository<ChiTietToaThuoc, Integer>{

	@Query(value = "SELECT ctt.id as id, ctt.id_toa_thuoc as id_toa_thuoc,ctt.id_thuoc as id_thuoc,ctt.so_luong_thuoc as so_luong_thuoc, ctt.cach_dung as cach_dung, t.don_vi_tinh as don_vi_tinh, t.ham_luong as ham_luong, t.ten_thuoc as ten_thuoc FROM chi_tiet_thuoc as ctt LEFT JOIN thuoc as t ON ctt.id_thuoc = t.id_thuoc WHERE id_toa_thuoc = ?1", nativeQuery = true)
	List<ChiTietToaThuoc> getListThuocByIdToa(int id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM `chi_tiet_thuoc` WHERE id_toa_thuoc = ?1", nativeQuery = true)
	int deleteByIdToaThuoc(int id);
}
