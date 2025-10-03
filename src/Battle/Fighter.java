package Battle;

import CharachterClass.*;
import Monster.*;
import Weapon.*;
import Character.*;

import java.util.Random;

public class Fighter implements FighterInterface {
    private final Random rand = new Random(System.currentTimeMillis());

    public int attack(Fighter fighter, int move) {
        int dmg = 0;
        move = (int)Math.ceil(move / 2.);

        // HERO ATTACK
        if (this instanceof MainCharacter) {
            Monster opp = (Monster) fighter;
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

        // MONSTER ATTACK
        } else if (this instanceof Monster) {
            MainCharacter opp = (MainCharacter) fighter;
            if (this instanceof Dragon && (move % 3) == 0) {
                System.out.println("Dragon burns you for 3 damage");
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
}
