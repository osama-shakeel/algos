package com.au.algos;

public class Largest {

    public int secondLargest(int[] arr) {
        int largest;
        int secLargest;
        largest = secLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            } else {
                if (arr[i] > secLargest && arr[i] != largest) {
                    secLargest = arr[i];
                }
            }
        }
        return secLargest;
    }

    public int thirdLargest(int[] arr) {
        int largest;
        int secLargest;
        int thirdLargest;
        largest = secLargest = thirdLargest = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] > largest) {
                thirdLargest = secLargest;
                secLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secLargest) {
                if (arr[i] != largest) {
                    thirdLargest = secLargest;
                    secLargest = arr[i];
                }
            } else if (arr[i] > thirdLargest) {
                if (arr[i] != secLargest) {
                    thirdLargest = arr[i];
                }
            }
        }
        return thirdLargest;
    }

    public static void main (String...args) {
        System.out.println(new Largest().thirdLargest(new int[]{4, 2, 1, 5, 3, 4, 5, 9, 5, 9, 9}));
    }
}
