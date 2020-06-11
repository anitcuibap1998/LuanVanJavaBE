package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ToaThuoc {

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("idBacSi")
	@Expose
	private Integer idBacSi;
	@SerializedName("idBenhNhan")
	@Expose
	private Integer idBenhNhan;
	@SerializedName("idLoaiKham")
	@Expose
	private Integer idLoaiKham;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdBacSi() {
		return idBacSi;
	}

	public void setIdBacSi(Integer idBacSi) {
		this.idBacSi = idBacSi;
	}

	public Integer getIdBenhNhan() {
		return idBenhNhan;
	}

	public void setIdBenhNhan(Integer idBenhNhan) {
		this.idBenhNhan = idBenhNhan;
	}

	public Integer getIdLoaiKham() {
		return idLoaiKham;
	}

	public void setIdLoaiKham(Integer idLoaiKham) {
		this.idLoaiKham = idLoaiKham;
	}
	

}