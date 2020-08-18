package an.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import an.model.BenhNhan;

public interface BenhNhanRepository extends JpaRepository<BenhNhan, Integer>{

	@Query(value = "SELECT * FROM Benh_nhan  ORDER BY id DESC LIMIT 1", nativeQuery = true)
	BenhNhan findBenhNhanLasted();
	
	@Query(value = "SELECT * FROM Benh_nhan  ORDER BY id DESC limit ?1,?2", nativeQuery = true)
	List<BenhNhan> findAllDESC(int index,int pageSize);
	//tìm kiếm bệnh nhân theo id
	// SELECT * FROM `benh_nhan` WHERE id = "phuc" UNION 
	// SELECT * FROM `benh_nhan` WHERE full_name like "%phuc%" UNION 
	
	@Query(value = "SELECT * FROM `benh_nhan` WHERE id = :keysearch UNION SELECT * FROM `benh_nhan` WHERE full_name like :keysearch ", 
			  nativeQuery = true)
	List<BenhNhan> timKiemTuongDoi(@Param("keysearch") String keysearch);
	//get one bn
	@Query(value = "SELECT * FROM Benh_nhan Where id = ?1 ORDER BY id DESC", nativeQuery = true)
	BenhNhan getOneBenhNhan(int id);
	
	@Query(value = "SELECT * FROM Benh_nhan Where phone = ?1 ORDER BY id DESC limit 0,1", nativeQuery = true)
	BenhNhan getOneBenhNhanByPhone(int phone);
	
	@Query(value = "SELECT * FROM Benh_nhan Where mail = ?1 ORDER BY id DESC limit 0,1", nativeQuery = true)
	BenhNhan getOneBenhNhanByMail(String mail);
	//lazy load danh sach bênh nhân 
}
