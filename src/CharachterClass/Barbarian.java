package CharachterClass;

import Weapon.Weapon;
import Weapon.Club;

public class Barbarian implements Specialization {
    private int lvl;
    private final int hpPerLevel = 6;
    private final Weapon startWeapon = new Club();

    public Barbarian() {
        this.lvl = 1;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHpPerLevel() {
        return hpPerLevel;
    }

    public Weapon getStartWeapon() {
        return startWeapon;
    }

    @Override
    public String toString() {
        return "Barbarian lvl: " + lvl + '\n';
    }

    @Override
    public int lvlUp() {
        return ++this.lvl;
    }
}
