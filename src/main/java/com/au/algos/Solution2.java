package com.au.algos;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List< Integer > cellComplete(int[] states, int days) {
        List< Integer > cellStates = null;
        if (states != null && states.length == 8 && days > 0) {
            int[] prevStates = new int[8];

            for (int i = 0; i < days; i++) {
                copyToPreviousStates(states, prevStates);

                states[0] = 0 ^ prevStates[1];  // 1st element
                states[7] = prevStates[6] ^ 0;  // 8th element
                for (int j = 1; j < 7; j++) {
                    states[j] = prevStates[j-1] ^ prevStates[j+1];
                }
            }
            cellStates = new ArrayList<>(8);
            for (int arr : states) {
                cellStates.add(arr);
            }
        }
        return cellStates;
    }

    private void copyToPreviousStates(int[] src, int[] dest) {
        for (int i = 0; i < 8; i++) {
            dest[i] = src[i];
        }
    }

    public static void main(String[] arr) {
        List< Integer > cellStates = new Solution2().cellComplete(new int[]{1, 0, 1, 0, 1, 0, 1, 0}, 1);
        System.out.println(cellStates);
    }
}
//23280669741612