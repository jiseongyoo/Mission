package mission2.steer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SteerTest {
    @DisplayName("조향장치 선택하는 메뉴를 보여준다")
    @Test
    public void should_show_menu() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Steer.showMenu();

        assertTrue(outputStreamCaptor.toString().contains("어떤 조향장치를 선택할까요?"));
        System.setOut(System.out);
    }
}