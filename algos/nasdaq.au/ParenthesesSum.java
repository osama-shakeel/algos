package com.nasdaq.au;

import java.util.Stack;

public class ParenthesesSum {

	private static class Index {
		int i;
		
		public Index(int i) {
			this.i = i;
		}
	}

	// (), (()), (()(()))
	public int processParantheses(char[] brackets, Index index) {
		int total = 0;
		
		while (index.i < brackets.length) {
			if (brackets[index.i] == ')') {
				if (total > 0) {
					total *= 2;
				} else {
					total++;
				}
				break;
			} else {
				index.i++;
				total += processParantheses(brackets, index);
			}
			index.i++;
		}
			
		return total;
	}
	
	public static void main(String[] args) {
		System.out.println(new ParenthesesSum().processParantheses("(()(()))".toCharArray(), new Index(1)));
	}
}
