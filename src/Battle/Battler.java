package Battle;

import CharachterClass.Barbarian;
import CharachterClass.Robber;
import CharachterClass.Specialization;
import CharachterClass.Warrior;
import Monster.*;
import Character.MainCharacter;
import Weapon.DmgType;

import java.util.Random;

public class Battler {
    private final Random rand = new Random(System.currentTimeMillis());

    public int attack(Battler battler, int move) {
        int dmg = 0;
        move = (int)Math.ceil(move / 2.);
        if (this instanceof MainCharacter) {
            Monster opp = (Monster) battler;
            int check = rand.nextInt(((MainCharacter) this).getAgility() + opp.getAgility());
            if (check >= opp.getAgility()) {
                // Strength
                dmg += ((MainCharacter) this).getStrength();
                // Weapon
                if (!(opp instanceof Slime) || ((MainCharacter) this).getWeapon().getDamageType() != DmgType.Slash) {
                    dmg += ((MainCharacter) this).getWeapon().getDamage();
                }
                // Specialization buffs
                for (Specialization specialization: ((MainCharacter) this).getSpecializations()) {
                    if (specialization != null) {
                        if (specialization instanceof Robber) {
                            if (((MainCharacter) this).getAgility() > opp.getAgility()) {
                                ++dmg;
                            }
                            if (specialization.getLvl() == 3) {
                                dmg += move;
                            }
                        } else if (specialization instanceof Warrior) {
                            if (move == 1) {
                                if (!(opp instanceof Slime)) {
                                    dmg += ((MainCharacter) this).getWeapon().getDamage();
                                } else {
                                    dmg += ((MainCharacter) this).getWeapon().getDamage() * 2;
                                }
                            }
                        } else if (specialization instanceof Barbarian) {
                            if (move < 4) {
                                dmg += 2;
                            } else {
                                --dmg;
                            }
                        }
                    }
                }
                if (opp instanceof Skeleton && ((MainCharacter) this).getWeapon().getDamageType() == DmgType.Crush) {
                    dmg *= 2;
                }
                if (opp instanceof Golem) {
                    dmg -= opp.getStamina();
                }
                System.out.println("Hero hits: " + dmg);
            } else {
                System.out.println("Hero missed!");
            }
        } else if (this instanceof Monster) {
            MainCharacter opp = (MainCharacter) battler;
            if (this instanceof Dragon && (move % 3) == 0) {
                dmg += 3;
            }
            if (rand.nextInt(((Monster) this).getAgility() + opp.getAgility()) >= opp.getAgility()) {
                dmg += ((Monster) this).getDamage() + ((Monster) this).getStrength();
                if (this instanceof Ghost) {
                    if (((Monster) this).getAgility() > opp.getAgility()) {
                        ++dmg;
                    }
                }
                for (Specialization specialization: opp.getSpecializations()) {
                    if (specialization != null) {
                        if (specialization instanceof Warrior) {
                            if (specialization.getLvl() > 1 && opp.getStrength() > ((Monster) this).getStrength()) {
                                dmg -= 3;
                            }
                        } else if (specialization instanceof Barbarian) {
                            if (specialization.getLvl() > 1) {
                                dmg -= opp.getStamina();
                            }
                        }
                    }
                }
                System.out.println("Monster hits: " + dmg);
            } else {
                System.out.println("Monster missed!");
            }
        }
        return dmg;
    }

    public void displayBattleStatus(Battler battler, int move) {
        move = (int)Math.ceil(move / 2.);
        System.out.println(battler);
        System.out.println("Move: " + move + '\n');
    }
}
