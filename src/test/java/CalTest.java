import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalTest {
    @Test
    @DisplayName("Mockito 샘플")
    void getSum() {
        Cal cal = mock(Cal.class);
        when(cal.getSum(1, 2)).thenReturn(999);

        System.out.println(cal.getSum(1, 2));
    }
}
