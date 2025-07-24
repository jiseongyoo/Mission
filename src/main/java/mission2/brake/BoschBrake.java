package mission2.brake;

import mission2.car.Car;
import mission2.steer.BoschSteer;

public class BoschBrake extends Brake {
    public BoschBrake(Car car) {
        super(car);
        this.name = "Bosch";
    }

    @Override
    public boolean isValidCheck() {
        if (car.getSteer() instanceof BoschSteer) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean testCheck() {
        if (isValidCheck()) {
            return true;
        } else {
            assemblyTestFailed("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
            return false;
        }
    }
}
