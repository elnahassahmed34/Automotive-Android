package com.example.a06_session

//5. Create a job and try to use join() and cancelAndJoin()

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        repeat(5) {
            println("Job: Working $it")
            delay(500)
        }
    }

    job.join()
    println("Job completed!")

    val job2 = launch {
        repeat(5) {
            println("Job 2: Working $it")
            delay(1000)
        }
    }

    delay(2500)
    job2.cancelAndJoin()
    println("Job 2 was cancelled!")
}

