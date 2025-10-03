package Monster;
import Battle.Fighter;
import Weapon.Spear;
import Character.MainCharacterInterface;
import Weapon.Weapon;


// DOES NOT TAKE DMG FORM SLASH
public class Slime extends Fighter implements Monster {
    private final int strength = 3;
    private final int agility = 1;
    private final int stamina = 2;

    private int health = 8;
    private final int damage = 1;
    private final Weapon reward = new Spear();

    public int getAgility() {
        return agility;
    }

    public int getStrength() {
        return strength;
    }

    public int getStamina() {
        return stamina;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public Weapon getReward() {
        return reward;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Slime \n" +
                "hp: " + this.getHealth() + '\n' +
                "damage: " + (this.getDamage()  + this.getStrength()) + '\n' +
                "Strength: " + this.getStrength() + '\n' +
                "Agility: " + this.getAgility() + '\n' +
                "Stamina: " + this.getStamina() + '\n' ;
    }

    @Override
    public int attack(MainCharacterInterface opponent) {
        return 0;
    }

    @Override
    public int defense(MainCharacterInterface opponent) {
        return 0;
    }
}
