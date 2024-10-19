package com.example.a07_session

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Flow 
fun getNumbers() = flow<Int>{
    for (i in 1..10)
    {
        delay(1000)
        emit(i)
    }
}

// StateFlow 
fun getNumbersStateFlow(): MutableStateFlow<Int> {
    val stateFlow = MutableStateFlow(0) // Initial state
    CoroutineScope(Dispatchers.Default).launch {
        for (i in 1..10) {
            delay(1000)
            stateFlow.value = i // Update the StateFlow with each number
        }
    }
    return stateFlow
}
suspend fun main() : Unit = coroutineScope  {

    // Flow
//     getNumbers()
//         .filter { item -> item > 5 }
//         .map { item -> item * 2  }
//         .collect{
//             println("The number is: $it")
//         }

    // stateFlow
    val numberStateFlow = getNumbersStateFlow()

    numberStateFlow
        .filter { item -> item > 5 }  // Filter values greater than 5
        .map { item -> item * 2 }     // Multiply the value by 2
        .take(5)                      // Take first 5 valid values
        .collect {
            println("The number is: $it") // Collect and print the numbers
        }
}