package an.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="chi_tiet_thuoc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChiTietToaThuoc implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int id_toa_thuoc;
	private	int id_thuoc;
	private int so_luong_thuoc;
	private String cach_dung;
	private String ham_luong;
	private String don_vi_tinh;
	
	
	
	public String getHam_luong() {
		return ham_luong;
	}
	public void setHam_luong(String ham_luong) {
		this.ham_luong = ham_luong;
	}
	public String getDon_vi_tinh() {
		return don_vi_tinh;
	}
	public void setDon_vi_tinh(String don_vi_tinh) {
		this.don_vi_tinh = don_vi_tinh;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_toa_thuoc() {
		return id_toa_thuoc;
	}
	public void setId_toa_thuoc(int id_toa_thuoc) {
		this.id_toa_thuoc = id_toa_thuoc;
	}
	public int getId_thuoc() {
		return id_thuoc;
	}
	public void setId_thuoc(int id_thuoc) {
		this.id_thuoc = id_thuoc;
	}
	public int getSo_luong_thuoc() {
		return so_luong_thuoc;
	}
	public void setSo_luong_thuoc(int so_luong_thuoc) {
		this.so_luong_thuoc = so_luong_thuoc;
	}
	public String getCach_dung() {
		return cach_dung;
	}
	public void setCach_dung(String cach_dung) {
		this.cach_dung = cach_dung;
	}
	@Override
	public String toString() {
		return "ChiTietToaThuoc [id=" + id + ", id_toa_thuoc=" + id_toa_thuoc + ", id_thuoc=" + id_thuoc
				+ ", so_luong_thuoc=" + so_luong_thuoc + ", cach_dung=" + cach_dung + ", ham_luong=" + ham_luong
				+ ", don_vi_tinh=" + don_vi_tinh + "]";
	}


}
