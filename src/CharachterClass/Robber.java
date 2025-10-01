package CharachterClass;

import Weapon.Weapon;
import Weapon.Dagger;

public class Robber implements Specialization{
    private int lvl;
    private final int hpPerLevel = 4;
    private Weapon startWeapon = new Dagger();

    public String head = "" +
            "   ┌──────────────\\\n" +
            "   | ─────────── |     \n" +
            "  │ │            │  \\\n" +
            " │ │   ●     ●    │  |\n" +
            " │ │              │  |\n" +
            " │ │     ▴       │   |\n" +
            " │ │             │   |\n" +
            " │  │   ─────    │  /\n" +
            "  │  │─────────│/|─/\n" +
            "   └─╦───────╦─┘\n" +
            "    ╱│       │╲\n" +
            "   ╱ │       │ ╲\n" +
            "  ╱  │       │  ╲";

    public Robber() {
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
        return "robber";
    }

    @Override
    public String toString() {
        return "Robber lvl: " + lvl + '\n';
    }

    @Override
    public int lvlUp() {
        return ++this.lvl;
    }
}
