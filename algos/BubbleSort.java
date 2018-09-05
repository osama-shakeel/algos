package com.au.algos;

public class BubbleSort {

    public void sort(int[] arr) {

        for (int m=arr.length; m > 0; m--) {
            for (int i=0; i < m-1; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        for (int num : arr) {
            System.out.print(num + ", ");
        }
    }

    public  static  void main(String[] args) {
        new BubbleSort().sort(new int[]{3, 6, 5, 3,6,9,10,1, 2});
    }
}
