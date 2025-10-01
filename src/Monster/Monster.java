package Monster;
import Character.MainCharacterInterface;
import Weapon.Weapon;

public interface Monster {
    int attack(MainCharacterInterface opponent);
    int defense(MainCharacterInterface opponent);
    int getHealth();
    int getAgility();
    int getStamina();
    int getStrength();
    int getDamage();
    Weapon getReward();
    void setHealth(int health);
}
