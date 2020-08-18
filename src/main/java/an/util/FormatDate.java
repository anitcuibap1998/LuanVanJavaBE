package an.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
	public static String dateToString(Date date) {
		String pattern = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String stringDate = simpleDateFormat.format(date);
		return stringDate;
	}
	@SuppressWarnings("finally")
	public static Date stringToDate(String chuoiDate) {
		Date date1 = null;
		try {
		 date1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(chuoiDate);
		}catch(Exception ex){
			return null;
		}finally {
			return date1;	
		}
		
	}
}
