package mission2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

class AssembleTest {
    private Assemble assemble;
    private Factory spyFactory;

    @BeforeEach
    void setUp() {
        this.spyFactory = spy(new Factory());
        this.assemble = new Assemble();
        this.assemble.setFactory(this.spyFactory);
    }

    @DisplayName("Assemble 클래스에 main 메서드가 Exception 없이 실행되는지 테스트")
    @Test
    public void should_main_run_assemble_without_exception() {
        System.setIn(new ByteArrayInputStream("exit".getBytes()));

        Assemble.main(null);
    }

    @DisplayName("exit을 입력하면 Factory를 사용하지 않고 끝나는지 테스트")
    @Test
    public void should_not_invoke_facotry_getUserInput_with_exit() {
        System.setIn(new ByteArrayInputStream("exit".getBytes()));

        this.assemble.run();

        verify(spyFactory, never()).getUserInput(anyInt());
    }

    @DisplayName("숫자가 아닌 값을 입력하면 Factory를 사용하지 않고 끝나는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"xcivj\nexit", "v913i\nexit", "csswi1\nexit"})
    public void should_not_invoke_factory_getUserInput_with_wrong_input(String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        this.assemble.run();

        verify(spyFactory, never()).getUserInput(anyInt());
    }

    @DisplayName("정상적인 값을 입력하면 Factory를 사용는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2\nexit", "1\nexit", "0\nexit"})
    public void should_not_invoke_factory_getUserInput_with_valid_input(String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        this.assemble.run();

        verify(spyFactory, times(1)).getUserInput(anyInt());
    }

    @DisplayName("허용 범위를 벗어난 값을 입력하면 Factory를 사용하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"22\nexit", "412\nexit", "-32\nexit"})
    public void should_not_invoke_factory_getUserInput_with_invalid_input(String userInput) {
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        this.assemble.run();

        verify(spyFactory, times(1)).getUserInput(anyInt());
    }
}