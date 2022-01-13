package com.adkrive.main.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptHashedPassword {

	static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public static String hashedPassword(String rawPassword) {
		return bCryptPasswordEncoder.encode(rawPassword);
	}

	public static boolean matches(String rawpass, String hash) {
		return bCryptPasswordEncoder.matches(rawpass, hash);
	}
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * System.out.println(hashedPassword("Test@1234")); }
	 */

}
