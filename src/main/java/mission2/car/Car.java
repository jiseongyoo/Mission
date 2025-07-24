package mission2.car;

import mission2.brake.Brake;
import mission2.engine.BrokenEngine;
import mission2.engine.Engine;
import mission2.steer.Steer;

import static mission2.util.TimeDelay.delay;

public class Car {
    protected String name = "";
    private Engine engine;
    private Brake brake;
    private Steer steer;

    public static final int USER_INPUT_DELAY_MS = 800;
    public static final int DELAY_BEFORE_TEST_CAR_MS = 1500;
    public static final int DELAY_AFTER_RUN_TEST_CAR_MS = 2000;

    public String getName() {
        return this.name;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
    }

    public Brake getBrake() {
        return this.brake;
    }

    public void setSteer(Steer steer) {
        this.steer = steer;
    }

    public Steer getSteer() {
        return this.steer;
    }

    public static void showMenu() {
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

    public void run() {
        if (isMulfuncationing()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        } else if (isEngineBroken()) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        System.out.printf("Car Type : %s\n", this.name);
        System.out.printf("Engine   : %s\n", this.engine.getName());
        System.out.printf("Brake    : %s\n", this.brake.getName());
        System.out.printf("Steering : %s\n", this.steer.getName());
        System.out.println("자동차가 동작됩니다.");
        delay(DELAY_AFTER_RUN_TEST_CAR_MS);
    }

    private boolean isMulfuncationing() {
        return !this.engine.isValidCheck() || !this.brake.isValidCheck() || !this.steer.isValidCheck();
    }

    private boolean isEngineBroken() {
        return this.engine instanceof BrokenEngine;
    }

    public void test() {
        System.out.println("Test...");
        delay(DELAY_BEFORE_TEST_CAR_MS);
        if (this.engine.testCheck() && this.brake.testCheck() && this.steer.testCheck()) {
            System.out.println("자동차 부품 조합 테스트 결과 : PASS");
        }
        delay(DELAY_AFTER_RUN_TEST_CAR_MS);
    }
}
