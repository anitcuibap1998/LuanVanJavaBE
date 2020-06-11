package dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ToaThuocGSON {

@SerializedName("list_thuoc")
@Expose
private List<ListThuoc> listThuoc = null;
@SerializedName("toa_thuoc")
@Expose
private ToaThuoc toaThuoc;

public List<ListThuoc> getListThuoc() {
return listThuoc;
}

public void setListThuoc(List<ListThuoc> listThuoc) {
this.listThuoc = listThuoc;
}

public ToaThuoc getToaThuoc() {
return toaThuoc;
}

public void setToaThuoc(ToaThuoc toaThuoc) {
this.toaThuoc = toaThuoc;
}
}
