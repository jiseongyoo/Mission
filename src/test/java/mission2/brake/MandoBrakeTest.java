package mission2.brake;

import mission2.car.Car;
import mission2.car.Truck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MandoBrakeTest {
    private Car mockCar;
    private MandoBrake mandoBrake;

    @BeforeEach
    void setUp() {
        this.mockCar = mock(Car.class);
        this.mandoBrake = new MandoBrake(this.mockCar);
    }

    @DisplayName("이름이 Mando인지 테스트")
    @Test
    public void should_return_Mando_when_getName() {
        assertEquals("Mando", this.mandoBrake.getName());
    }

    @DisplayName("일반적인 차종에 Mando 제동장치인 경우 isValidCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_isValidCheck_with_Car() {
        assertTrue(this.mandoBrake.isValidCheck());
    }

    @DisplayName("Truck에 Mando 제동장치인 경우 isValidCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_isValidCheck_with_Truck() {
        this.mandoBrake = new MandoBrake(mock(Truck.class));

        assertFalse(this.mandoBrake.isValidCheck());
    }

    @DisplayName("일반적인 차종에 Mando 제동장치인 경우 testCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_tesCheck_with_Car() {
        assertTrue(this.mandoBrake.testCheck());
    }

    @DisplayName("Truck에 Mando 제동장치인 경우 testCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_testCheck_with_Truck() {
        this.mandoBrake = new MandoBrake(mock(Truck.class));

        assertFalse(this.mandoBrake.testCheck());
    }
}