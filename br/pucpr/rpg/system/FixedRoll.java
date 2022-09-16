package br.pucpr.rpg.system;

public  class FixedRoll implements Rollable {
    private static int[] result = new int[]{5, 6, 7};

    public FixedRoll() {
        int[] result = this.result;
    }

    public static int roll() {
        var i = 0;
        return result[i++];
    }

    public static int[] getInstance() {
        return new int[]{roll()};
    }
}
