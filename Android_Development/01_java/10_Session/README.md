# procedural lang -> lamda

## Interface -> default
```java
interface InterfaceA{
    public void saySomthing();
    default public void sayHi(){
        System.out.println(){}
    }
}

public myckass implements InterfaceA{}
interface intf2 extends Intf1{}
```


## Java SE 8 new feature
- JDK 8 allow static methods in interface


## Lamda expression -> functional Interface
- Functional Interface are new additions in java 8 which permit excatly one abstract method inside them
- Single Abstract Method Onterfaces -> SAM Interfaces

```java

package functionalIntefaceexample

@FunctionalInterface //notation
public interface MyfirstfunctionInterface{
    public voud my interface();
}

```

## Functional Interfaces Examples
- BinaryOperator<T>
- Consumer<T>
- Function<T,R>
- Predicate<T>
- Supplier<T>
- UnaryOperator<T>

## Lambdas
- A lamda expression is a block of code that you can pass around so it can be excuted later , once or multiple times
- use it instead of anomyous local inner class
- implementation for single method
- paramters (->) body
- (n) -> n % 2


## Single lamda expressions example
- NumericTest LessThan = (n,m) -> (n<m) ;
- if(lessThan) ? print n : print m;


## Generic Function Interface
- SomeTest<String> isIn = (a,b) -> a.indexOf(b);


## Method refrence
- methods are class method(static) or instance method(members)
- refrence::Method name
- refrence static method , instance method , constructor
- 













