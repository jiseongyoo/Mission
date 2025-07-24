package mission2.engine;

import mission2.Part;
import mission2.car.Car;

public abstract class Engine extends Part {
    public Engine(Car car) {
        this.car = car;
    }

    public static void showMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }
}
