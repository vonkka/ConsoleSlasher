package Character;

import CharachterClass.*;
import Monster.Monster;
import Weapon.Weapon;

import java.util.Objects;
import java.util.Random;
import Battle.*;

public class MainCharacter extends Battler implements MainCharacterInterface {
    private final int MAX_LEVEL = 3;

    private int strength;
    private int agility;
    private int stamina;

    private int health;
    private int damage;

    private Weapon weapon;
    private Specialization[] specialization;

    private int lvl;

    public MainCharacter() {
        Random rand = new Random(System.currentTimeMillis());
        this.setAgility(1 + rand.nextInt(3));
        this.setStrength(1 + rand.nextInt(3));
        this.setStamina(1 + rand.nextInt(3));
        this.setLvl(1);
        this.specialization = new Specialization[3];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.specialization.length; i++) {
            if (this.specialization[i] != null) {
                str.append(this.specialization[i].toString());
            }
        }

        return  "Hero \n" +
                "Strength: " + this.strength + '\n' +
                "Agility: " + this.agility + '\n' +
                "Stamina: " + this.stamina + '\n' +
                "Health: " + this.health + '\n' +
                "Damage: " + this.damage + '\n' +
                "Weapon: " + this.weapon + '\n' +
                "Lvl: " + this.lvl + '\n' +
                "Specialization: " + str;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Specialization[] getSpecializations() {
        return specialization;
    }

    public void setSpecialization(Specialization[] specialization) {
        this.specialization = specialization;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public Weapon equipWeapon(Weapon weapon) {
        this.damage += weapon.getDamage() - this.weapon.getDamage();
        this.weapon = weapon;
        return weapon;
    }

    public Specialization[] addSpecialization(Specialization specialization) {
        int i = 0;
        while (this.specialization[i] != null) {
            if (this.specialization[i].getClass() == specialization.getClass()) {
                this.specialization[i].lvlUp();
                this.setHealth(this.getHealth() + specialization.getHpPerLevel());
                return this.specialization;
            }
            ++i;
        }
        if (i == 0) {
            this.setWeapon(specialization.getStartWeapon());
            this.setDamage(this.getDamage() + this.getWeapon().getDamage());
        }
        this.specialization[i] = specialization;
        this.setHealth(this.getHealth() + specialization.getHpPerLevel());
        if (i > 0) {
            this.setHealth(this.getHealth() + this.getStamina());
        }
        return this.specialization;
    }

    @Override
    public int lvlUp(Specialization specialization) {
        if (this.lvl < this.MAX_LEVEL) {
            ++this.lvl;
            int i = 0;
            while (this.specialization[i] != null) {
                if (this.specialization[i].getClass() == specialization.getClass()) {
                    this.specialization[i].lvlUp();
                    this.setHealth(this.getHealth() + specialization.getHpPerLevel() + this.getStamina());
                    if (this.specialization[i].getLvl() == 3) {
                        if (this.specialization[i] instanceof Warrior) {
                            ++this.strength;
                        } else if (this.specialization[i] instanceof Barbarian) {
                            ++this.stamina;
                        }
                    } else if (this.specialization[i].getLvl() == 2) {
                        if (this.specialization[i] instanceof Robber) {
                            ++this.agility;
                        }
                    }
                    return this.lvl;
                }
                ++i;
            }
            addSpecialization(specialization);
        }
        return this.lvl;
    }

    @Override
    public int startBattle(Monster monster) {
        Battler[] battlers = new Battler[2];
        if (this.getAgility() >= monster.getAgility()) {
            battlers[0] = this;
            battlers[1] = (Battler) monster;
        } else {
            battlers[0] = (Battler) monster;
            battlers[1] = this;
        }

        int i = 0;
        int maxHP = this.getHealth();
        while (this.getHealth() > 0 && monster.getHealth() > 0) {
            int dmg = battlers[i % 2].attack(battlers[(i + 1) % 2], i + 1);
            if (dmg > 0) {
                if (battlers[(i + 1) % 2] instanceof Monster) {
                    ((Monster) (battlers[(i + 1) % 2])).setHealth(((Monster) battlers[(i + 1) % 2]).getHealth() - dmg);
                    monster.setHealth(((Monster) (battlers[(i + 1) % 2])).getHealth());
                } else {
                    ((MainCharacter)battlers[(i + 1) % 2]).setHealth(((MainCharacter)battlers[(i + 1) % 2]).getHealth() - dmg);
                    this.setHealth(((MainCharacter)battlers[(i + 1) % 2]).getHealth());
                }
            }
            battlers[i % 2].displayBattleStatus(battlers[(i+1) % 2], i + 1);
            ++i;
        }
        if (this.getHealth() > 0) {
            this.setHealth(maxHP);
            return 1;
        }
        return 0;
    }
}
