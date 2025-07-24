package mission2.car;

import mission2.brake.Brake;
import mission2.brake.MandoBrake;
import mission2.engine.Engine;
import mission2.engine.WiaEngine;
import mission2.steer.Steer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TruckTest {
    private Engine mockEngine;
    private Brake mockBrake;
    private Steer mockSteer;
    private Truck truck;

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

        this.truck = new Truck();
        this.truck.setEngine(this.mockEngine);
        this.truck.setBrake(this.mockBrake);
        this.truck.setSteer(this.mockSteer);
    }

    @DisplayName("WIA는 Truck용 엔진을 만들지 않는다")
    @Test
    public void should_print_malfunction_when_isValidCheck_with_WiaEngine() {
        this.truck.setEngine(new WiaEngine(this.truck));

        this.truck.run();
    }

    @DisplayName("Mando는 Truck용 제동장치를 만들지 않는다")
    @Test
    public void should_print_malfunction_when_isValidCheck_with_MandoBrake() {
        this.truck.setBrake(new MandoBrake(this.truck));

        this.truck.run();
    }
}