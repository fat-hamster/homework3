import java.util.Random;
import java.util.Scanner;

public class FirstTask {
    private final Scanner sc;
    private final Random rnd;
    private int chance;

    FirstTask() {
        sc = new Scanner(System.in);
        rnd = new Random();
    }

    public void start(int chance) {
        this.chance = chance;
        mainLoop();
    }

    public void start() {
        start(3);
    }

    private void mainLoop(){
        int player_number;

        do {
            int user_try = chance;
            int secret_number = rnd.nextInt(10);
            do {
                mainTitle(user_try);
                if(sc.hasNextInt()) {
                    player_number = sc.nextInt();
                } else {
                    System.out.println("Необходимо ввести число");
                    sc.next();
                    continue;
                }
                if(player_number == secret_number) {
                    System.out.println("Вы выиграли!!!!");
                    break;
                }
                if (player_number > secret_number) {
                    System.out.println("Загаданное число меньше.");
                } else {
                    System.out.println("Загаданное число больше.");
                }
                user_try--;
            } while (user_try > 0);
        } while (doExit());
    }

    private boolean doExit() {
        System.out.println("Сыграть еще раз? (y/n)");

        String answer = sc.next();

        switch (answer) {
            case "y", "Y", "д", "Д" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    private void mainTitle(int n) {
        System.out.println("Программа загадало число от 0 до 9, угадайте его!");
        System.out.println("Попыток осталось: " + n);
    }

}
