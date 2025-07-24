package mission2.engine;

import mission2.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BrokenEngineTest {
    private Car mockCar;
    private BrokenEngine brokenEngine;

    @BeforeEach
    void setUp() {
        this.mockCar = mock(Car.class);
        this.brokenEngine = new BrokenEngine(this.mockCar);
    }

    @DisplayName("이름이 BROKEN인지 테스트")
    @Test
    public void should_return_BROKEN_when_getName() {
        assertEquals("BROKEN", this.brokenEngine.getName());
    }

    @DisplayName("BROKEN 엔진은 항상 사용할 수 없다")
    @Test
    public void should_return_true_when_isValidCheck() {
        assertTrue(this.brokenEngine.isValidCheck());
    }

    @DisplayName("BROKEN 엔진은 테스트 제한이 없다")
    @Test
    public void should_return_true_when_testCheck() {
        assertTrue(this.brokenEngine.testCheck());
    }
}