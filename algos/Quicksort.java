package com.au.algos;

public class Quicksort {

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {

            int partitionIndex = derivePartitionIndex(arr, start, end);
            quickSort(arr, start, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int derivePartitionIndex(int[] arr, int start, int end) {
        int l = start+1;
        int r = end;

        int pivot = arr[start];

        while (true) {
            while (l <= r && arr[l] < pivot) {
                l++;
            }
            while (r >= l && arr[r] > pivot) {
                r--;
            }
            if (l > r) {
                break;
            } else {
                swap(arr, l, r);
            }
        }
        swap(arr, start, r);
        return r;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {7, 3, 8, 1, 9, 5, 2, 0};
        new Quicksort().quickSort(arr, 0, arr.length-1);
        for (int num : arr) {
            System.out.print(num + ", ");
        }
    }
}
