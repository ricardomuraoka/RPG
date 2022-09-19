package br.pucpr.rpg;

import br.pucpr.rpg.items.Potion;
import br.pucpr.rpg.items.Weapon;
import br.pucpr.rpg.system.Char;
import br.pucpr.rpg.system.FixedRoll;
import br.pucpr.rpg.system.Party;

import java.util.Arrays;

public class Battle {
    public static void main(String[] args) {
        Char hero1 = new Char("Sir Gallahad",
                14, 5, 80);
        hero1.setWeapon(new Weapon("Excalibur", new FixedRoll()));
        Char hero2 = Char.createHero();
        Char hero3 = Char.createHero();


        Char goblin1 = Char.createGoblin();
        Char goblin2 = Char.createGoblin();
        Char goblin3 = Char.createGoblin();
        Char goblin4 = Char.createGoblin();

        Party heroParty = new Party("Heroes", Arrays.asList(hero1, hero2, hero3));
        Party monsterParty = new Party("Monsters", Arrays.asList(goblin1, goblin2, goblin3, goblin4));


        goblin1.setPotion(new Potion("Small potion", 10));


        //BATALHA ATE A MORTE
        //QUEREMOS SANGUE!!!!
        while (heroParty.partyIsAlive() && monsterParty.partyIsAlive()) {
            Party.rodada(heroParty, monsterParty);
        }

        Party winner = heroParty.partyIsAlive() ? heroParty : monsterParty;
        System.out.printf("%s wins! %n",
                winner.getPartyName());
    }
}
