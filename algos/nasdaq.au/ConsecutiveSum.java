package com.nasdaq.au;

public class ConsecutiveSum {

    static int consecutive(long num) {
    	int sum = 0;
    	for (int i=1; i < num; i++) {
    		int tempSum = 0;
    		for (int j = i; j < num; j++) {
    			tempSum += j;
    			if (tempSum == num) {
    				sum++;
    				break;
    			} else if (tempSum > num) {
    				break;
    			}
    		}
    	}
    	return sum;
    }

    public static void main(String[] args) {
		System.out.println(consecutive(10));
	}
}
