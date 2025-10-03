package Character;

import CharachterClass.*;
import Weapon.Weapon;

import java.util.ArrayList;
import java.util.Random;
import Battle.*;

public class MainCharacter extends Fighter implements MainCharacterInterface {
    private final int MAX_LEVEL = 3;

    private int strength;
    private int agility;
    private int stamina;

    private int health;
    private int damage;

    private Weapon weapon;
    private ArrayList<Specialization> specialization;

    private int lvl;

    public MainCharacter(int agility, int strength, int stamina) {
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
        this.specialization = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Specialization value : this.specialization) {
            str.append(value.toString());
        }

        if (this.specialization.isEmpty()) {
            str.append("None");
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


    @Override
    public Weapon equipWeapon(Weapon weapon) {
        this.damage += weapon.getDamage() - this.weapon.getDamage();
        this.weapon = weapon;
        return weapon;
    }

    public int lvlUp(Specialization specialization) {
        this.health += specialization.getHpPerLevel() + this.stamina;
        ++this.lvl;

        for (Specialization value : this.specialization) {
            if (value.getClass() == specialization.getClass()) {
                value.lvlUp();

                if (value.getLvl() == 3) {
                    if (value instanceof Warrior) {
                        ++this.strength;
                        ++this.damage;
                    } else if (value instanceof Barbarian) {
                        ++this.stamina;
                        ++this.health;
                    }
                } else if (value.getLvl() == 2 && value instanceof Robber) {
                    ++this.agility;
                }

                return this.lvl;
            }
        }

        // if it's first specialization
        if (this.specialization.isEmpty()) {
            this.setWeapon(specialization.getStartWeapon());
            this.damage += specialization.getStartWeapon().getDamage();
        }
        // if it's new specialization
        this.specialization.add(specialization);
        return this.lvl;
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

    public ArrayList<Specialization> getSpecializations() {
        return specialization;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getMAX_LEVEL() {
        return MAX_LEVEL;
    }
}
