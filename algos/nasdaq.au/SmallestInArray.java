package com.nasdaq.au;

public class SmallestInArray {

	int findSmallest(int arr[]) {
		int smallest = Integer.MAX_VALUE;
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] < smallest) {
				smallest = arr[i];
			}
		}
		return smallest;
	}

	public static void main(String[] args) {
		System.out.println(new SmallestInArray().findSmallest(new int[]{10, 4, 6, 7, 3, 3, 1}));
	}
}
