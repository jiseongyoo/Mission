package mission2.util;

public class TimeDelay {
    public static void delay(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException ignored) {}
    }
}
