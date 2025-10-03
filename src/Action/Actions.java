package Action;
import Battle.Battle;
import CharachterClass.Barbarian;
import CharachterClass.Robber;
import CharachterClass.Specialization;
import CharachterClass.Warrior;
import Character.*;
import Monster.*;
import Weapon.Weapon;

import java.util.*;

public class Actions implements ActionsInterface{
    private final int NUM_BATTLES = 5;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private final Random rand = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public Actions() {
        rand.setSeed(System.currentTimeMillis());
        monsters.add(new Goblin());
        monsters.add(new Skeleton());
        monsters.add(new Golem());
        monsters.add(new Slime());
        monsters.add(new Ghost());
        monsters.add(new Dragon());
        Collections.shuffle(monsters);
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public int getNUM_BATTLES() {
        return NUM_BATTLES;
    }

    @Override
    public Specialization chooseSpecialization() {
        Specialization specialization = null;
        while (specialization == null) {
            switch (scanner.nextLine().toLowerCase()) {
                case "robber":
                    specialization = new Robber(); break;
                case "warrior":
                    specialization = new Warrior(); break;
                case "barbarian":
                    specialization = new Barbarian(); break;
                default:
                    System.out.println("Please enter a valid class");
            }
        }
        return specialization;
    }

    @Override
    public int startBattle(MainCharacterInterface character, Monster monster) {
        return new Battle(character, monster).startBattle();
    }

    public void nextAction() {
        scanner.nextLine();
    }

    @Override
    public Weapon changeWeapon(MainCharacterInterface character, Weapon weapon) {
        System.out.println("Do you want to change your weapon on " + weapon + '\n' +
                "yes \n" +
                "no \n");
        String answer = scanner.nextLine().toLowerCase();
        while (!answer.equals("yes") && !answer.equals("no")) {
            System.out.println("Please print 'yes' or 'no'");
            answer = scanner.nextLine();
        }
        if (answer.equals("yes")) {
            character.equipWeapon(weapon);
        }
        return null;
    }

    @Override
    public MainCharacterInterface createMainCharacter() {
        MainCharacter character = new MainCharacter(
                1 + rand.nextInt(3),
                1 + rand.nextInt(3),
                1 + rand.nextInt(3));

        character.setDamage(character.getStrength());
        return character;
    }

    @Override
    public void winGame() {
        System.out.println("You won!");
    }

    @Override
    public void loseGame() {
        System.out.println("You lose!");
    }

    public int startAgain() {
        System.out.println("Do you want to play once again?");
        String answer = scanner.nextLine().toLowerCase();
        while (!answer.equals("yes") && !answer.equals("no")) {
            System.out.println("Please print 'yes' or 'no'");
        }
        if (answer.equals("yes")) {
            return 1;
        }
        return 0;
    }
}
