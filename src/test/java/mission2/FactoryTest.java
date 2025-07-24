package mission2;

import mission2.brake.Brake;
import mission2.car.Car;
import mission2.engine.Engine;
import mission2.steer.Steer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FactoryTest {
    private Factory factory;

    @BeforeEach
    void setUp() {
        this.factory = new Factory();
    }

    @DisplayName("자동차 선택에 대한 메뉴를 보여준다")
    @Test
    public void should_print_carType_menu() {
        this.factory.setCurrentStep(Factory.CAR_TYPE);

        this.factory.showMenu();
    }

    @DisplayName("엔진 선택에 대한 메뉴를 보여준다")
    @Test
    public void should_print_engineType_menu() {
        this.factory.setCurrentStep(Factory.ENGINE);

        this.factory.showMenu();
    }

    @DisplayName("제동장치 선택에 대한 메뉴를 보여준다")
    @Test
    public void should_print_brakeType_menu() {
        this.factory.setCurrentStep(Factory.BRAKE_SYSTEM);

        this.factory.showMenu();
    }

    @DisplayName("조향장치 선택에 대한 메뉴를 보여준다")
    @Test
    public void should_print_steerType_menu() {
        this.factory.setCurrentStep(Factory.STEER_SYSTEM);

        this.factory.showMenu();
    }

    @DisplayName("운전/테스트 선택에 대한 메뉴를 보여준다")
    @Test
    public void should_print_run_test_menu() {
        this.factory.setCurrentStep(Factory.RUN_TEST);

        this.factory.showMenu();
    }

    @DisplayName("자동차 종류 선택 시 0을 입력하면 그대로 자동차 종류 선택을 한다")
    @Test
    public void should_return_equals_when_select_car_type_with_0(){
        this.factory.setCurrentStep(Factory.CAR_TYPE);

        this.factory.getUserInput(0);

        assertEquals(Factory.CAR_TYPE, this.factory.getCurrentStep());
    }

    @DisplayName("자동차 종류를 선택한다")
    @ParameterizedTest
    @CsvSource({"1,Sedan", "2,SUV", "3,Truck"})
    public void should_return_CarName_when_select_carType(int userInput, String carName) {
        this.factory.setCurrentStep(Factory.CAR_TYPE);

        this.factory.getUserInput(userInput);

        assertEquals(carName, this.factory.getCar().getName());
        assertEquals(Factory.ENGINE, this.factory.getCurrentStep());
    }

    @DisplayName("자동차 종류 선택 시 범위를 벗어나는 값을 입력하면 그대로 자동차 종류 선택을 한다")
    @ParameterizedTest
    @ValueSource(ints = {-99, -1, 4, 5, 99})
    public void should_return_equals_when_select_car_type_with_invalid_range(int userInput){
        this.factory.setCurrentStep(Factory.CAR_TYPE);

        this.factory.getUserInput(userInput);

        assertEquals(Factory.CAR_TYPE, this.factory.getCurrentStep());
    }

    @DisplayName("엔진 종류 선택 시 0을 입력하면 자동차 종류 선택을 한다")
    @Test
    public void should_return_equals_when_select_engine_type_with_0(){
        this.factory.setCurrentStep(Factory.ENGINE);

        this.factory.getUserInput(0);

        assertEquals(Factory.CAR_TYPE, this.factory.getCurrentStep());
    }

    @DisplayName("엔진 종류를 선택한다")
    @ParameterizedTest
    @CsvSource({"1,GM", "2,TOYOTA", "3,WIA", "4,BROKEN"})
    public void should_return_EngineName_when_select_engine(int userInput, String engineName) {
        this.factory.setCurrentStep(Factory.ENGINE);

        this.factory.getUserInput(userInput);

        assertEquals(engineName, this.factory.getCar().getEngine().getName());
        assertEquals(Factory.BRAKE_SYSTEM, this.factory.getCurrentStep());
    }

    @DisplayName("엔진 종류 선택 시 범위를 벗어나는 값을 입력하면 그대로 엔진 종류 선택을 한다")
    @ParameterizedTest
    @ValueSource(ints = {-99, -1, 5, 6, 99})
    public void should_return_equals_when_select_engine_type_with_invalid_range(int userInput){
        this.factory.setCurrentStep(Factory.ENGINE);

        this.factory.getUserInput(userInput);

        assertEquals(Factory.ENGINE, this.factory.getCurrentStep());
    }

    @DisplayName("제동장치 선택 시 0을 입력하면 엔진 종류 선택을 한다")
    @Test
    public void should_return_equals_when_select_brake_system_with_0(){
        this.factory.setCurrentStep(Factory.BRAKE_SYSTEM);

        this.factory.getUserInput(0);

        assertEquals(Factory.ENGINE, this.factory.getCurrentStep());
    }

    @DisplayName("제동장치 종류를 선택한다")
    @ParameterizedTest
    @CsvSource({"1,Mando", "2,Continental", "3,Bosch"})
    public void should_return_BrakeName_when_select_BrakeSystem(int userInput, String brakeType) {
        this.factory.setCurrentStep(Factory.BRAKE_SYSTEM);

        this.factory.getUserInput(userInput);

        assertEquals(brakeType, this.factory.getCar().getBrake().getName());
        assertEquals(Factory.STEER_SYSTEM, this.factory.getCurrentStep());
    }

    @DisplayName("제동장치 선택 시 범위를 벗어나는 값을 입력하면 그대로 제동장치 선택을 한다")
    @ParameterizedTest
    @ValueSource(ints = {-99, -1, 4, 5, 6, 99})
    public void should_return_equals_when_select_brake_system_with_invalid_range(int userInput){
        this.factory.setCurrentStep(Factory.BRAKE_SYSTEM);

        this.factory.getUserInput(userInput);

        assertEquals(Factory.BRAKE_SYSTEM, this.factory.getCurrentStep());
    }


    @DisplayName("조향장치 선택 시 0을 입력하면 제동장치 선택을 한다")
    @Test
    public void should_return_equals_when_select_steer_system_with_0(){
        this.factory.setCurrentStep(Factory.STEER_SYSTEM);

        this.factory.getUserInput(0);

        assertEquals(Factory.BRAKE_SYSTEM, this.factory.getCurrentStep());
    }

    @DisplayName("조향장치 종류를 선택한다")
    @ParameterizedTest
    @CsvSource({"1,Bosch", "2,Mobis"})
    public void should_return_BrakeName_when_select_steerSystem(int userInput, String steerType) {
        this.factory.setCurrentStep(Factory.STEER_SYSTEM);

        this.factory.getUserInput(userInput);

        assertEquals(steerType, this.factory.getCar().getSteer().getName());
        assertEquals(Factory.RUN_TEST, this.factory.getCurrentStep());
    }

    @DisplayName("조향장치 선택 시 범위를 벗어나는 값을 입력하면 그대로 조향장치 선택을 한다")
    @ParameterizedTest
    @ValueSource(ints = {-99, -1, 4, 5, 6, 99})
    public void should_return_equals_when_select_steer_system_with_invalid_range(int userInput){
        this.factory.setCurrentStep(Factory.STEER_SYSTEM);

        this.factory.getUserInput(userInput);

        assertEquals(Factory.STEER_SYSTEM, this.factory.getCurrentStep());
    }

    @DisplayName("RUN/TEST 선택 시 0을 입력하면 자동차 종류 선택을 한다")
    @Test
    public void should_return_equals_when_select_run_test_with_0(){
        this.factory.setCurrentStep(Factory.RUN_TEST);

        this.factory.getUserInput(0);

        assertEquals(Factory.CAR_TYPE, this.factory.getCurrentStep());
    }

    @DisplayName("RUN/TEST 선택 시 1을 입력하면 제작된 자동차를 Run 한다")
    @Test
    public void should_return_equals_when_select_run_test_with_1(){
        Car spyCar = spy(new Car());
        spyCar.setEngine(mock(Engine.class));
        spyCar.setSteer(mock(Steer.class));
        spyCar.setBrake(mock(Brake.class));
        this.factory.setCar(spyCar);
        this.factory.setCurrentStep(Factory.RUN_TEST);

        this.factory.getUserInput(1);

        verify(spyCar, times(1)).run();
        verify(spyCar, never()).test();
        assertEquals(Factory.RUN_TEST, this.factory.getCurrentStep());
    }

    @DisplayName("RUN/TEST 선택 시 2을 입력하면 제작된 자동차를 Test 한다")
    @Test
    public void should_return_equals_when_select_run_test_with_2(){
        Car spyCar = spy(new Car());
        spyCar.setEngine(mock(Engine.class));
        spyCar.setSteer(mock(Steer.class));
        spyCar.setBrake(mock(Brake.class));
        this.factory.setCar(spyCar);
        this.factory.setCurrentStep(Factory.RUN_TEST);

        this.factory.getUserInput(2);

        verify(spyCar, never()).run();
        verify(spyCar, times(1)).test();
        assertEquals(Factory.RUN_TEST, this.factory.getCurrentStep());
    }

    @DisplayName("RUN/TEST 선택 시 범위를 벗어나는 값을 입력하면 그대로 RUN/TEST 선택한다")
    @ParameterizedTest
    @ValueSource(ints = {-99, -1, 3, 4, 5, 99})
    public void should_return_equals_when_select_run_test_with_invalid_range(int userInput){
        Car spyCar = spy(new Car());
        spyCar.setEngine(mock(Engine.class));
        spyCar.setSteer(mock(Steer.class));
        spyCar.setBrake(mock(Brake.class));
        this.factory.setCar(spyCar);
        this.factory.setCurrentStep(Factory.RUN_TEST);

        this.factory.getUserInput(userInput);

        verify(spyCar, never()).run();
        verify(spyCar, never()).test();
        assertEquals(Factory.RUN_TEST, this.factory.getCurrentStep());
    }
}