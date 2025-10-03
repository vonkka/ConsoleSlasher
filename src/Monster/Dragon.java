package Monster;
import Battle.Fighter;
import Weapon.LegendarySword;
import Character.MainCharacterInterface;
import Weapon.Weapon;

public class Dragon extends Fighter implements Monster {
    private final int agility = 3;
    private final int strength = 3;
    private final int stamina = 3;

    private int health = 20;
    private final int damage = 4;
    private final Weapon reward = new LegendarySword();

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
        return "Dragon \n" +
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
