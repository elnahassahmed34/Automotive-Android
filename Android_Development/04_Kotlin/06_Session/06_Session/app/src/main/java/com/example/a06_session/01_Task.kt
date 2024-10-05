package com.example.a06_session

//1. Create a coroutine that outputs 1 to 10 using async and launch
//builders. Use the delay function.

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        repeat(10) {
            delay(500)
            println("Launch: ${it + 1}")
        }
    }

    val result = async {
        repeat(10) {
            delay(500)
            println("Async: ${it + 1}")
        }
    }

    result.await()
}


