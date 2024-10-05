package com.example.a06_session

//2. Create a suspend function that returns a factorial of a given number
//using the async builder

import kotlinx.coroutines.*

suspend fun doHeavyFactorial(times: Int): Int {
    var counter = 1
    repeat(times) {
        counter *= (it + 1)
    }
    return counter
}

fun main() = runBlocking {
    val a = async {
        doHeavyFactorial(5)
    }

    println("Factorial: ${a.await()}")
}
