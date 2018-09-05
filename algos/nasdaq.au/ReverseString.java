package com.nasdaq.au;

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseString("OSAMA"));
	}
	
	public static String reverseString(String str) {
		char[] chars = str.toCharArray();
		
		for (int i=0, j=chars.length-1; i<j; i++, j--) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}
}
