package br.pucpr.rpg.items;

public class Potion {
    private String name;
    private int regeneration;


    public Potion(String name, int regeneration) {
        this.regeneration = regeneration;
        this.name = name;
    }


    @Override
    public String toString() {
        return String.format("%s (%s)", name, regeneration);
    }

    public int getRegeneration() {
        return this.regeneration;
    }

    public void setRegeneration(int regen) {
        regeneration = regen;
    }


    public String getName() {
        return name;
    }
}
