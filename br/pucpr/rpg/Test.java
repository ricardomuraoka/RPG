package br.pucpr.rpg;

import br.pucpr.rpg.items.Potion;
import br.pucpr.rpg.items.Weapon;
import br.pucpr.rpg.system.Char;
import br.pucpr.rpg.system.FixedRoll;
import br.pucpr.rpg.system.Party;

import java.util.Arrays;
import java.util.List;

public class Test {
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

        Party heroParty = new Party();
        Party monsterParty = new Party();

        heroParty.addMember(hero1);
        heroParty.addMember(hero2);
        heroParty.addMember(hero3);

        monsterParty.addMember(goblin1);
        monsterParty.addMember(goblin2);
        monsterParty.addMember(goblin3);
        monsterParty.addMember(goblin4);

        goblin1.setPotion(new Potion("Small potion", 10));


        //BATALHA ATE A MORTE
        //QUEREMOS SANGUE!!!!
        Party.rodada(heroParty, monsterParty);
    }
}
