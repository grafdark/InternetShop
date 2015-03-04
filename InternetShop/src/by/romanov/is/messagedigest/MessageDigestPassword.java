package by.romanov.is.messagedigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class MessageDigestPassword {
	private static final Logger LOGGER = Logger
			.getLogger(MessageDigestPassword.class);

	public String getHash(String password) {
		MessageDigest md5;
		StringBuffer hexString = new StringBuffer();
		try {
			md5 = MessageDigest.getInstance("md5");
			md5.reset();
			md5.update(password.getBytes());
			byte messageDigest[] = md5.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e);
		}
		return hexString.toString();
	}
}