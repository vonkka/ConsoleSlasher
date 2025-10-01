package Monster;
import Battle.Battler;
import Weapon.Club;
import Character.MainCharacterInterface;
import Weapon.Weapon;

public class Skeleton extends Battler implements Monster {
    private final int strength = 2;
    private final int agility = 2;
    private final int stamina = 1;

    private int health = 10;
    private final int damage = 2;
    private final Weapon reward = new Club();

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
        return "Skeleton \n" +
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
