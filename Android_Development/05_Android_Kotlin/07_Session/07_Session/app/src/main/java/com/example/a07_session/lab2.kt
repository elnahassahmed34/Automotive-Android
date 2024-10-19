package com.example.coroutineslab1

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()  = runBlocking {

    // FLOW
    // Create a flow that emits even numbers
    val evenFlow = flow {
        var count = 0
        while (count < 20) {
            emit(count * 2) // Emit even number
            delay(1000L) // Wait for 1 second
            count++
        }
    }

    // Collect the first 10 numbers from the flow
    evenFlow.take(10).collect { value ->
        println(value)
    }
}