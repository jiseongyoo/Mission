package mission2;

import mission2.car.Car;

public abstract class Part {
    protected String name;
    protected Car car;

    public abstract boolean isValidCheck();

    public abstract boolean testCheck();

    public String getName() {
        return this.name;
    }

    protected static void assemblyTestFailed(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }
}
