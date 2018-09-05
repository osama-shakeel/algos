package com.nasdaq.au;

import java.util.HashSet;
import java.util.Set;

public class TripleSum {

	public static int tripleSum(int[] a, int[] b, int[] c) {
		Set <String> set = new HashSet<>();
		String s = "";
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] <= b[i]) {

					for (int k = 0; k < c.length; k++) {
						if (b[i] >= c[k]) {
							set.add(a[j] + "-" + b[i] + "-" + c[k]);
						} else {
							break;
						}
					}
				} else {
					break;
				}
			}
		}
		
		return set.size();
	}
	
	public static void main(String[] args) {
		System.out.println(tripleSum(new int[] {3, 5, 7}, new int[] {3, 6}, new int[] {4, 6, 9}));
	}
}
