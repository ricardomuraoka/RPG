package br.pucpr.rpg.system;

import java.util.Arrays;

public  class FixedRoll implements Rollable {


    private  int[] result = new int[]{5, 6, 7};
    int value = 5;

    public FixedRoll() {
    }

    public int roll() {
        int max = Arrays.stream(result).max().getAsInt();
        if (value == max) {
            value = 5;
        } else {
            value += 1;
        }
        return value;
    }
}
