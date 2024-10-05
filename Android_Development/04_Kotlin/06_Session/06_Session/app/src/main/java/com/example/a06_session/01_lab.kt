package com.example.a06_session
import kotlinx.coroutines.*

//suspend fun doHeavyFactorial(times: Int): Int {
//    var counter = 1
//    repeat(times) {
//        counter *= (it + 1)  // Calculate factorial by multiplying each number up to 'times'
//    }
//    return counter
//}
//
//fun main() = runBlocking {
//    val a = async {
//        doHeavyFactorial(5)  // Corrected function call
//    }
//
//    println("Factorial: ${a.await()}")
//}


suspend fun doHeavyWeightFactorial(num : Int):Int{

    var result : Int = 1

    repeat(num){

        delay(200)
        result *= (it+1)

    }

    return result

}

suspend fun myFunc(){
    delay(1000)
}

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("Working on task $i...")
                delay(500)
            }
        } catch (e: CancellationException) {
            println("Coroutine was cancelled.")
        }
    }

    // Let the coroutine run for 1100 milliseconds
    delay(1100)

    // Cancel the job and wait for its completion
    job.cancelAndJoin()

    println("Job cancelled and completed.")
}


//fun main()= runBlocking {
//    println("Running on: ${Thread.currentThread().name}")
//
//    withContext(Dispatchers.IO) {
//        println("Switched to IO thread: ${Thread.currentThread().name}")
//        delay(1000)
//    }
//
//    println("Back to: ${Thread.currentThread().name}")
//}
//= runBlocking {

//    runBlocking {
//        withContext(Dispatchers.Default){
//
//        }
//
//        withContext(Dispatchers.IO){
//
//        }
//    }

//    println("Before RunBlocking")
//    runBlocking {
//        val result = launch {
//            delay(500)
//            println("Launch")
//        }
//        result.join()
//        val result2 = async {
//            delay(100)
//            println("Async")
//        }
//    }
//    println("After RunBlocking")


//    val job = launch {
//        repeat(1000) {
//            println("$it")
//            delay(100) // Delay to simulate work
//        }
//    }
//    delay(1000)  // Let the job run for 1 second
//    job.cancel() // Cancel the job after 1 second
//    println("Cancelled") // Print that the job was cancelled
//
//

//    runBlocking {
//
//        var task = async {
//
//            doHeavyWeightFactorial(5)
//
//        }
//
//        println(task.await())
//
//    }

//    runBlocking {
//        launch {
//            delay(1000)  // Delay of 1 second
//            println("I am the first")
//        }
//        launch {
//            delay(2000)  // Delay of 2 seconds
//            println("I am the last")
//        }
//    }

