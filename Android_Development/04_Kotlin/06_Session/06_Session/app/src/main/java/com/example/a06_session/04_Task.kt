package com.example.a06_session

import kotlinx.coroutines.*

// 4.Create a suspend function that takes an array as an input and outputs the summation of its elements.
suspend

fun sumArray(arr: IntArray): Int {
    return arr.sum()
}

fun main() = runBlocking {
    val array = intArrayOf(1, 2, 3, 4, 5)

    val sum = async {
        sumArray(array)
    }

    println("Sum of array elements: ${sum.await()}")
}
