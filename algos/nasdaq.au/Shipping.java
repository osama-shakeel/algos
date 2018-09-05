package com.nasdaq.au;

public class Shipping {
    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
    	int minPackages = 0;
    	int itemsLeft = items;
    	
    	for (int i=0; i < availableLargePackages; i++) {
    		if (itemsLeft >= 5) {
    			minPackages++;
    			itemsLeft -= 5;
    		}
    	}
    	if (itemsLeft <= availableSmallPackages) {
    		minPackages += itemsLeft;
    		itemsLeft = 0;
    	}
    	if (itemsLeft > 0) {
    		minPackages = -1;
    	}
    	return minPackages;
    }
    
    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 1, 10));
    }
}
