package mission2.engine;

import mission2.car.Car;
import mission2.car.Truck;

public class WiaEngine extends Engine {
    public WiaEngine(Car car) {
        super(car);
        this.name = "WIA";
    }

    @Override
    public boolean isValidCheck() {
        if (this.car instanceof Truck) {
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
            assemblyTestFailed("Truck에는 WIA엔진 사용 불가");
            return false;
        }
    }
}
