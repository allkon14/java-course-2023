package edu.hw2;
import edu.hw2.Task4.CallingInfo;
import edu.hw2.Task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import edu.hw2.Task4;

public class TestForTask4 {
    @Test
    public void testCallingInfo() {
        CallingInfo callingInfo = Task4.callingInfo(new Throwable());

        String className = callingInfo.className();
        String methodName = callingInfo.methodName();

        assertEquals("edu.hw2.TestForTask4", className);
        assertEquals("testCallingInfo", methodName);

    }
}
