public class BattleScene {
    private ConsoleFighter player;
    private ConsoleFighter enemy;

    public BattleScene() {
        player = new ConsoleFighter("Герой", 5, 3);
        enemy = new ConsoleFighter("Орк", 40, 3);
    }

    public void drawBattlefield() {
        clearConsole();

        // Отрисовка игрового поля
        System.out.println("=== БИТВА ===");
        System.out.println();

        // Отрисовка игроков
        player.draw(player.getIdleFrames(), 0);
        enemy.draw(enemy.getIdleFrames(), 0);

        // Разделитель
        setCursorPosition(0, 10);
        System.out.println("----------------------------------------");
        System.out.println("Атака (A) | Защита (D) | Лечение (H)");
    }

    public void playerAttack() {
        player.attack();
        enemy.takeDamage(20);

        // Анимация получения урона врагом
        setCursorPosition(enemy.getX(), enemy.getY() + 4);
        System.out.println("-20 HP!");
    }

    public static void main(String[] args) {
        BattleScene battle = new BattleScene();
        battle.drawBattlefield();

        // Пример боя
        try {
            Thread.sleep(1000);
            battle.playerAttack();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Методы clearConsole и setCursorPosition аналогичны предыдущему примеру
    private static void clearConsole() { /* ... */ }
    private static void setCursorPosition(int x, int y) { /* ... */ }
}