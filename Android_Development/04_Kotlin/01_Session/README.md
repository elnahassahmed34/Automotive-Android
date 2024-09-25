# Kotlin

- JVM language
    - Kotlin produces java compatible bytecode

- Nullsafety
    - compiler tries to make sure no null will produce NULLptrException

- OOP language

- supoorts functional programming paradigm
    - make use of lambdas , HOF , 

- Coroutines
    - used for concurrency


## Helloworld

```kotlin
fun main(){
    println("Hello World!")
}
```

## Variables
- Have two catagories
- mutable or Immutable
- var or val

## Basic Data types
- Kotlin Basic types
- boolean char string array
- number : Byte , Int , Short Long Float Double

## EXamples
```
val daysOfYear : Int = 365
val PI : Double = 3.14
var isRegistered : Boolean = true
```
## there are two types hard or soft keywords

## Naming conventions

## Type inference
- ability of compiler to determine types from context 
- so , instead of defining variables including type
    - var myVariable : Int = 15
    - var myVariable = 15

## Conditions
- val max = if (a>b) a else b
- when : define conditianal expressions with multiple branches
- you can use arbitary expressions in cases (not only constants)
- for (x in 0..5){println("now x is : " + x)}
- for (i in 'a' .. 'z' step 2)
- for (i in 0 downTo -100 step 5)
- for (i in 0 until 30 step 3)
- repeat (times : 20){

}


## Arrays 
- collection of data
- each array element can hold a single item
- kotlin arrays have fixed size
- like other programming language
- declare an array we can have one of the following
- only length is known 
- basic type arrays
- arrayName
- val arr = arrayofNulls<string>(size)
- arr.set(0 , "welcome")
- val charArray : CharArray = charArrayOf('a' , 'b' , 'c')
- val intArray : IntArray = intArrayOf('a' , 'b' , 'c')


## Strings
- sequence of chars in double quotes
- indexing
- immutable

### string pool

### string manipulation

### notice
- val name = readline()


### Null Safety
- val name1 : String  = null    (X)
- val name2 : String?  = null  


## labs
- use readline
- create array of itegers , go through collection and print values less than or equal 0 to 10
- calculate add , sub , mul , div
- write program to print the patterns
- revieve first name and last name and print full name

