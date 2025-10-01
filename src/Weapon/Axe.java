package Weapon;

public class Axe implements Weapon{
    private final int damage = 4;
    private final DmgType dmgType = DmgType.Slash;

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Axe: " + " damage type: " + dmgType + " damage:" + damage;
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
