package mission2.brake;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BrakeTest {
    @DisplayName("제동장치 선택하는 메뉴를 보여준다")
    @Test
    public void should_show_menu_contain_specific_words() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Brake.showMenu();

        assertTrue(outputStreamCaptor.toString().contains("어떤 제동장치를 선택할까요?"));
        System.setOut(System.out);
    }
}