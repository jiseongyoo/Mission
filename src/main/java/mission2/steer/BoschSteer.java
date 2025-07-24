package mission2.steer;

import mission2.car.Car;

public class BoschSteer extends Steer {
    public BoschSteer(Car car) {
        super(car);
        this.name = "Bosch";
    }

    @Override
    public boolean isValidCheck() {
        return true;
    }

    @Override
    public boolean testCheck() {
        return isValidCheck();
    }
}
