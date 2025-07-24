package mission2.steer;

import mission2.Part;
import mission2.car.Car;

public abstract class Steer extends Part {
    public Steer(Car car) {
        this.car = car;
    }
    public static void showMenu() {
        System.out.println("어떤 조향장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. BOSCH");
        System.out.println("2. MOBIS");
        System.out.println("===============================");
    }
}
