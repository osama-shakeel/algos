package com.au.algos;

public class GCD {

    public int generalizedGCD(int num, int[] arr)
    {
        int gcd = 0;
        if (num > 0 && arr != null && arr.length == num) {
            for (int i = 2; ; i++) {
                boolean remainderFound = false;
                boolean greaterThanAll = true;
                for (int j=0; j<num; j++) {

                    if (arr[j] % i > 0) {
                        remainderFound = true;
                    }
                    if (i <= arr[j]) {
                        greaterThanAll = false;
                    }
                }
                if (greaterThanAll) {
                    break;
                }
                if (remainderFound) {
                    continue;
                } else {
                    gcd = i;
                }
            }
        }
        return gcd;
    }

    public static void main (String...arg) {
        System.out.println(new GCD().generalizedGCD(5, new int[] {500, 200, 300, 100, 400}));

        boolean bool = true;

        Boolean boolObj = bool;

        Boolean anotherBoolObj = (1 == 1);

        if (boolObj == anotherBoolObj) {
            System.out.println("TRUE");
        }
    }
}
