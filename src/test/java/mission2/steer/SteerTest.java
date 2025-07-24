package mission2.steer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SteerTest {
    @DisplayName("조향장치 선택하는 메뉴를 보여준다")
    @Test
    public void should_show_menu() {
        Steer.showMenu();
    }
}