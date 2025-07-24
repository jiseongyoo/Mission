package mssion1;

import java.util.Scanner;

public class Assemble {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    private static final int CAR_TYPE = 0;
    private static final int ENGINE = 1;
    private static final int BRAKE_SYSTEM = 2;
    private static final int STEERING_SYSTEM = 3;
    private static final int RUN_TEST = 4;

    private static final int SEDAN = 1, SUV = 2, TRUCK = 3;
    private static final int GM = 1, TOYOTA = 2, WIA = 3, BROKEN = 4;
    private static final int MANDO = 1, CONTINENTAL = 2, BOSCH_BRAKE = 3;
    private static final int BOSCH_STEER = 1, MOBIS = 2;

    public static final int USER_INPUT_DELAY_MS = 800;
    public static final int DELAY_BEFORE_TEST_CAR_MS = 1500;
    public static final int DELAY_AFTER_RUN_TEST_CAR_MS = 2000;

    private static int[] assembleStep = new int[5];
    private static final String[] carNames = {"", "Sedan", "SUV", "Truck"};
    private static final String[] engineNames = {"", "GM", "TOYOTA", "WIA"};
    private static final String[] brakeNames = {"", "Mando", "Continental", "Bosch"};
    private static final String[] steeringNames = {"", "Bosch", "Mobis"};

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int currentStep = CAR_TYPE;

            while (true) {
                showMenuForUserInput(currentStep);
                String userInputString = getUserInput(scanner);

                if (userInputString.equalsIgnoreCase("exit")) {
                    System.out.println("바이바이");
                    break;
                }

                int userInput;
                try {
                    userInput = parseUserInput(currentStep, userInputString);
                } catch (IllegalArgumentException e) {
                    continue;
                }

                if (userInput == 0) {
                    currentStep = getStepWhenUserInputZero(currentStep);
                } else {
                    if (currentStep == RUN_TEST) {
                        runTestProducedCar(userInput);
                    } else {
                        currentStep = selectCarParts(currentStep, userInput);
                    }
                }
            }
        }
    }

    private static void showMenuForUserInput(int currentStep) {
        clearScreen();
        switch (currentStep) {
            case CAR_TYPE -> showCarTypeMenu();
            case ENGINE -> showEngineMenu();
            case BRAKE_SYSTEM -> showBrakeMenu();
            case STEERING_SYSTEM -> showSteeringMenu();
            case RUN_TEST -> showRunTestMenu();
        }
    }

    private static void clearScreen() {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
    }

    private static void showCarTypeMenu() {
        System.out.println("        ______________");
        System.out.println("       /|            |");
        System.out.println("  ____/_|_____________|____");
        System.out.println(" |                      O  |");
        System.out.println(" '-(@)----------------(@)--'");
        System.out.println("===============================");
        System.out.println("어떤 차량 타입을 선택할까요?");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Truck");
        System.out.println("===============================");
    }

    private static void showEngineMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }

    private static void showBrakeMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }

    private static void showSteeringMenu() {
        System.out.println("어떤 조향장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. BOSCH");
        System.out.println("2. MOBIS");
        System.out.println("===============================");
    }

    private static void showRunTestMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }

    private static String getUserInput(Scanner scanner) {
        System.out.print("INPUT > ");
        return scanner.nextLine().trim();
    }

    private static int parseUserInput(int currentStep, String userInputString) throws IllegalArgumentException {
        int userInput;
        try {
            userInput = Integer.parseInt(userInputString);
        } catch (NumberFormatException e) {
            System.out.println("ERROR :: 숫자만 입력 가능");
            delay(USER_INPUT_DELAY_MS);
            throw new IllegalArgumentException();
        }

        if (!isValidRange(currentStep, userInput)) {
            delay(USER_INPUT_DELAY_MS);
            throw new IllegalArgumentException();
        }
        return userInput;
    }

    private static boolean isValidRange(int assembleStep, int userInput) {
        switch (assembleStep) {
            case CAR_TYPE:
                if (!isInclusiveBetween(userInput, 1, 3)) {
                    System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case ENGINE:
                if (!isInclusiveBetween(userInput, 0, 4)) {
                    System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
                    return false;
                }
                break;
            case BRAKE_SYSTEM:
                if (!isInclusiveBetween(userInput, 0, 3)) {
                    System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case STEERING_SYSTEM:
                if (!isInclusiveBetween(userInput, 0, 2)) {
                    System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
                    return false;
                }
                break;
            case RUN_TEST:
                if (!isInclusiveBetween(userInput, 0, 2)) {
                    System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
                    return false;
                }
                break;
        }
        return true;
    }

    private static int getStepWhenUserInputZero(int currentStep) {
        if (currentStep == RUN_TEST) {
            currentStep = CAR_TYPE;
        } else if (currentStep > CAR_TYPE) {
            currentStep--;
        }
        return currentStep;
    }

    private static void runTestProducedCar(int userInput) {
        if (userInput == 1) {
            runProducedCar();
        } else if (userInput == 2) {
            System.out.println("Test...");
            delay(DELAY_BEFORE_TEST_CAR_MS);
            testProducedCar();
        }
        delay(DELAY_AFTER_RUN_TEST_CAR_MS);
    }

    private static void runProducedCar() {
        if (!isValidCheck()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (isEngine(BROKEN)) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        System.out.printf("Car Type : %s\n", carNames[assembleStep[CAR_TYPE]]);
        System.out.printf("Engine   : %s\n", engineNames[assembleStep[ENGINE]]);
        System.out.printf("Brake    : %s\n", brakeNames[assembleStep[BRAKE_SYSTEM]]);
        System.out.printf("Steering : %s\n", steeringNames[assembleStep[STEERING_SYSTEM]]);
        System.out.println("자동차가 동작됩니다.");
    }

    private static boolean isValidCheck() {
        if (isCarType(SEDAN) && isBrakeSystem(CONTINENTAL)){
            return false;
        } else if (isCarType(SUV) && isEngine(TOYOTA)) {
            return false;
        } else if (isCarType(TRUCK)) {
            if (isEngine(WIA) || isBrakeSystem(MANDO)) {
                return false;
            }
        }
        if (isBrakeSystem(BOSCH_BRAKE) && isSteeringSystem(BOSCH_STEER)) {
            return false;
        }
        return true;
    }

    private static void testProducedCar() {
        if (isCarType(SEDAN) && isBrakeSystem(CONTINENTAL)) {
            assemblyTestFailed("Sedan에는 Continental제동장치 사용 불가");
        } else if (isCarType(SUV) && isEngine(TOYOTA)) {
            assemblyTestFailed("SUV에는 TOYOTA엔진 사용 불가");
        } else if (isCarType(TRUCK)) {
            if (isEngine(WIA)) {
                assemblyTestFailed("Truck에는 WIA엔진 사용 불가");
            }
            if (isBrakeSystem(MANDO)) {
                assemblyTestFailed("Truck에는 Mando제동장치 사용 불가");
            }
        } else if (isBrakeSystem(BOSCH_BRAKE) && !isSteeringSystem(BOSCH_STEER)) {
            assemblyTestFailed("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
        } else {
            System.out.println("자동차 부품 조합 테스트 결과 : PASS");
        }
    }

    private static void assemblyTestFailed(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }

    private static int selectCarParts(int currentStep, int userInput) {
        int nextStep = switch (currentStep) {
            case CAR_TYPE -> {
                selectCarType(userInput);
                yield ENGINE;
            }
            case ENGINE -> {
                selectEngine(userInput);
                yield BRAKE_SYSTEM;
            }
            case BRAKE_SYSTEM -> {
                selectBrakeSystem(userInput);
                yield STEERING_SYSTEM;
            }
            case STEERING_SYSTEM -> {
                selectSteeringSystem(userInput);
                yield RUN_TEST;
            }
            default -> 0;
        };
        delay(USER_INPUT_DELAY_MS);
        return nextStep;
    }

    private static void selectCarType(int userInput) {
        assembleStep[CAR_TYPE] = userInput;
        String carType = switch (userInput) {
            case 1 -> "Sedan";
            case 2 -> "SUV";
            default -> "Truck";
        };
        System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", carType);
    }

    private static void selectEngine(int userInput) {
        assembleStep[ENGINE] = userInput;
        String engineType = switch (userInput) {
            case 1 -> "GM";
            case 2 -> "TOYOTA";
            default -> "고장난 엔진";
        };
        System.out.printf("%s 엔진을 선택하셨습니다.\n", engineType);
    }

    private static void selectBrakeSystem(int userInput) {
        assembleStep[BRAKE_SYSTEM] = userInput;
        String brakeType = switch (userInput) {
            case 1 -> "MANDO";
            case 2 -> "CONTINENTAL";
            default -> "BOSCH";
        };
        System.out.printf("%s 제동장치를 선택하셨습니다.\n", brakeType);
    }

    private static void selectSteeringSystem(int userInput) {
        assembleStep[STEERING_SYSTEM] = userInput;
        String steeringType = switch (userInput) {
            case 1 -> "BOSCH";
            default -> "MOBIS";
        };
        System.out.printf("%s 조향장치를 선택하셨습니다.\n", steeringType);
    }

    private static boolean isCarType(int carType) {
        return assembleStep[CAR_TYPE] == carType;
    }

    private static boolean isEngine(int engine) {
        return assembleStep[ENGINE] == engine;
    }

    private static boolean isBrakeSystem(int brakeSystem) {
        return assembleStep[BRAKE_SYSTEM] == brakeSystem;
    }

    private static boolean isSteeringSystem(int steeringSystem) {
        return assembleStep[STEERING_SYSTEM] == steeringSystem;
    }

    private static boolean isInclusiveBetween(int num, int lower, int upper) {
        return lower <= num && num <= upper;
    }

    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}
