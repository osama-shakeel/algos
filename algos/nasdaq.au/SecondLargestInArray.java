package com.nasdaq.au;

public class SecondLargestInArray {

	static int secondLargest(int arr[]) {
		int secondLargest;
		int largest;
		largest = secondLargest = Integer.MIN_VALUE;
		
		for (int i = 0; i<arr.length; i++) {
			
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
				
			} else if (arr[i] > secondLargest && arr[i] != largest) {
				secondLargest = arr[i];
			}
		}
		return secondLargest;
	}
	
	public static void main(String[] args) {
		System.out.println(SecondLargestInArray.secondLargest(new int[] {10, 1, 4, 6, 8, 9, 2}));
	}
}
