package mission2.brake;

import mission2.car.Car;
import mission2.car.Truck;

public class MandoBrake extends Brake {
    public MandoBrake(Car car) {
        super(car);
        this.name = "Mando";
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
            assemblyTestFailed("Truck에는 Mando제동장치 사용 불가");
            return false;
        }
    }
}
