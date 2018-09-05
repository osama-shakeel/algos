package com.nasdaq.au;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IcecreamParlor {

	public static int[] whatFlavours(int[] flavours, int money) {
		int[] chosenFlavs = new int[2];
		
		for (int i=0; i < flavours.length; i++) {
			if (flavours[i] < money) {
				for (int j=i+1; j < flavours.length; j++) {
					if (flavours[i] + flavours[j] == money) {
						chosenFlavs[0] = i+1;
						chosenFlavs[1] = j+1;
						return chosenFlavs;
					}
				}
			}
		}
		return chosenFlavs;
	}
	
	public static void main(String[] args) {
		int chosenFlavs[] = whatFlavours(new int[] {2, 2, 4, 3}, 4);
		IntStream stream = Arrays.stream(chosenFlavs);
		stream = stream.sorted();
		stream.forEach(flav -> System.out.print(flav + " "));
	}
}
