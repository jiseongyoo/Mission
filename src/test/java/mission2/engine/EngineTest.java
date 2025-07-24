package mission2.engine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {
    @DisplayName("엔진 선택하는 메뉴를 보여준다")
    @Test
    public void should_show_menu() {
        Engine.showMenu();
    }
}