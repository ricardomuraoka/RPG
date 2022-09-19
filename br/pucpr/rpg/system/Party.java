package br.pucpr.rpg.system;

import java.util.*;

public class Party {
    List<Char> members = new ArrayList<>();

    public void addMember(Char c) {
        members.add(c);
    }

    public static void rodada(Party p1, Party p2) {
        List<Char> party1 = p1.getMembers();
        List<Char> party2 = p2.getMembers();

        // adding elements
        TreeMap<Integer, Char> initParties = new TreeMap<>();
        for (Char c: party1) {
            int initiative = new DiceRoll(1, 20).roll();
            initParties.put(initiative, c);
        }
        for (Char c: party2) {
            int initiative = new DiceRoll(1, 20).roll();
            initParties.put(initiative, c);
        }
        NavigableSet<Integer> initSorted = initParties.descendingKeySet();

        //  Get all entries using the entrySet() method
        Set<Map.Entry<Integer, Char>> entries = initParties.entrySet();

        for (Map.Entry<Integer, Char> entry : entries) {
            Random rand = new Random();
            if (party1.contains(entry.getValue())) {
                Char randomElement = p2.getMembers().get(rand.nextInt(p2.getMembers().size()));
                Char isAttacking = entry.getValue();
                if (isAttacking.isAlive() && randomElement.isAlive()) {
                    if (isAttacking.isWeak() && isAttacking.hasPotion()) {
                        isAttacking.sip();
                        System.out.println();
                    } else {
                        isAttacking.attack(randomElement);
                    }
                    System.out.println();
                }
            } else {
                Char randomElement = p1.getMembers().get(rand.nextInt(p1.getMembers().size()));
                Char isAttacking = entry.getValue();
                if (isAttacking.isAlive() && randomElement.isAlive()) {
                    if (isAttacking.isWeak() && isAttacking.hasPotion()) {
                        isAttacking.sip();
                        System.out.println();
                    } else {
                        isAttacking.attack(randomElement);
                    }
                    System.out.println();
                }
            }
        }
    }
    /*
            while (hero.isAlive() && monster.isAlive()) {
            if (hero.isWeak() && hero.hasPotion()) {
                hero.sip();
                monster.attack(hero);
                System.out.println();
            } else if (monster.isWeak() && monster.hasPotion()){
                hero.attack(monster);
                if (monster.isAlive()) {
                    monster.sip();
                }
                System.out.println();
            } else {
                hero.attack(monster);
                if (monster.isAlive()) {
                    monster.attack(hero);
                }
                System.out.println();
            }
        }
     */

    public List<Char> getMembers() {
        return members;
    }

    public void setMembers(List<Char> members) {
        this.members = members;
    }
}


