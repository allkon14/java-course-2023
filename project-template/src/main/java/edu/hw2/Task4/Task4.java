package edu.hw2.Task4;

public class Task4 {

    private Task4() {}

    public static CallingInfo callingInfo(Throwable throwable) {
        var trace = throwable.getStackTrace();

        String className = trace[0].getClassName();
        String methodName = trace[0].getMethodName();
        return new CallingInfo(className, methodName);
    }
}
