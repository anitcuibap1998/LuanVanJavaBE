package dto;

import java.util.ArrayList;
import java.util.List;

import an.model.ChiTietToaThuoc;
import an.model.ToaThuoc;

public class OneToa {
	private ToaThuoc toaThuoc;
	private List<ChiTietToaThuoc> lists= new ArrayList<ChiTietToaThuoc>();
	
	public OneToa() {
		super();
	}
	public ToaThuoc getToaThuoc() {
		return toaThuoc;
	}
	public void setToaThuoc(ToaThuoc toaThuoc) {
		this.toaThuoc = toaThuoc;
	}
	public List<ChiTietToaThuoc> getLists() {
		return lists;
	}
	public void setLists(List<ChiTietToaThuoc> lists) {
		this.lists = lists;
	}
	@Override
	public String toString() {
		return "OneToa [toaThuoc=" + toaThuoc + ", lists=" + lists + "]";
	}
	
}
