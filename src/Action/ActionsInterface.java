package Action;
import Character.MainCharacterInterface;
import Monster.Monster;

public interface ActionsInterface {
    MainCharacterInterface createMainCharacter();
    void winGame();
    void loseGame();
    int getNUM_MONSTERS();
    Monster[] getMonsters();
    int getNUM_BATTLES();
}
