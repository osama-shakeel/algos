package com.nasdaq.au;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Class for calculating the sum of products
 *
 */
public class NasdaqMain {

	/**
	 * Method that calculates the sum of product of numbers for the given preceding number size.
	 * @param n is the maximum range of numbers
	 * @param size denots the preceding numbers.
	 * @return Product sum.
	 */
	public BigInteger sum(int n, int size) {
		BigInteger sum = BigInteger.ZERO;
		BigInteger product = BigInteger.ONE;
		long firstNum = 0;
		long size_inc = size + 1;
		
		for (long i = 1; i <= n; i++) {
			
			if (i != 1) {
				product = product.multiply(BigInteger.valueOf(i-1));
				System.out.print(product + " + ");
				sum = sum.add(product);
			} else {
				System.out.print("0 + ");
			}
			
			if (i >= size_inc) {
				firstNum++;
				product = product.divide(BigInteger.valueOf(firstNum));
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		System.out.print("Please provide size n of the numbers range: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.print("Please enter the Preceding 'C' number/size: ");
		int size = scanner.nextInt();
		scanner.close();
		
		// Calculate the sum of products based on n and preceding size
		System.out.println(new NasdaqMain().sum(n, size));
	}
}
