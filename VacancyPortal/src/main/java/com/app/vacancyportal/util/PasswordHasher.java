package com.app.vacancyportal.util;

import java.util.Arrays;


import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHasher {
	

	public static String generateHashPassword(String password)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		int iteration = 1000;
		char[] chars = password.toCharArray();
		byte[] salt = getSalt();

		PBEKeySpec pbeKeySpec = new PBEKeySpec(chars, salt, iteration, 16 * 8);
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
		byte[] hash = secretKey.getEncoded();

		System.out.println("hash password::"+Arrays.toString(hash));

		String hashStr= getHexaDeciamal(salt)+":"+getHexaDeciamal(hash);
		System.out.println("hashlength"+hashStr.length());
		return hashStr;
	}

	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		secureRandom.nextBytes(salt);
		return salt;
	}

	private static String getHexaDeciamal(byte[] hash) {
		BigInteger bi = new BigInteger(1, hash);
		String hexa = bi.toString(16);
		int paddingLength = (hash.length * 2) - hexa.length();

		if (paddingLength > 0) {
			
			String str =String.format("%0" + paddingLength + "d", 0) + hexa;
			System.out.println("hexa string::"+str);
			return str;
		}
		System.out.println("hexa string::"+hexa);
		return hexa;

	}

}
