package com.main;

public class Main {
	public static void main(String args[]) {
		String type = args[0];
		String source = args[1];
		String key = args[2];
//		 String type = "encrypt";
//		 String source = "123&abc";
//		 String key = "clsb1234clsb1234";
		if (type.equals("encrypt")) {
			System.out.print(AES.encrypt(source, key));
		} else {
			System.out.print(AES.decrypt(source, key));
		}
	}
}
