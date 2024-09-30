package com.example.a01_lab

/*
* 1) Use the readline() to read inputs from the user.
* User should input their name,
* if user enters empty string, store a default value.
* Use an if expression to define greeting message based on whether the user entered a name
* */

fun main() {

    print("Enter your first name: ")
    val firstName = readLine() ?: ""

    print("Enter your last name: ")
    val lastName = readLine() ?: ""

    println("Full name: $firstName $lastName")
}
