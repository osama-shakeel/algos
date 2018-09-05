package com.nasdaq.au;

public class PrimeNo {

	public boolean isPrime(int number) {
		for (int i=2; i < number/2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new PrimeNo().isPrime(89));
	}
}
