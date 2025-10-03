package Character;

import Battle.FighterInterface;
import CharachterClass.Specialization;
import Monster.Monster;
import Weapon.Weapon;

import java.util.ArrayList;

public interface MainCharacterInterface extends FighterInterface {
    Weapon equipWeapon(Weapon weapon);
    int lvlUp(Specialization specialization);
    ArrayList<Specialization> getSpecializations();
    int getLvl();
    int getMAX_LEVEL();
}
