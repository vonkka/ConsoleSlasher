import Action.Actions;
import Action.ActionsInterface;
import Character.*;
import Monster.Monster;

public class Main {
    public static void main(String[] args) {
        outer:
        while (true) {
            // START GAME
            ActionsInterface actions = new Actions();

            // RANDOM STATS
            MainCharacterInterface character = actions.createMainCharacter();
            System.out.println("That are stats of your future character:");
            System.out.println(character);

            // CHOOSE SPECIALIZATION
            System.out.println("""
                    Now you are to choose a class\s
                    robber\s
                    warrior\s
                    barbarian
                    """);
            character.lvlUp(actions.chooseSpecialization());


            // BATTLES
            System.out.println("Starting battles");
            for (int i = 0; i < actions.getNUM_BATTLES(); ++i) {
                System.out.println("\nNow your character has those stats:");
                System.out.println(character);

                Monster opponent = actions.getMonsters().get(i);
                actions.nextAction();
                System.out.println("Battle " + (i + 1) + " started vs " + opponent);
                int battleResult = actions.startBattle(character, opponent);
                if (battleResult == 0) {
                    actions.loseGame();
                    if (actions.startAgain() == 0) {
                        return;
                    } else {
                        break outer;
                    }
                } else if (battleResult == 1) {
                    // Change weapon
                    actions.changeWeapon(character, opponent.getReward());

                    // Lvlup class
                    if (character.getLvl() < character.getMAX_LEVEL()) {
                        System.out.println("Choose class to lvlUp: ");
                        character.lvlUp(actions.chooseSpecialization());
                    } else {
                        System.out.println("You reached maximum level " + character.getLvl());
                    }
                }

            }
            actions.winGame();

            if (actions.startAgain() == 0) {
                return;
            }
        }
    }
}