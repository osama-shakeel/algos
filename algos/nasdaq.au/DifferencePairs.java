package com.nasdaq.au;

public class DifferencePairs {

	public static int differencePairs(int[] arr, int k) {
		int pairs = 0;
		
		for (int i=0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int diff = arr[i] - arr[j];
				if (Math.abs(diff) == k) {
					pairs++;
				}
			}
		}
		return pairs;
	}
	
	public static void main(String[] args) {
		System.out.println(differencePairs(new int[] {1, 2, 3, 4}, 1));
	}
}
