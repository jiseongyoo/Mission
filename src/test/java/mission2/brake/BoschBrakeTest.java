package mission2.brake;

import mission2.car.Car;
import mission2.car.Sedan;
import mission2.steer.BoschSteer;
import mission2.steer.Steer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BoschBrakeTest {
    private Car mockCar;
    private BoschBrake boschBrake;

    @BeforeEach
    void setUp() {
        this.mockCar = mock(Car.class);
        this.boschBrake = new BoschBrake(this.mockCar);
    }

    @DisplayName("이름이 Bosch인지 테스트")
    @Test
    public void should_return_Bosch_when_getName() {
        assertEquals("Bosch", this.boschBrake.getName());
    }

    @DisplayName("Bosch 조향장치에 Bosch 제동장치인 경우 isValidCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_isValidCheck_with_Car() {
        when(this.mockCar.getSteer()).thenReturn(mock(BoschSteer.class));

        assertTrue(this.boschBrake.isValidCheck());
    }

    @DisplayName("일반적인 조향장치에 Bosch 제동장치인 경우 isValidCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_isValidCheck_with_usual_steer() {
        when(this.mockCar.getSteer()).thenReturn(mock(Steer.class));

        assertFalse(this.boschBrake.isValidCheck());
    }

    @DisplayName("Bosch 조향장치에 Bosch 제동장치인 경우 testCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_tesCheck_with_Car() {
        when(this.mockCar.getSteer()).thenReturn(mock(BoschSteer.class));

        assertTrue(this.boschBrake.testCheck());
    }

    @DisplayName("일반적인 조향장치에 Bosch 제동장치인 경우 testCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_testCheck_with_Sedan() {
        when(this.mockCar.getSteer()).thenReturn(mock(Steer.class));

        assertFalse(this.boschBrake.testCheck());
    }
}