package com.au.algos;

public class BinarySearch {

    public int recursiveSearch(int[] arr, int l, int r, int num) {
        if (l <= r) {
            int midIndex = (l+r) / 2;

            if (arr[midIndex] == num) {
                return midIndex;
            }
            if (arr[midIndex] > num) {
                return recursiveSearch(arr, l, midIndex-1, num);
            } else {
                return recursiveSearch(arr, midIndex + 1, r, num);
            }
        }
        return -1;
    }

    public int iterativeSearch(int[] arr, int num) {
        int l = 0;
        int r = arr.length-1;

        while (l <= r) {
            int mid = (l+r) / 2;

            if (arr[mid] == num) {
                return mid;
            }
            if (arr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().recursiveSearch(new int[]{1, 2, 4, 5, 7, 8, 10}, 0, 7, 6));
        System.out.println(new BinarySearch().iterativeSearch(new int[]{1, 2, 4, 5, 7, 8, 10}, -1));
    }
}
