import Action.Actions;
import Action.ActionsInterface;
import CharachterClass.*;
import Character.*;
import Monster.Monster;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // START GAME
        // (0 = ROBBER, 1 = WARRIOR, 2 = BARBARIAN)
        Scanner scanner = new Scanner(System.in);
        ActionsInterface actions = new Actions();
        MainCharacterInterface character = actions.createMainCharacter();
        System.out.println(character);

        // CHOOSE SPECIALIZATION
        System.out.println("Choose your start class: ");
        Specialization specialization = switch (scanner.nextLine()) {
            case "robber" -> new Robber();
            case "warrior" -> new Warrior();
            case "barbarian" -> new Barbarian();
            default -> null;
        };
        character.addSpecialization(specialization);
        System.out.println(character);

        // BATTLES
        for (int i = 0; i < actions.getNUM_BATTLES(); ++i) {

            Monster opponent = actions.getMonsters()[i];
            System.out.println("Battle started vs " + opponent);
            if (character.startBattle(opponent) == 0) {
                actions.loseGame();
                return;
            }
            // Change weapon
            System.out.println("Do you want to change your weapon on " + opponent.getReward());
            if (scanner.nextLine().equals("yes")) {
                character.equipWeapon(opponent.getReward());
            }
            // Lvlup class
            if (character.getLvl() < 3) {
                System.out.println("Choose class to lvlUp: ");
                String numSpec = scanner.nextLine();
                character.lvlUp(switch (numSpec) {
                    case "robber" -> new Robber();
                    case "warrior" -> new Warrior();
                    case "barbarian" -> new Barbarian();
                    default -> null;
                });
            } else {
                System.out.println("You reached maximum level " + character.getLvl());
            }

        }

        actions.winGame();
    }
}