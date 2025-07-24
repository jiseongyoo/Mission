package mission2.brake;

import mission2.Part;
import mission2.car.Car;

public abstract class Brake extends Part {
    public Brake(Car car) {
        this.car = car;
    }

    public static void showMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }
}
