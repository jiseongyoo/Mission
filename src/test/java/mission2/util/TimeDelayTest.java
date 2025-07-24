package mission2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class TimeDelayTest {
    @DisplayName("입력된 시간동한 Thread를 쉬는지 테스트")
    @Test
    @Timeout(value = 110, unit = TimeUnit.MILLISECONDS)
    public void should_delay_for_a_while() {
        TimeDelay.delay(100);
    }
}