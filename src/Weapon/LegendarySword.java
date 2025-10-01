package Weapon;

public class LegendarySword implements Weapon {
    private final int damage = 10;
    private final DmgType dmgType = DmgType.Slash;

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Legendary sword: " + " damage type: " + dmgType + " damage:" + damage;
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
