package com.nasdaq.au;

public class Atoi {

	public int atoi(String str) {
		int num = 0;
		char[] chars = str.toCharArray();
		int divisor = chars[0] == '-'? chars.length-1 : chars.length;
		int index = chars[0] == '-'? 1 : 0;
		divisor = (int)Math.pow(10, divisor-1);
		
		while (divisor > 0) {
			num = num + (((int)chars[index++] - 48) * divisor);
			divisor /= 10;
		}
		if (chars[0] == '-') {
			num = Math.negateExact(num);
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(new Atoi().atoi("-456"));
	}
}
