package mission2.car;

import mission2.brake.Brake;
import mission2.engine.BrokenEngine;
import mission2.engine.Engine;
import mission2.steer.Steer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {
    private Engine mockEngine;
    private Brake mockBrake;
    private Steer mockSteer;
    private Car car;

    @BeforeEach
    void setUp() {
        this.mockEngine = mock(Engine.class);
        this.mockBrake = mock(Brake.class);
        this.mockSteer = mock(Steer.class);

        when(this.mockEngine.isValidCheck()).thenReturn(true);
        when(this.mockBrake.isValidCheck()).thenReturn(true);
        when(this.mockSteer.isValidCheck()).thenReturn(true);

        when(this.mockEngine.testCheck()).thenReturn(true);
        when(this.mockBrake.testCheck()).thenReturn(true);
        when(this.mockSteer.testCheck()).thenReturn(true);

        this.car = new Car();
        this.car.setEngine(this.mockEngine);
        this.car.setBrake(this.mockBrake);
        this.car.setSteer(this.mockSteer);
    }

    @DisplayName("Car의 기본 이름은 빈 문자열")
    @Test
    public void should_return_empty_string_when_getName() {
        assertTrue(this.car.getName().isEmpty());
    }

    @DisplayName("엔진을 Set/Get을 정확히 하는지 테스트")
    @Test
    public void should_return_equals_when_set_get_Engine() {
        Engine mockEngine = mock(Engine.class);

        this.car.setEngine(mockEngine);

        assertEquals(mockEngine, this.car.getEngine());
    }

    @DisplayName("제동장치을 Set/Get을 정확히 하는지 테스트")
    @Test
    public void should_return_equals_when_set_get_Brake() {
        Brake mockBrake = mock(Brake.class);

        this.car.setBrake(mockBrake);

        assertEquals(mockBrake, this.car.getBrake());
    }

    @DisplayName("조향장치를 Set/Get을 정확히 하는지 테스트")
    @Test
    public void should_return_equals_when_set_get_Steer() {
        Steer mockSteer = mock(Steer.class);

        this.car.setSteer(mockSteer);

        assertEquals(mockSteer, this.car.getSteer());
    }

    @DisplayName("모든 부품이 정상 동작한다")
    @Test
    public void should_print_normal_when_run_with_all_good() {
        this.car.run();
    }

    @DisplayName("Engine이 고장난 경우 동작하지 않는다")
    @Test
    public void should_print_malfunction_when_run_with_BrokenEngine() {
        this.car.setEngine(new BrokenEngine(this.car));

        this.car.run();
    }

    @DisplayName("모든 부품이 정상적으로 테스트 된다")
    @Test
    public void should_print_normal_when_test_with_all_good() {
        this.car.test();
    }

    @DisplayName("Engine 테스트가 실패한 경우")
    @Test
    public void should_print_malfunction_when_test_with_EngineFalse() {
        when(this.mockEngine.testCheck()).thenReturn(false);

        this.car.test();
    }
}