package an.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="benh_nhan")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BenhNhan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String full_name;
	private int phone;
	private String address;
	private int sex;
	private String tien_su_benh;
	private Date birth_date;
	private String ghi_chu;
	
	
	public BenhNhan() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getTien_su_benh() {
		return tien_su_benh;
	}
	public void setTien_su_benh(String tien_su_benh) {
		this.tien_su_benh = tien_su_benh;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getGhi_chu() {
		return ghi_chu;
	}
	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	@Override
	public String toString() {
		return "BenhNhan [id=" + id + ", full_name=" + full_name + ", phone=" + phone + ", address=" + address
				+ ", sex=" + sex + ", tien_su_benh=" + tien_su_benh + ", birth_date=" + birth_date + ", ghi_chu="
				+ ghi_chu + "]";
	}

	
}
