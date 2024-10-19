package com.example.a07_session

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.ArithmeticException as ArithmeticException2
import java.lang.IllegalStateException as IllegalStateException3
import kotlin.ArithmeticException as ArithmeticException1
import kotlin.IllegalStateException as IllegalStateException1
import kotlin.IllegalStateException as IllegalStateException2
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.zip

class Example{}

fun main() {
    val list1 = flowOf(1,2,3,4,5)
    val list2 = flowOf(6,7,8,9,10)

    //println(list1.zip(other = list2))
    val x = merge(list1,list2)

}


    /*
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            println("Caught exception: ${exception.message}")
    }

    val parentJob = GlobalScope.launch(exceptionHandler) {

        //child1
        launch {
            try {

                delay(Long.MAX_VALUE)
                throw ArithmeticException1()
            }catch (e:Exception){
                println("Exception in child1")
            }
        }

        //child2
        launch{
            delay(Long.MAX_VALUE)
        }
        delay(Long.MAX_VALUE)
    }


// = runBlocking {
//    // Create a CoroutineExceptionHandler to handle uncaught exceptions
//    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
//        println("Caught exception: ${exception.message}")
//    }
//
//    // Launch a coroutine using GlobalScope and the exception handler
//    val job = GlobalScope.launch(exceptionHandler) {
//        println("1 Hello from Launch!")
//        throw IllegalStateException3("Exception in launch")
//    }
//
//    // Launch an async coroutine using GlobalScope and the exception handler
//    val deferred = GlobalScope.async(exceptionHandler) {
//        println("2 Hello from Async!")
//        throw ArithmeticException2("Exception in async")
//    }
//
//    // Join both the job and the deferred coroutine
//    joinAll(job, deferred)
//
//    println("Main block execution complete.")
}

//fun main() {

//    runBlocking {
//        // Launch coroutine
//        val launchJob = GlobalScope.launch {
//            println("1 Hello World")
//            // Properly instantiate and throw an IllegalStateException
//            throw IllegalStateException1("Launch coroutine threw an IllegalStateException")
//        }
//        // Wait for the launch job to complete
//        launchJob.join()
//
//        println("2 Hello World")
//
//        // Async coroutine
//        val deferredJob = GlobalScope.async {
//            println("3 Hello World")
//            // Properly instantiate and throw an ArithmeticException
//            throw ArithmeticException1("Async coroutine threw an ArithmeticException")
//        }
//
//        // Try-catch to handle the exception
//        try {
//            deferredJob.await() // Await the result or exception
//            println("4 Hello World")
//        } catch (e: IllegalStateException2) {
//
//            println("5 Caught IllegalStateException")
//        } catch (e: ArithmeticException1) {
//            println("6 Caught ArithmeticException: ${e.message}")
//        }
//
//        println("7 Hello World")
//    }
//}
*/