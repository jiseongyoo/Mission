package mission2.car;

import mission2.brake.Brake;
import mission2.brake.ContinentalBrake;
import mission2.engine.BrokenEngine;
import mission2.engine.Engine;
import mission2.steer.Steer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SedanTest {
    private Engine mockEngine;
    private Brake mockBrake;
    private Steer mockSteer;
    private Sedan sedan;

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

        this.sedan = new Sedan();
        this.sedan.setEngine(this.mockEngine);
        this.sedan.setBrake(this.mockBrake);
        this.sedan.setSteer(this.mockSteer);
    }

    @DisplayName("Continental은 Sedan용 제동장치를 만들지 않는다")
    @Test
    public void should_print_malfunction_when_isValidCheck_with_ContinentalBrake() {
        this.sedan.setBrake(new ContinentalBrake(this.sedan));

        this.sedan.run();
    }
}