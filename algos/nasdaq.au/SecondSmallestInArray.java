package com.nasdaq.au;

public class SecondSmallestInArray {

	public static int getSecondSmallest(int arr[]) {
		int first;
		int second;
		first = second = Integer.MAX_VALUE;
		
		for (int i=0; i<arr.length; i++) {
			
			if (arr[i] < first) {
				second = first;
				first = arr[i];
			} else if (arr[i] < second && arr[i] != first) {
				second = arr[i];
			}
		}
		return second;
	}
	
	public static void main(String[] args) {
		int arr[] = {12, 13, 1, 10, 34, 1};
		System.out.println(SecondSmallestInArray.getSecondSmallest(arr));
	}
}
