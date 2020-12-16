import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SecondTask {
    private final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
            "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    private final Random rnd;
    private final Scanner sc;
    private final StringBuffer sb;

    SecondTask() {
        rnd = new Random();
        sc = new Scanner(System.in);
        sb = new StringBuffer("###############");
    }

    public void start() {
        mainLoop();
    }

    private void mainLoop() {
        String secret, word;
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
                if(word.length() == 1) {
                    for (int i = 0; i < secret.length(); i++) {
                        if(secret.charAt(i) == word.charAt(0)) {
                            sb.deleteCharAt(i);
                            sb.insert(i, word.charAt(0));
                        }
                    }
                } else {
                    for (int i = 0; i < secret.length(); i++) {
                        if (i >= word.length()) {
                            break;
                        }
                        if (secret.charAt(i) == word.charAt(i)) {
                            sb.deleteCharAt(i);
                            sb.insert(i, word.charAt(i));
                        }
                    }
                }
            }
            printTitle();
        } while (!word.equalsIgnoreCase("exit"));
    }

    private void printTitle() {
        System.out.println("Программа загадала слово, попробуй его отгадать");
        System.out.println("Загаданное слово это фрукт, овощь или ягода (слово на английском языке)");
        System.out.println("Введите слово или букву. (Для помощи введите help, для выхода exit)");
        System.out.println(sb);
    }

    private void printHelp() {
        System.out.println(Arrays.asList(words).subList(0, words.length / 2));
        System.out.println(Arrays.asList(words).subList(words.length / 2, words.length));
    }
}
