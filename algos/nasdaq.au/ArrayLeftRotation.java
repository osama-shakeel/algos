package com.nasdaq.au;

public class ArrayLeftRotation {

	public static int[] leftRotate(int arr[], int rotate) {
		int result[] = new int[arr.length];
		for (int i=0; i < arr.length; i++) {
			int newIndex = i - rotate;
			if (newIndex < 0) {
				newIndex += 5;
			}
			result[newIndex] = arr[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		int result[] = leftRotate(new int[] {1, 2, 3, 4, 5}, 5);
	}
}
