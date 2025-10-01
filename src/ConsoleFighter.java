public class ConsoleFighter {
    private int x, y; // Позиция на экране
    private String name;
    private int health;

    // Анимационные кадры
    private String[] idleFrames = {
            "  O  \n /|\\ \n / \\ ",
            "  O  \n /|\\ \n / \\ "
    };

    private String[] attackFrames = {
            "  O  \n /|\\>\n / \\ ",
            "  O  \n /|\\ \n / \\ "
    };

    public ConsoleFighter(String name, int startX, int startY) {
        this.name = name;
        this.x = startX;
        this.y = startY;
        this.health = 100;
    }

    // Очистка консоли (работает не во всех IDE)
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            // Если не получилось очистить, просто выводим много пустых строк
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    // Установка позиции курсора
    private void setCursorPosition(int x, int y) {
        System.out.print("\033[" + y + ";" + x + "H");
    }

    // Отрисовка персонажа
    public void draw(String[] frames, int frameIndex) {
        setCursorPosition(x, y);
        System.out.println(name + " (HP: " + health + ")");
        setCursorPosition(x, y + 1);
        System.out.println(frames[frameIndex]);
    }

    public void attack() {
        // Анимация атаки
        for (int i = 0; i < attackFrames.length; i++) {
            clearConsole();
            draw(attackFrames, i);
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    // Геттеры и сеттеры
    public int getHealth() { return health; }
    public int getX() { return x; }
    public int getY() { return y; }

    public String[] getIdleFrames() {
        return idleFrames;
    }
}