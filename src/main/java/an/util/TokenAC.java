package an.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

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
		
		String original = user.getUsername()+","+user.getRole()+","+formatter.format(date).toString();
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
	
	public static String decodeToken(String encrypted) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		 byte[] byteEncrypted =  Base64.getDecoder().decode(encrypted);
		
		String SECRET_KEY = "Anvietcodedao.vn";
		SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
		
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] byteDecrypted = cipher.doFinal();
	    String decrypted = new String(byteDecrypted);
		
		System.out.println("Chuoi sau khi giai ma: "+byteDecrypted);
		return decrypted;
	}
}
