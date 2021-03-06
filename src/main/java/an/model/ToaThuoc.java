package an.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="toa_thuoc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ToaThuoc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int id_benh_nhan;
	private Date ngay_ke_toa;
	private Date update_date;
	private	int id_bac_si;
	private String chuan_doan;
	private String dan_do;
	private int id_gia_kham;
	private int id_lich_hen;
	private int status_edit;
	
	
	public int getStatus_edit() {
		return status_edit;
	}
	public void setStatus_edit(int status_edit) {
		this.status_edit = status_edit;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public int getId_lich_hen() {
		return id_lich_hen;
	}
	public void setId_lich_hen(int id_lich_hen) {
		this.id_lich_hen = id_lich_hen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_benh_nhan() {
		return id_benh_nhan;
	}
	public void setId_benh_nhan(int id_benh_nhan) {
		this.id_benh_nhan = id_benh_nhan;
	}
	public Date getNgay_ke_toa() {
		return ngay_ke_toa;
	}
	public void setNgay_ke_toa(Date ngay_ke_toa) {
		this.ngay_ke_toa = ngay_ke_toa;
	}
	public int getId_bac_si() {
		return id_bac_si;
	}
	public void setId_bac_si(int id_bac_si) {
		this.id_bac_si = id_bac_si;
	}
	
	public String getChuan_doan() {
		return chuan_doan;
	}
	public void setChuan_doan(String chuan_doan) {
		this.chuan_doan = chuan_doan;
	}
	public int getId_gia_kham() {
		return id_gia_kham;
	}
	public void setId_gia_kham(int id_gia_kham) {
		this.id_gia_kham = id_gia_kham;
	}
	public String getDan_do() {
		return dan_do;
	}
	public void setDan_do(String dan_do) {
		this.dan_do = dan_do;
	}
	@Override
	public String toString() {
		return "ToaThuoc [id=" + id + ", id_benh_nhan=" + id_benh_nhan + ", ngay_ke_toa=" + ngay_ke_toa + ", id_bac_si="
				+ id_bac_si + ", chuan_doan=" + chuan_doan + ", dan_do=" + dan_do + ", id_gia_kham=" + id_gia_kham
				+ ", id_lich_hen=" + id_lich_hen + ", status_edit=" + status_edit + ", update_date=" + update_date
				+ "]";
	}
}
