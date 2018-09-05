package com.au.algos;

public class MergeSort {

    private static int tempArr[];

    public void sort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int mid, int r) {
        for (int i = l; i <= r; i++) {
            tempArr[i] = arr[i];
        }

        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (tempArr[i] < tempArr[j]) {
                arr[k++] = tempArr[i++];
            } else {
                arr[k++] = tempArr[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = tempArr[i++];
        }
        while (j <= r) {
            arr[k++] = tempArr[j++];
        }
    }

    public  static  void main(String[] args) {
        int[] arr = new int[]{10,34,2,56,7,67,88,42};
        tempArr = new int[arr.length];
        new MergeSort().sort(arr, 0, arr.length-1);
        for (int num : arr) {
            System.out.print(num + ", ");
        }
    }

}
