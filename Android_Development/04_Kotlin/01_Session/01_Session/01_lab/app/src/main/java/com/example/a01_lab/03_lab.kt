package com.example.a01_lab

//3) Calculator: ADD, SUB, MUL, DIV

fun main(){

    println("please enter first num")

    val num1 = readLine()?.toDoubleOrNull() ?: 0.0

    println("please enter second num")

    val num2 = readLine()?.toDoubleOrNull() ?: 0.0

    println("please enter operation + - * /")

    val op = readLine()

    val result = when(op){
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> if(num2!= 0.0) num1 / num2 else "can't divide by zero"
        else  -> "Invalid operation"
    }

    println("result = $result")

}