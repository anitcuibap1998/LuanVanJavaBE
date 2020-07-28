package dto;

import java.util.List;

import an.model.ChiTietToaThuoc;
import an.model.ToaThuoc;

public class ModelToaThuoc {
	private ToaThuoc toaThuoc;
	private List<ChiTietToaThuoc> listChiTietToaThuoc;
	public ModelToaThuoc() {
		// TODO Auto-generated constructor stub
	}
	public ToaThuoc getToaThuoc() {
		return toaThuoc;
	}
	public void setToaThuoc(ToaThuoc toaThuoc) {
		this.toaThuoc = toaThuoc;
	}
	public List<ChiTietToaThuoc> getListChiTietToaThuoc() {
		return listChiTietToaThuoc;
	}
	public void setListChiTietToaThuoc(List<ChiTietToaThuoc> listChiTietToaThuoc) {
		this.listChiTietToaThuoc = listChiTietToaThuoc;
	}
	@Override
	public String toString() {
		return "ModelToaThuoc [toaThuoc=" + toaThuoc + ", listChiTietToaThuoc=" + listChiTietToaThuoc + "]";
	}
	
}

