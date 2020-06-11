package an.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lich_hen")
public class LichHen {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private Time time;
	private	int id_benh_nhan;
	private	int id_bac_si;
	private int id_loai_kham;
	private String status;
	private String ghi_chu;
	private Date date;
	private String last_name;
	
	public LichHen() {
		
	}
	
	
	public int getId_loai_kham() {
		return id_loai_kham;
	}


	public void setId_loai_kham(int id_loai_kham) {
		this.id_loai_kham = id_loai_kham;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getId_benh_nhan() {
		return id_benh_nhan;
	}
	public void setId_benh_nhan(int id_benh_nhan) {
		this.id_benh_nhan = id_benh_nhan;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGhi_chu() {
		return ghi_chu;
	}
	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getId_bac_si() {
		return id_bac_si;
	}
	public void setId_bac_si(int id_bac_si) {
		this.id_bac_si = id_bac_si;
	}


	@Override
	public String toString() {
		return "LichHen [id=" + id + ", time=" + time + ", id_benh_nhan=" + id_benh_nhan + ", id_bac_si=" + id_bac_si
				+ ", id_loai_kham=" + id_loai_kham + ", status=" + status + ", ghi_chu=" + ghi_chu + ", date=" + date
				+ ", last_name=" + last_name + "]";
	}

}
