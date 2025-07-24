package mission2.brake;

import mission2.car.Car;
import mission2.car.Sedan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ContinentalBrakeTest {
    private Car mockCar;
    private ContinentalBrake continentalBrake;

    @BeforeEach
    void setUp() {
        this.mockCar = mock(Car.class);
        this.continentalBrake = new ContinentalBrake(this.mockCar);
    }

    @DisplayName("이름이 Continental인지 테스트")
    @Test
    public void should_return_Continental_when_getName() {
        assertEquals("Continental", this.continentalBrake.getName());
    }

    @DisplayName("일반적인 차종에 Continental 제동장치인 경우 isValidCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_isValidCheck_with_Car() {
        assertTrue(this.continentalBrake.isValidCheck());
    }

    @DisplayName("Sedan에 Continental 제동장치인 경우 isValidCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_isValidCheck_with_Sedan() {
        this.continentalBrake = new ContinentalBrake(mock(Sedan.class));

        assertFalse(this.continentalBrake.isValidCheck());
    }

    @DisplayName("일반적인 차종에 Continental 제동장치인 경우 testCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_tesCheck_with_Car() {
        assertTrue(this.continentalBrake.testCheck());
    }

    @DisplayName("Sedan에 Continental 제동장치인 경우 testCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_testCheck_with_Sedan() {
        this.continentalBrake = new ContinentalBrake(mock(Sedan.class));

        assertFalse(this.continentalBrake.testCheck());
    }
}