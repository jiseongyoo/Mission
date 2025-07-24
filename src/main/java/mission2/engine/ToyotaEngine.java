package mission2.engine;

import mission2.car.Car;
import mission2.car.SUV;

public class ToyotaEngine extends Engine {
    public ToyotaEngine(Car car) {
        super(car);
        this.name = "TOYOTA";
    }

    @Override
    public boolean isValidCheck() {
        if (this.car instanceof SUV) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean testCheck() {
        if (isValidCheck()) {
            return true;
        } else {
            assemblyTestFailed("SUV에는 TOYOTA엔진 사용 불가");
            return false;
        }
    }
}
