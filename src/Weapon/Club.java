package Weapon;

public class Club implements Weapon{
    private final int damage = 3;
    private final DmgType dmgType = DmgType.Crush;

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Club: " + " damage type: " + dmgType + " damage:" + damage;
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
