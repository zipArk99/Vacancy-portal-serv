package com.app.vacancyportal.util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordValidator {

	public static boolean validatePassword(String loginPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		int iteration = 1000;
		String[]parts = storedPassword.split(":");
		byte [] salt= fromHexa(parts[0]);
		byte [] hash = fromHexa(parts[1]);
		
		PBEKeySpec pbeKeySpec = new PBEKeySpec(loginPassword.toCharArray(),salt,iteration ,hash.length*8);
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte [] testHash = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
		
		int diff = hash.length	^ testHash.length;
	
		 for(int i = 0; i < hash.length && i < testHash.length; i++)
		    {
		        diff |= hash[i] ^ testHash[i];
		    }
		    return diff == 0;
		
	}
	
	private static byte[] fromHexa(String hexa) {
		byte [] bytes = new byte[hexa.length() /2];
		for(int i=0; i<bytes.length; i++) {
			
			bytes[i]=(byte)Integer.parseInt(hexa.substring(2*i,2*i+2),16);
		}
		
		return bytes;
	}
}
