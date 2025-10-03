package Battle;

import CharachterClass.Barbarian;
import Monster.*;
import Character.*;

import java.util.Random;

public class Battle {
    private MainCharacter mainCharacter;
    private Monster monster;

    public Battle(MainCharacterInterface mainCharacter, Monster monster) {
        this.mainCharacter = (MainCharacter) mainCharacter;
        this.monster = monster;
    }

    public void displayBattleStatus(int move) {
        move = (int)Math.ceil(move / 2.);
        System.out.println("Hero hp: " + mainCharacter.getHealth());
        System.out.println("Monster hp: " + monster.getHealth());
        System.out.println("Move: " + move + '\n');
    }

    public int startBattle() {
        Fighter[] fighters = new Fighter[2];
        if (mainCharacter.getAgility() >= monster.getAgility()) {
            fighters[0] = mainCharacter;
            fighters[1] = (Fighter) monster;
        } else {
            fighters[0] = (Fighter) monster;
            fighters[1] = mainCharacter;
        }

        int i = 0;
        int maxHP = mainCharacter.getHealth();

        while (mainCharacter.getHealth() > 0 && monster.getHealth() > 0) {
            int dmg = fighters[i % 2].attack(fighters[(i + 1) % 2], i + 1);
            if (dmg > 0) {
                if (fighters[(i + 1) % 2] instanceof Monster) {
                    ((Monster) (fighters[(i + 1) % 2])).setHealth(((Monster) fighters[(i + 1) % 2]).getHealth() - dmg);
                    monster.setHealth(((Monster) (fighters[(i + 1) % 2])).getHealth());
                } else {
                    ((MainCharacter)fighters[(i + 1) % 2]).setHealth(((MainCharacter)fighters[(i + 1) % 2]).getHealth() - dmg);
                    mainCharacter.setHealth(((MainCharacter)fighters[(i + 1) % 2]).getHealth());
                }
            }
            displayBattleStatus(i + 1);
            ++i;
            // i = 100 FOR THE CASE OF FIGHTING WITH GOLEM, BEING LVL 3 BARBARIAN AND HAVING LESS THAN 5 DMG AFTER NOT KILLING HIM
            // IN FIRST 3 MOVES
            if (i == 100) {
                System.out.println("Battle is likely endless - you go out of the monster");
                return -1;
            }
        }
        if (mainCharacter.getHealth() > 0) {
            mainCharacter.setHealth(maxHP);
            return 1;
        }
        return 0;
    }
}
