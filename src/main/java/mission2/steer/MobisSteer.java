package mission2.steer;

import mission2.car.Car;

public class MobisSteer extends Steer {
    public MobisSteer(Car car) {
        super(car);
        this.name = "Mobis";
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
