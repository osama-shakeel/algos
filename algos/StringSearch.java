package com.au.algos;

public class StringSearch {

    public int searchString(String text, String searchStr) {
        char[] textArr = text.toCharArray();
        char[] searchArr = searchStr.toCharArray();

        for (int i=0; i<textArr.length && (i + searchArr.length) <= textArr.length; i++) {
            for (int j=i, k=0; k < searchArr.length; j++, k++) {
                if (textArr[j] != searchArr[k]) {
                    break;
                }
                if (k == searchArr.length-1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StringSearch().searchString("acab", ""));
    }
}
