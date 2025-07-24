package mission2.steer;

import mission2.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class BoschSteerTest {
    private Car mockCar;
    private BoschSteer boschSteer;

    @BeforeEach
    void setUp() {
        this.mockCar = mock(Car.class);
        this.boschSteer = new BoschSteer(this.mockCar);
    }

    @DisplayName("Bosch 조향장치는 사용제한이 없다")
    @Test
    public void should_return_true_when_isValidCheck() {
        assertTrue(this.boschSteer.isValidCheck());
    }

    @DisplayName("Bosch 조향장치는 테스트제한이 없다")
    @Test
    public void should_return_true_when_testCheck() {
        assertTrue(this.boschSteer.testCheck());
    }
}