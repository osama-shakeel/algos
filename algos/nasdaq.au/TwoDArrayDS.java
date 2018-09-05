package com.nasdaq.au;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class TwoDArrayDS {

	public static int hourglassSum(int[][] arr) {
		int largestSum = Integer.MIN_VALUE;

		for (int i=0; i+2 < 6; i++) {
			for (int j=0; j+2 < 6; j++) {
				int sum = findSum(arr, i, j);
				if (sum > largestSum) {
					largestSum = sum;
				}
			}
		}
		return largestSum;
    }
	
	private static int findSum(int[][] arr, int i, int j) {
		int sum = 0;
		
		sum += arr[i][j];
		sum += arr[i][j+1];
		sum += arr[i][j+2];
		sum += arr[i+1][j+1];
		sum += arr[i+2][j];
		sum += arr[i+2][j+1];
		sum += arr[i+2][j+2];
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(-1 % 5);
		Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);

        scanner.close();
	}
}
