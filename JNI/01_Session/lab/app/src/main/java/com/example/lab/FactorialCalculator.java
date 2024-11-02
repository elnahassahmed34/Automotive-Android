// FactorialCalculator.java
package com.example.lab;

public class FactorialCalculator {

    // Load the native library
    static {
        System.loadLibrary("native-lib");
    }

    // Native method declaration
    public native int factorial(int n);

    // Java method to call the native factorial method
    public static int calculateFactorial(int number) {
        return new FactorialCalculator().factorial(number);
    }

    public void logResult(int result) {
        MainActivity.logToConsole(result);
    }
}
