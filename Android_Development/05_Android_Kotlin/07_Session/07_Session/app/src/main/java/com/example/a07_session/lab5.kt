//package com.example.a07_session
//
///*
//* The difference between collect and collectLatest in Kotlin Flow is in how they handle emissions when new values are emitted quickly.
//
//1. collect:
//Processes every emitted value in order.
//It will finish processing one emitted value before moving to the next one, even if a new value is emitted during that time.
//kotlin
//flow {
//    emit(1)
//    delay(500)
//    emit(2)
//    delay(500)
//}.collect { value ->
//    delay(1000) // Simulating a long processing time
//    println("Collected: $value")
//}
//Output:
//
//Collected: 1
//Collected: 2
//In this case, both emitted values (1 and 2) are processed fully, even though there's a delay between them.
//
//2. collectLatest:
//Cancels the ongoing work for the previous emission if a new value is emitted before the previous one finishes processing.
//It starts processing the latest value and ignores the old one.
//kotlin
//Copy code
//flow {
//    emit(1)
//    delay(500)
//    emit(2)
//    delay(500)
//}.collectLatest { value ->
//    delay(1000) // Simulating a long processing time
//    println("Collected: $value")
//}
//Output:
//
//Collected: 2
//Here, the second value (2) cancels the work on the first value (1), so only the latest value is processed.
//
//Summary:
//collect: Waits for each value to be processed completely, even if new values arrive in the meantime.
//collectLatest: Cancels the ongoing work if a new value is emitted, ensuring only the latest value is processed.
//* */
//
