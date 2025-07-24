package mission2.engine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {
    @DisplayName("엔진 선택하는 메뉴를 보여준다")
    @Test
    public void should_show_menu() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Engine.showMenu();

        assertTrue(outputStreamCaptor.toString().contains("어떤 엔진을 탑재할까요?"));
        System.setOut(System.out);
    }
}