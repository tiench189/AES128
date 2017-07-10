package com.main;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESold {

	public static String encrypt(String plainText, String key) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF8"),
					"AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
			String encryptedString = new String(
					Base64.encodeBase64(cipherText), "UTF-8");
			return encryptedString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String encryptedText, String key) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF8"),
					"AES");
//			System.out.println("key: " + key.getBytes("UTF8").toString());
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] cipherText = Base64.decodeBase64(encryptedText
					.getBytes("UTF8"));
//			System.out.println("encryptedText: "
//					+ encryptedText.getBytes("UTF8").toString());
			String decryptedString = new String(cipher.doFinal(cipherText),
					"UTF-8");
			return decryptedString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}