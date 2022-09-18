package br.pucpr.rpg;

import br.pucpr.rpg.items.Potion;
import br.pucpr.rpg.items.Weapon;
import br.pucpr.rpg.system.Char;
import br.pucpr.rpg.system.DiceRoll;
import br.pucpr.rpg.system.FixedRoll;

public class Battle {
    public static void main(String[] args) {
        Char hero = new Char("Sir Gallahad",
                14, 5, 80);
        hero.setWeapon(new Weapon("Excalibur", new FixedRoll()));

        Char monster = Char.createGoblin();
        monster.setPotion(new Potion("Small potion", 10));

        System.out.println(hero.getName() + " versus " + monster.getName());


        //BATALHA ATE A MORTE
        //QUEREMOS SANGUE!!!!
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

        Char winner = hero.isAlive() ? hero : monster;
        System.out.printf("%s wins! Life: %d%n",
                winner.getName(), winner.getLife());
    }
}
