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
@Table(name="thuoc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Thuoc implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_thuoc;
	private String ten_thuoc;
	private	String cong_dung;
	private String ham_luong;
	private String don_vi_tinh;
	private Date ngay_san_xuat ;
	private Date ngay_het_han;
	private double gia_tien ;
	private String trang_thai;
	
	
	public Thuoc() {
		
	}
	public int getId_thuoc() {
		return id_thuoc;
	}
	public void setId_thuoc(int id_thuoc) {
		this.id_thuoc = id_thuoc;
	}
	public String getTen_thuoc() {
		return ten_thuoc;
	}
	public void setTen_thuoc(String ten_thuoc) {
		this.ten_thuoc = ten_thuoc;
	}
	public String getCong_dung() {
		return cong_dung;
	}
	public void setCong_dung(String cong_dung) {
		this.cong_dung = cong_dung;
	}

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
	public Date getNgay_san_xuat() {
		return ngay_san_xuat;
	}
	public void setNgay_san_xuat(Date ngay_san_xuat) {
		this.ngay_san_xuat = ngay_san_xuat;
	}
	public Date getNgay_het_han() {
		return ngay_het_han;
	}
	public void setNgay_het_han(Date ngay_het_han) {
		this.ngay_het_han = ngay_het_han;
	}
	public double getGia_tien() {
		return gia_tien;
	}
	public void setGia_tien(double gia_tien) {
		this.gia_tien = gia_tien;
	}

	public String getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(String trang_thai) {
		this.trang_thai = trang_thai;
	}
	@Override
	public String toString() {
		return "Thuoc [id_thuoc=" + id_thuoc + ", ten_thuoc=" + ten_thuoc + ", cong_dung=" + cong_dung + ", ham_luong=" + ham_luong + ", don_vi_tinh=" + don_vi_tinh + ", ngay_san_xuat="
				+ ngay_san_xuat + ", ngay_het_han=" + ngay_het_han + ", gia_tien=" + gia_tien + ", trang_thai=" + trang_thai + "]";
	}
	
}
