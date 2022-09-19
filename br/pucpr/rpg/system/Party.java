package br.pucpr.rpg.system;

import java.util.*;

public class Party {
    List<Char> members;
    private String partyName;

    public Party(String partyName, List<Char> members) {
        this.members = members;
        this.partyName = partyName;
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

        //  Get all entries using the entrySet() method
        Set<Map.Entry<Integer, Char>> entries = initParties.entrySet();

        for (Map.Entry<Integer, Char> entry : entries) {
            Random rand = new Random();
            Char randomElement;
            Char isAttacking = entry.getValue();
            if (party1.contains(entry.getValue())) {
                randomElement = p2.getMembers().get(rand.nextInt(p2.getMembers().size()));
            } else {
                randomElement = p1.getMembers().get(rand.nextInt(p1.getMembers().size()));
            }
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
    public boolean partyIsAlive() {
        List<Char> party = getMembers();
        int i = 0;
        for (Char c: party) {
            if (c.isAlive()) {
                i++;
            }
        }
        return i > 0;
    }

    public void survivors() {
        List<Char> party = getMembers();
        for (Char c: party) {
            if (c.isAlive()) {
                System.out.print("Congratulations " + c.getName() + " for surviving this Battle with "
                + c.getLife() + " life points!\n");
            }
        }
    }



    public void addMember(Char c) {
        members.add(c);
    }

    public String getPartyName() {
        return partyName;
    }


    public List<Char> getMembers() {
        return members;
    }

}


