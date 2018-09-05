package com.au.algos;

public class Permutation {

    public void permute(char[] str, int l, int r) {
        if (l == r) {
            System.out.println(String.valueOf(str));
            return;
        }
        for (int i = l; i < str.length; i++) {
            swap(str, l, i);
            permute(str, l+1, r);
            swap(str, i, l);
        }
    }

    private void swap(char[] str, int l, int r) {
        char temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }

    public static void main(String...args) {
        new Permutation().permute("OSAM".toCharArray(), 0, 3);
    }
}
