package com.nasdaq.au;

import java.util.function.Function;

public class Train {
    private int wagons[];

    public Train(int wagonCount, Function<Integer, Integer> fillWagon) {
        this.wagons = new int[wagonCount];

        for (int i = 0; i < wagonCount; i++) {
        	this.wagons[i] = fillWagon.apply(i);
        }
    }

    public int peekWagon(int wagonIndex) {
        return this.wagons[wagonIndex];
    }
    
    public static void main(String[] args) {
        Train train = new Train(10, wagonIndex -> wagonIndex);

        for (int i = 0; i < 10; i++) {
            System.out.println("Wagon: " + i + ", cargo: " + train.peekWagon(i));
        }
    }
}