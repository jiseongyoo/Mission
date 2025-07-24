package mission2;

import mission2.brake.BoschBrake;
import mission2.brake.Brake;
import mission2.brake.ContinentalBrake;
import mission2.brake.MandoBrake;
import mission2.car.Car;
import mission2.car.SUV;
import mission2.car.Sedan;
import mission2.car.Truck;
import mission2.engine.*;
import mission2.steer.BoschSteer;
import mission2.steer.MobisSteer;
import mission2.steer.Steer;

public class Factory {
    public static final int CAR_TYPE = 0;
    public static final int ENGINE = 1;
    public static final int BRAKE_SYSTEM = 2;
    public static final int STEER_SYSTEM = 3;
    public static final int RUN_TEST = 4;

    private int currentStep = 0;
    private Car car = new Car();

    public Car getCar() {
        return this.car;
    }

    public void showMenu() {
        switch (currentStep) {
            case 0 -> Car.showMenu();
            case 1 -> Engine.showMenu();
            case 2 -> Brake.showMenu();
            case 3 -> Steer.showMenu();
            default -> Factory.showRunTestMenu();
        }
    }

    public boolean getUserInput(int userInput) {
        if (userInput == 0) {
            setNextStepWhenUserInputZero();
            return true;
        }

        switch (currentStep) {
            case 0: return selectCarType(userInput);
            case 1: return selectEngine(userInput);
            case 2: return selectBrake(userInput);
            case 3: return selectSteer(userInput);
            case 4: return runTestCar(userInput);
        }
        return false;
    }

    private void setNextStepWhenUserInputZero() {
        if (currentStep == RUN_TEST) {
            currentStep = CAR_TYPE;
        } else if (currentStep > CAR_TYPE) {
            currentStep--;
        }
    }

    private boolean selectCarType(int userInput) {
        switch (userInput) {
            case 1 -> this.car = new Sedan();
            case 2 -> this.car = new SUV();
            case 3 -> this.car = new Truck();
            default -> {
                System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
                return false;
            }
        }
        currentStep = ENGINE;
        return true;
    }

    private boolean selectEngine(int userInput) {
        switch (userInput) {
            case 1 -> this.car.setEngine(new GMEngine(this.car));
            case 2 -> this.car.setEngine(new ToyotaEngine(this.car));
            case 3 -> this.car.setEngine(new WiaEngine(this.car));
            case 4 -> this.car.setEngine(new BrokenEngine(this.car));
            default -> {
                System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
                return false;
            }
        }
        currentStep = BRAKE_SYSTEM;
        return true;
    }

    private boolean selectBrake(int userInput) {
        switch (userInput) {
            case 1 -> this.car.setBrake(new MandoBrake(this.car));
            case 2 -> this.car.setBrake(new ContinentalBrake(this.car));
            case 3 -> this.car.setBrake(new BoschBrake(this.car));
            default -> {
                System.out.println("ERROR :: 엔진은 1 ~ 3 범위만 선택 가능");
                return false;
            }
        }
        currentStep = STEER_SYSTEM;
        return true;
    }

    private boolean selectSteer(int userInput) {
        switch (userInput) {
            case 1 -> this.car.setSteer(new BoschSteer(this.car));
            case 2 -> this.car.setSteer(new MobisSteer(this.car));
            default -> {
                System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
                return false;
            }
        }
        currentStep = RUN_TEST;
        return true;
    }

    private boolean runTestCar(int userInput) {
        switch (userInput) {
            case 1 -> this.car.run();
            case 2 -> this.car.test();
            default -> {
                System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
                return false;
            }
        }
        return true;
    }

    private static void showRunTestMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }

    // For Testing
    void setCurrentStep(int newStep) {
        this.currentStep = newStep;
    }

    // For Testing
    int getCurrentStep() {
        return this.currentStep;
    }

    // For Testing
    void setCar(Car car) {
        this.car = car;
    }
}
