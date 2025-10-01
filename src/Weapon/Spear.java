package Weapon;

public class Spear implements Weapon {
    private final int damage = 3;
    private final DmgType dmgType = DmgType.Pierce;

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Spear: " + " damage type: " + dmgType + " damage:" + damage;
    }

    @Override
    public void equip() {

    }

    @Override
    public void unequip() {

    }

    @Override
    public DmgType getDamageType() {
        return dmgType;
    }
}
