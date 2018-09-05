package com.nasdaq.au;

public class PalindromeSubstring {

	public String findPalindromeSubstring(String str) {
		String palSubstr = null;
		char[] strChars = str.toCharArray();
		for (int i = 0; i < strChars.length; i++) {
			for (int j = i+1; j < strChars.length; j++) {
				if (strChars[i] == strChars[j]) {
					int k = i+1;
					int l = j-1;
					while (k <= l) {
						if (strChars[k] == strChars[l]) {
							k++;
							l--;
						} else {
							break;
						}
					}
					if (k > l) {
						palSubstr = str.substring(i, j+1);
						return palSubstr;
					}
				}
			}
		}
		
		return palSubstr;
	}

	public static void main(String[] args) {
		System.out.println(new PalindromeSubstring().findPalindromeSubstring("ABCD"));
		Integer i = null;
	}
}
