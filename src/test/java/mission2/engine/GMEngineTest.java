package mission2.engine;

import mission2.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GMEngineTest {
    private Car mockCar;
    private GMEngine gmEngine;

    @BeforeEach
    void setUp() {
        this.mockCar = mock(Car.class);
        this.gmEngine = new GMEngine(this.mockCar);
    }

    @DisplayName("이름이 GM인지 테스트")
    @Test
    public void should_return_GM_when_getName() {
        assertEquals("GM", this.gmEngine.getName());
    }

    @DisplayName("GM 엔진에는 사용 제한이 없다")
    @Test
    public void should_return_true_when_isValidCheck() {
        assertTrue(this.gmEngine.isValidCheck());
    }

    @DisplayName("GM 엔진에는 테스트 제한이 없다")
    @Test
    public void should_return_true_when_testCheck() {
        assertTrue(this.gmEngine.testCheck());
    }
}