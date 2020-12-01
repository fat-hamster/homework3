import java.util.Random;
import java.util.Scanner;

public class SecondTask {
    private String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
            "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private String secret, word;
    private final Random rnd;
    private Scanner sc;
    private String mask;

    SecondTask() {
        rnd = new Random();
        sc = new Scanner(System.in);
        mask = "###############";
    }

    public void start() {
        mainLoop();
    }

    private void mainLoop() {
        mainTitle();
        do {
            secret = words[rnd.nextInt(words.length)];
            do {
                word = sc.next();
                if(word.isEmpty()) {
                    continue;
                }
                if(word.length() != 1) {
                    // введено слово
                    if(word.equalsIgnoreCase(secret)){
                        // Выиграл
                    }
                } else {
                    // введена буква
                    char ch = word.toLowerCase().charAt(0);

                }
            }while (true);
        }while (true);
    }

    private void mainTitle() {
        System.out.println("Программа загадала слово, попробуй отгадать вводя буквы");
        System.out.println("Если буква в этом слове есть, она отобразится на своем месте");
        System.out.println("Загаданное слово это фрукт, овощь или ягода (слово на английском языке)");
        System.out.println("Введите букву или слово целиком");
        System.out.println(mask);
    }
}
