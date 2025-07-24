package mission2;

import java.util.Scanner;

import static mission2.util.TimeDelay.delay;

public class Assemble {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";
    private static final int USER_INPUT_DELAY_MS = 800;
    public Factory factory = new Factory();

    public static void main(String[] args) {
        new Assemble().run();
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                clearScreen();
                factory.showMenu();

                String userInputString = getUserInput(scanner);
                if (userInputString.equalsIgnoreCase("exit")) {
                    System.out.println("바이바이");
                    break;
                }

                int userInput;
                try {
                    userInput = parseUserInput(userInputString);
                } catch (IllegalArgumentException e) {
                    continue;
                }

                if (!factory.getUserInput(userInput)) {
                    delay(USER_INPUT_DELAY_MS);
                }
            }
        }
    }

    private void clearScreen() {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
    }

    public String getUserInput(Scanner scanner) {
        System.out.print("INPUT > ");
        return scanner.nextLine().trim();
    }

    private int parseUserInput(String userInputString) throws IllegalArgumentException {
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

    void setFactory(Factory newFactory) {
        this.factory = newFactory;
    }
}
