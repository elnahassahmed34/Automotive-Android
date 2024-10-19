package com.example.a07_session

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// data source , observables
fun getData() = flow{
        println("Flow started")
        for(i in 1..10){
            kotlinx.coroutines.delay(1000)

            emit(i)
            println("Emitting $i")
        }
    }


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
//    getData()
//        .filter { it > 5 }
//        .flowOn(Dispatchers.IO)
//        .map { it * 5  } //intermediate
//        .flowOn(Dispatchers.Default)
//        .collect{ //terminal // observer - consumer
//            println(it)
//        }
