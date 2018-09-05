package com.nasdaq.au;

public class ReverseInteger {

	public int reverseInteger(int num) {
		int reversedNum = 0;
		
		String numStr = String.valueOf(Math.abs(num));
		int div = numStr.length();
		if (div == 1) {
			return num;
		}

		int mod = 0;
		int divisor = (int)Math.pow(10, div-1);
		int k = 1;
		while (divisor > 0) {
			div = num / divisor;
			num = num % divisor;
			
			reversedNum += (div * k);
			k *= 10;
			divisor/=10;
		}
		
		return reversedNum;
	}
	
	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverseInteger(-456));
		// 48 - 57
		System.out.println((int)'9');
	}
}
