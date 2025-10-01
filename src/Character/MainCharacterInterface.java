package Character;

import CharachterClass.Specialization;
import Monster.Monster;
import Weapon.Weapon;

public interface MainCharacterInterface {
    Weapon equipWeapon(Weapon weapon);
    Specialization[] addSpecialization(Specialization specialization);
    int lvlUp(Specialization specialization);
    int startBattle(Monster monster);
    Specialization[] getSpecializations();
    int getLvl();
}
