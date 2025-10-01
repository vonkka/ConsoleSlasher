package CharachterClass;

import Weapon.Weapon;

public interface Specialization {
    int lvlUp();
    int getLvl();
    int getHpPerLevel();
    Weapon getStartWeapon();
    String consoleCompare();
}
