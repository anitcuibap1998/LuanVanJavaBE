
package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListThuoc {

	@SerializedName("id_thuoc")
	@Expose
	private Integer idThuoc;
	@SerializedName("ten_thuoc")
	@Expose
	private String tenThuoc;

	public Integer getIdThuoc() {
		return idThuoc;
	}

	public void setIdThuoc(Integer idThuoc) {
		this.idThuoc = idThuoc;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

}