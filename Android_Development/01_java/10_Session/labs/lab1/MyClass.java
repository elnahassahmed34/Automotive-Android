package lab1;
interface MyValue {
    double getValue();
}

public class MyClass { // Fixed "Class" to "class" and added constructor braces.
    public static void main(String[] args) {
        MyValue myVal; // Fixed naming convention (MyVal to myVal).

        // Anonymous class implementation of MyValue
        myVal = new MyValue() {
            @Override
            public double getValue() { // Added @Override annotation for clarity.
                return 0.1;
            }
        };

        // myVal = () -> 0.1 ;
        // myVal = (n) -> 1/n;
        
        double result = myVal.getValue();
        System.out.println(result); // Print the result to verify the output.
    }
}
