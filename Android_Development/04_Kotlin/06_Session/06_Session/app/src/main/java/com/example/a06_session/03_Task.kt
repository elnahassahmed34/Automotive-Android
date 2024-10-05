package com.example.a06_session

//3. Create 2 coroutines that perform parallel tasks and cancel both
//after 10 seconds. (Try to use exception handling)


import kotlinx.coroutines.*

fun main() = runBlocking {
    val job1 = launch {
        try {
            repeat(100) {
                delay(1000)
                println("Job 1: Working $it")
            }
        } catch (e: CancellationException) {
            println("Job 1 cancelled!")
        }
    }

    val job2 = launch {
        try {
            repeat(100) {
                delay(1000)
                println("Job 2: Working $it")
            }
        } catch (e: CancellationException) {
            println("Job 2 cancelled!")
        }
    }

    delay(10000)
    job1.cancelAndJoin()
    job2.cancelAndJoin()
    println("Both jobs are cancelled after 10 seconds.")
}
