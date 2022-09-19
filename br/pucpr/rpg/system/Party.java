package br.pucpr.rpg.system;

import java.util.*;

public class Party {
    List<Char> members = new ArrayList<>();

    public void addMember(Char c) {
        members.add(c);
    }

    public void rodada(Party p1, Party p2) {
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
        TreeMap initSorted = (TreeMap) initParties.descendingKeySet();

        //  Get all entries using the entrySet() method
        Set<Map.Entry<Integer, Char> > entries
                = initSorted.entrySet();

        for (Map.Entry<Integer, Char> entry : entries) {
            Random rand = new Random();
            if (party1.contains(entry.getValue())) {
                Char randomElement = p2.getMembers().get(rand.nextInt(p2.getMembers().size()));
                Char isAttacking = entry.getValue();
                isAttacking.attack(randomElement);
            } else {
                Char randomElement = p1.getMembers().get(rand.nextInt(p1.getMembers().size()));
                Char isAttacking = entry.getValue();
                isAttacking.attack(randomElement);
            }
        }
    }

    public List<Char> getMembers() {
        return members;
    }

    public void setMembers(List<Char> members) {
        this.members = members;
    }
}


