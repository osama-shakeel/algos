package com.au.algos;

import java.util.Arrays;
import java.util.List;

public class ListSubset {

	public static int findSubsetListIndex(List<Integer> mainList, List <Integer> subsetList) {
		int index = -1;

		if (isEmpty(mainList) || isEmpty(subsetList) || subsetList.size() > mainList.size()) {
			return index;
		}
		
		int i=0, j=0;
		for (int k=0; i < mainList.size() && j < subsetList.size(); i++) {
			if (mainList.get(i) != subsetList.get(j)) {
				j = 0;
				i = ++k;
			} else {
				j++;
			}
		}
		if (j == subsetList.size()) {
			index = i - j;
		}
		return index;
	}
	
	private static boolean isEmpty(List list) {
		return list == null || list.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(findSubsetListIndex(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 6)));
	}
}
