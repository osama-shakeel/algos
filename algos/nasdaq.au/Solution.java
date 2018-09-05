package com.nasdaq.au;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public static int findIndex(List<Integer> list1, List<Integer> list2) {
		int index = -1;
		
		if (!list1.isEmpty() && !list2.isEmpty() && list1.size() >= list2.size()) {
			for (int i=0; i < list1.size(); i++) {
				boolean misMatch = false;
				int potentialIndex = i;
				if (list1.get(i) == list2.get(0)) {
					int j = 0;
					int k = i;
					for (j = 0; j < list2.size() && k < list1.size(); j++, k++) {
						if (list2.get(j) != list1.get(k)) {
							misMatch = true;
							break;
						}
					}
					if (k >= list1.size() && j < list2.size()) {
						break;
					}
					if (misMatch) {
						continue;
					} else {
						index = potentialIndex;
						break;
					}
				}
			}
		}
		
		return index;
	}
	
    public static void main1(String args[] ) throws Exception {
    	Scanner scanner = new Scanner(System.in);
    	int list1Size = scanner.nextInt();
    	List<Integer> list1 = new ArrayList<>();
    	List<Integer> list2 = new ArrayList<>();
    	
    	for (int i=0; i<list1Size; i++) {
    		list1.add(scanner.nextInt());
    	}
    	
    	int list2Size = scanner.nextInt();
    	for (int i=0; i<list2Size; i++) {
    		list2.add(scanner.nextInt());
    	}
    	
    	System.out.println(findIndex(list1, list2));
    	scanner.close();
    }

    public static String LookAndSay(String num) {
    	String number = "";
    	if (num == null || num.length() == 0) {
    		return null;
    	}
    	char[] chars = num.toCharArray();
    	Character currNum = null;
    	int charCount = 0;
    	for (int i=0; i<chars.length; i++) {
    		if (currNum == null) {
    			charCount++;
    			currNum = chars[i];
    		} else {
    			if (currNum == chars[i]) {
    				charCount++;
    			} else {
    				number += (charCount + String.valueOf(currNum));
    				currNum = chars[i];
    				charCount = 1;
    			}
    		}
    	}
		number += (charCount + String.valueOf(currNum));
    	return number;
    }
    
    public static String LookAndSay(String start, int count) {
    	String num = start;
    	
    	for (int i=0; i<count; i++) {
    		num = LookAndSay(num);
    	}
    	return num;
    }
    
    public static void main2(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int start = scanner.nextInt();
    	int count = scanner.nextInt();
    	
    	System.out.println(LookAndSay(String.valueOf(start), count));
    	scanner.close();

	}

    public static String compute(String instructions) {
    	String result = "";
    	int[] blockPile = new int[10];
    	
    	if (instructions != null && instructions.length() > 0) {
        	char[] inst = instructions.toCharArray();
        	int robotPos = 0;
        	boolean blockHeld = false;
        	for (int i=0; i<inst.length; i++) {
        		if (inst[i] == 'P') {
        			robotPos = 0;
        			blockHeld = true;
        		} else if (inst[i] == 'M') {
        			if (robotPos < 9) {
        				robotPos++;
        			}
        		} else if (inst[i] == 'L') {
        			if (blockHeld) {
        				if (blockPile[robotPos] < 14) {
        					blockPile[robotPos]++;
        				}
        			}
        		}
        	}
        	for (Integer block : blockPile) {
        		if (block == 0) {
        			result += "0";
        		} else if (block < 10) {
        			result += (block);
        		} else if (block == 10) {
        			result += "A";
        		} else if (block == 11) {
        			result += "B";
        		} else if (block == 12) {
        			result += "C";
        		} else if (block == 13) {
        			result += "D";
        		} else if (block == 14) {
        			result += "E";
        		} else if (block == 15) {
        			result += "F";
        		}
        	}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(compute("PLPLPLPLPLPLPLPLPLPL"));
	}
}