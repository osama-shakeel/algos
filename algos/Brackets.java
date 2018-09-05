package com.au.algos;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Brackets {

    public boolean validateBrackets(String bracketStr) {
        Stack<Character> stack = new Stack<>();
        List< Character > openBrackets = Arrays.asList('{', '[', '(');
        List< Character > closeBrackets = Arrays.asList('}', ']', ')');
        char[] brackets = bracketStr.toCharArray();

        for (char bracket : brackets) {
            if (openBrackets.contains(bracket)) {
                stack.push(bracket);
            } else if (closeBrackets.contains(bracket)) {
                if (stack.empty()) {
                    return false;
                } else {
                    if (bracket == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (bracket == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (bracket == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

    public static void main(String...args) {
        System.out.println(new Brackets().validateBrackets("(()"));
    }
}
