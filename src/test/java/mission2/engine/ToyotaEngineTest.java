package mission2.engine;

import mission2.car.Car;
import mission2.car.SUV;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ToyotaEngineTest {
    private Car mockCar;
    private ToyotaEngine toyotaEngine;

    @BeforeEach
    void setUp() {
        this.mockCar = mock(Car.class);
        this.toyotaEngine = new ToyotaEngine(this.mockCar);
    }

    @DisplayName("이름이 TOYOTA인지 테스트")
    @Test
    public void should_return_GM_when_getName() {
        assertEquals("TOYOTA", this.toyotaEngine.getName());
    }

    @DisplayName("일반적인 차종에 TOYOTA 엔진인 경우 isValidCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_isValidCheck_with_Car() {
        assertTrue(this.toyotaEngine.isValidCheck());
    }

    @DisplayName("SUV에 TOYOTA 엔진인 경우 isValidCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_isValidCheck_with_SUV() {
        this.toyotaEngine = new ToyotaEngine(mock(SUV.class));

        assertFalse(this.toyotaEngine.isValidCheck());
    }

    @DisplayName("일반적인 차종에 TOYOTA 엔진인 경우 testCheck()이 true를 리턴")
    @Test
    public void should_return_true_when_tesCheck_with_Car() {
        assertTrue(this.toyotaEngine.testCheck());
    }

    @DisplayName("SUV에 TOYOTA 엔진인 경우 testCheck()이 false를 리턴")
    @Test
    public void should_return_false_when_testCheck_with_SUV() {
        this.toyotaEngine = new ToyotaEngine(mock(SUV.class));

        assertFalse(this.toyotaEngine.testCheck());
    }
}