package mission2.engine;

import mission2.car.Car;

public class GMEngine extends Engine {
    public GMEngine(Car car) {
        super(car);
        this.name = "GM";
    }

    @Override
    public boolean isValidCheck() {
        return true;
    }

    @Override
    public boolean testCheck() {
        return true;
    }
}
