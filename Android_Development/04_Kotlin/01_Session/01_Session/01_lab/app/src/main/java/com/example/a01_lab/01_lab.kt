package com.example.a01_lab

/*
* 1) Use the readline() to read inputs from the user.
* User should input their name,
* if user enters empty string, store a default value.
* Use an if expression to define greeting message based on whether the user entered a name
* */

fun main(){

    println("please enter your name")

    val userName = readLine() ?: ""

    val name = if (userName.isBlank()) "Guest" else userName

    val greetingMessage = if(userName.isBlank()){
        "Hello $name (default name used)"
    }
    else{
        "hello $name"
    }

    println(greetingMessage)

}
