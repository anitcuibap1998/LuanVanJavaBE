package an.util;

public class test {
	
	 public static void main(String args[]) {
		  String s1 = "minh an,an,mã hóa,12 34s,an 11";
		  String[] words = s1.split(",");//tach chuoi dua tren khoang trang
		  //su dung vong lap foreach de in cac element cua mang chuoi thu duoc
		  for (String w : words) {
		   System.out.println(w);
		  }
		 }
}
