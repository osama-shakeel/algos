package com.au.algos;

public class InsertionSort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
        for (int num : arr) {
            System.out.print(num + ", ");
        }
    }

    public  static  void main(String[] args) {
        new InsertionSort().sort(new int[]{10,34,2,56,7,67,88,42});
    }
}
