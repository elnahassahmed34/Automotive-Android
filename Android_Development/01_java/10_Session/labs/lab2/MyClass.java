interface NumericTest { // Fixed "Interface" to "interface"
    boolean test(int n, int m); // Added the method declaration
}

public class MyClass {
    public static void main(String[] args) {
        NumericTest isSmaller;

        // Lambda expression implementation of NumericTest
        isSmaller = (n, m) -> (n < m);

        

        // Corrected method call to use the lambda
        System.out.println(isSmaller.test(2, 4)); // Output will be true
    }
}
