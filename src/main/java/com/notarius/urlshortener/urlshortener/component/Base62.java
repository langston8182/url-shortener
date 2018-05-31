package com.notarius.urlshortener.urlshortener.component;

import org.springframework.stereotype.Component;

/**
 * @author cyril
 *
 * Spring component to encode / decode base64 into base 10
 */
@Component
public class Base62 {

	/**
	 * List off all characters for the shorten Url.
	 */
	public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	
	/**
	 * Bas length.
	 */
	private static final int BASE62 = 62;
	
	/**
	 * Convert a Base10 to a Base62.
	 * 
	 * @param value The base10 long to be converted.
	 * 
	 * @return The base62 string.
	 */
	public String toBase62(long value) {
		StringBuilder sb = new StringBuilder();
		do {
			int mod = (int) value % BASE62;
			sb.insert(0, CHARACTERS.charAt(mod));
			value /= BASE62;
		} while (value > 0);
		
		return sb.toString();
	}
	
	/**
	 * Convert a Base62 to a Base10.
	 * 
	 * @param value The base62 string to be converted.
	 * 
	 * @return The base10 long.
	 */
	public long toBase10 (String str) {
		char[] reverseStr = new StringBuilder(str).reverse().toString().toCharArray();
		long result = 0;
		
		for (int i = reverseStr.length - 1 ; i >= 0 ; i--) {
			result += CHARACTERS.indexOf(reverseStr[i]) * (int) Math.pow(BASE62, i);
		}
		
		return result;
	}
	
}
