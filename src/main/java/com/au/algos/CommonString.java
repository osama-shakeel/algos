package com.au.algos;

import java.util.ArrayList;
import java.util.List;

public class CommonString {

    public String findLargestCommonString(String str1, String str2) {
        List<String> commonStrings = new ArrayList<>();

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int commonStringLength = 0;

        for (int pivot = 0; pivot < s1.length; pivot++) {
            StringBuilder commonStr = new StringBuilder();
            for (int i = pivot, j = 0; i < s1.length;) {
                for (; j < s2.length;) {
                    if (s1[i] == s2[j]) {
                        commonStr.append(s1[i]);
                        i++;
                        j++;
                        break;
                    }
                    j++;
                }
                if (commonStr.length() == 0) {
                    break;
                } else {
                    j = 0;
                    i++;
                }
            }
            if (commonStr.length() > 0) {
                String commonString = commonStr.toString();
                if (commonString.length() > commonStringLength) {
                    commonStrings.clear();
                    commonStrings.add(commonString);
                } else if (commonString.length() == commonStringLength) {
                    commonStrings.add(commonString);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new CommonString().findLargestCommonString("SHINCHAN", "NOHARAAA");
    }
}
