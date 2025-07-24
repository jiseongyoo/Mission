package mission2.engine;

import mission2.car.Car;
import mission2.car.SUV;
import mission2.car.Truck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class WIAEngineTest {
    private Car mockCar;
    private WiaEngine wiaEngine;

    @BeforeEach
    void setUp() {
        this.mockCar = mock(Car.class);
        this.wiaEngine = new WiaEngine(this.mockCar);
    }

    @DisplayName("이름이 WIA인지 테스트")
    @Test
    public void should_return_WIA_when_getName() {
        assertEquals("WIA", this.wiaEngine.getName());
    }

    @DisplayName("일반적인 차종에 TOYOTA 엔진인 경우 isValidCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_isValidCheck_with_Car() {
        assertTrue(this.wiaEngine.isValidCheck());
    }

    @DisplayName("Truck에 TOYOTA 엔진인 경우 isValidCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_isValidCheck_with_Truck() {
        this.wiaEngine = new WiaEngine(mock(Truck.class));

        assertFalse(this.wiaEngine.isValidCheck());
    }

    @DisplayName("일반적인 차종에 WIA 엔진인 경우 testCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_tesCheck_with_Car() {
        assertTrue(this.wiaEngine.testCheck());
    }

    @DisplayName("Truck에 WIA 엔진인 경우 testCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_testCheck_with_Truck() {
        this.wiaEngine = new WiaEngine(mock(Truck.class));

        assertFalse(this.wiaEngine.testCheck());
    }
}