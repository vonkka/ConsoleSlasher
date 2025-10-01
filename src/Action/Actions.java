package Action;
import Character.*;
import Monster.*;

import java.util.*;

public class Actions implements ActionsInterface{
    private final int NUM_MONSTERS = 6;
    private final int NUM_BATTLES = 5;
    private Monster[] monsters = new Monster[NUM_MONSTERS];
    private final Random rand = new Random();

    public Actions() {
        rand.setSeed(System.currentTimeMillis());
        this.monsters[0] = new Goblin();
        this.monsters[1] = new Skeleton();
        this.monsters[2] = new Slime();
        this.monsters[3] = new Ghost();
        this.monsters[4] = new Golem();
        this.monsters[5] = new Dragon();
        List<Monster> list = new ArrayList<>(Arrays.asList(monsters));
        Collections.shuffle(list);
        monsters = list.toArray(new Monster[NUM_MONSTERS]);
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public int getNUM_BATTLES() {
        return NUM_BATTLES;
    }

    @Override
    public MainCharacterInterface createMainCharacter() {
        MainCharacter character = new MainCharacter();

        character.setDamage(character.getStrength());
        character.setHealth(character.getStamina());
        return character;
    }

    public int getNUM_MONSTERS() {
        return NUM_MONSTERS;
    }

    @Override
    public void winGame() {
        System.out.println("You won!");
    }

    @Override
    public void loseGame() {
        System.out.println("You lose!");
    }
}
