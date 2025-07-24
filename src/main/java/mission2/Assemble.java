package mission2;

import java.util.Scanner;

import static mission2.util.TimeDelay.delay;

public class Assemble {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";
    public static final int USER_INPUT_DELAY_MS = 800;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Factory factory = new Factory();

            while (true) {
                clearScreen();
                factory.showMenu();
                String userInputString = getUserInput(scanner);
                int userInput;
                try {
                    userInput = parseUserInput(userInputString);
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR :: 숫자만 입력 가능");
                    delay(USER_INPUT_DELAY_MS);
                    continue;
                }

                if (!factory.getUserInput(userInput)) {
                    delay(USER_INPUT_DELAY_MS);
                }
            }
        }
    }

    private static void clearScreen() {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
    }

    private static String getUserInput(Scanner scanner) {
        System.out.print("INPUT > ");
        return scanner.nextLine().trim();
    }

    private static int parseUserInput(String userInputString) throws IllegalArgumentException {
        int userInput;
        try {
            userInput = Integer.parseInt(userInputString);
        } catch (NumberFormatException e) {
            System.out.println("ERROR :: 숫자만 입력 가능");
            delay(USER_INPUT_DELAY_MS);
            throw new IllegalArgumentException();
        }

        return userInput;
    }
}
