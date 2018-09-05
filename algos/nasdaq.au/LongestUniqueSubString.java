package com.nasdaq.au;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubString {

	public int longestUniqueSubstring(String str) {
		int ans = 0;
		char[] chars = str.toCharArray();
		int i = 0;
		int j = 0;
		Set<Character> charSet = new HashSet<>();
		
		while (i < chars.length && j < chars.length) {
			if (!charSet.contains(chars[j])) {
				charSet.add(chars[j]);
				j++;
				ans = Math.max(ans, j-i);
			} else {
				charSet.remove(chars[i]);
				i++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestUniqueSubString().longestUniqueSubstring("pwwkew"));
	}
}
