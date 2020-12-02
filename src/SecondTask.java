import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SecondTask {
    private String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
            "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private String secret, word;
    private final Random rnd;
    private final Scanner sc;
    private StringBuffer sb;

    SecondTask() {
        rnd = new Random();
        sc = new Scanner(System.in);
        sb = new StringBuffer("###############");
    }

    public void start() {
        mainLoop();
    }

    private void mainLoop() {
        printTitle();
        secret = words[rnd.nextInt(words.length)];
        do {
            word = sc.next();
            if(word.equalsIgnoreCase("help")) {
                printHelp();
                printTitle();
                continue;
            }
            if (word.equalsIgnoreCase(secret)) {
                System.out.println("Правильно!!!");
                System.exit(0);
            } else {
                for (int i = 0; i < secret.length(); i++) {
                    if (i >= word.length()) {
                        break;
                    }
                    if(secret.charAt(i) == word.charAt(i)) {
                        sb.deleteCharAt(i);
                        sb.insert(i, word.charAt(i));
                    }
                }
            }
            printTitle();
        } while (!word.equalsIgnoreCase("exit"));
    }

    private void printTitle() {
        System.out.println("Программа загадала слово, попробуй его отгадать");
        System.out.println("Загаданное слово это фрукт, овощь или ягода (слово на английском языке)");
        System.out.println("Введите слово. (Для помощи введите help, для выхода exit)");
        System.out.println(sb);
    }

    private void printHelp() {
        System.out.println(Arrays.asList(words).subList(0, words.length / 2));
        System.out.println(Arrays.asList(words).subList(words.length / 2, words.length));
    }
}
