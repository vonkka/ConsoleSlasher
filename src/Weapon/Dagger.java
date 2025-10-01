package Weapon;

public class Dagger implements Weapon{
    private final int damage = 2;
    private final DmgType dmgType = DmgType.Pierce;

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Dagger: " + " damage type: " + dmgType + " damage:" + damage;
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
