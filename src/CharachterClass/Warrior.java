package CharachterClass;

import Weapon.Weapon;
import Weapon.Sword;

public class Warrior implements Specialization{
    private int lvl;
    private final int hpPerLevel = 5;
    private Weapon startWeapon = new Sword();

    public String head = "" +
            "   ┌──────────── ┐\n" +
            "  │  │___│  │───││\n" +
            " │   │ ● │__│ ● │ │\n" +
            " │\\  │───│  │___│ │\n" +
            " │ \\     ▴       │\n" +
            " │  \\──────────  │\n" +
            " │     ─────     │\n" +
            "  │             │\n" +
            "   └─╦───────╦─┘\n" +
            "    ╱│       │╲\n" +
            "   ╱ │       │ ╲\n" +
            "  ╱  │       │  ╲";

    public Warrior(){
        this.lvl = 1;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHpPerLevel() {
        return hpPerLevel;
    }

    public Weapon getStartWeapon() {
        return startWeapon;
    }

    @Override
    public String consoleCompare() {
        return "warrior";
    }

    @Override
    public String toString() {
        return "Warrior lvl: " + lvl + '\n';
    }

    @Override
    public int lvlUp() {
        return ++this.lvl;
    }
}
