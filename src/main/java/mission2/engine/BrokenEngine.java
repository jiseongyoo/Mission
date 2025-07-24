package mission2.engine;

import mission2.car.Car;

public class BrokenEngine extends Engine {
    public BrokenEngine(Car car) {
        super(car);
        this.name = "BROKEN";
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
