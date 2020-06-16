package an.util;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import an.model.User;

public class TokenAC {
	public static String encodeToken(User user) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(formatter.format(date).toString());
		
		byte[] array = new byte[10]; // length is bounded by 10
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    System.out.println("Chuoi random: "+generatedString);
		
		
		String original = generatedString+","+user.getUsername()+","+user.getRole()+","+formatter.format(date).toString();
		System.out.println("Chuoi Chua Ma Hoa: "+original);
		String SECRET_KEY = "Anvietcodedao.vn";
		SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
		
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
	    byte[] byteEncrypted = cipher.doFinal(original.getBytes());
	    String encrypted =  Base64.getEncoder().encodeToString(byteEncrypted);
		
	    System.out.println("Chuoi sau khi ma hoa: "+encrypted);
		return encrypted;
	}
	
	public static Object decodeToken(String encrypted) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		boolean flag = true;
		String decrypted ="";
		System.out.println("trước khi vào giải mã");
		try {
			System.out.println("Vào phần try ....");	
			byte[] byteEncrypted =  Base64.getDecoder().decode(encrypted);
			System.out.println("giai malan 1 encrypted ---> byteEncrypted: "+byteEncrypted);
			String SECRET_KEY = "Anvietcodedao.vn";
			SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
			
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] byteDecrypted = cipher.doFinal(byteEncrypted);
		    decrypted = new String(byteDecrypted);
			
			System.out.println("Chuoi sau khi giai ma: "+byteDecrypted);
		}catch (Exception e) {
			flag = false;
			System.out.println("vào phần catch và bị lỗi.....");
			return "404";
		}
		return  decrypted; 
		
	}
	
}
