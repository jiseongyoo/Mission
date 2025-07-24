package mission2.brake;

import mission2.car.Car;
import mission2.car.Sedan;

public class ContinentalBrake extends Brake {
    public ContinentalBrake(Car car) {
        super(car);
        this.name = "Continental";
    }

    @Override
    public boolean isValidCheck() {
        if (this.car instanceof Sedan) {
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
            assemblyTestFailed("Sedan에는 Continental제동장치 사용 불가");
            return false;
        }
    }

}
