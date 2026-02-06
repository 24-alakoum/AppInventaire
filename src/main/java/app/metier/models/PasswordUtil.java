package app.metier.models;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
	public static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte [] hash = md.digest(password.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();
			for(byte b:hash) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	public PasswordUtil() {
		// TODO Auto-generated constructor stub
	}

}
