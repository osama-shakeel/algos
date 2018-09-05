package com.au.algos;

public class GCD2 {

    public int findGCD(int arr[]) {
        int gcd = 0;

        int num = 2;
        while (true) {
            boolean remainderFound = false;
            boolean greaterThanAll = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % num > 0) {
                    remainderFound = true;
                }
                if (num <= arr[i]) {
                    greaterThanAll = false;
                }
            }
            if (greaterThanAll) {
                break;
            }
            if (remainderFound) {
                num++;
                continue;
            } else {
                gcd = num++;
            }
        }
        return gcd;
    }

    public static void main(String...args) {
        System.out.print(new GCD2().findGCD(new int[]{10, 20, 50, 40, 30}));
    }
}
