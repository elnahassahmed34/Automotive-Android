package com.example.a05_session

typealias DoubleIntToInt = (Int, Int) -> Int

val sum: DoubleIntToInt = { no1, no2 -> no1 + no2 }
val sub: DoubleIntToInt = { num1, num2 -> num1 - num2 }
val mul: DoubleIntToInt = { num1, num2 -> num1 * num2 }
val div: DoubleIntToInt = { num1, num2 ->
    if (num2 != 0) {
        num1 / num2
    } else {
        println("Can't divide by zero")
        0
    }
}

fun calculate(num1: Int, num2: Int, operation: DoubleIntToInt): Int {
    return operation(num1, num2)
}

fun main() {

    println("Sum: ${calculate(5, 10, sum)}")

    println("Subtraction: ${calculate(10, 5, sub)}")
    println("Multiplication: ${calculate(5, 10, mul)}")
    println("Division: ${calculate(10, 5, div)}")

    println("Division by zero: ${calculate(10, 0, div)}")

}
