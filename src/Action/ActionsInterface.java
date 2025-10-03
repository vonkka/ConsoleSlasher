package Action;
import CharachterClass.Specialization;
import Character.*;
import Monster.Monster;
import Weapon.Weapon;

import java.util.ArrayList;

public interface ActionsInterface {
    MainCharacterInterface createMainCharacter();
    void winGame();
    void loseGame();
    ArrayList<Monster> getMonsters();
    int getNUM_BATTLES();
    Specialization chooseSpecialization();
    int startBattle(MainCharacterInterface character, Monster monster);
    Weapon changeWeapon(MainCharacterInterface character, Weapon weapon);
    int startAgain();
    void nextAction();
}
