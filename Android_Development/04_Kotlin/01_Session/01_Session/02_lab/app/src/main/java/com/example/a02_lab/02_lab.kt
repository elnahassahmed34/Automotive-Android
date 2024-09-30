package com.example.a02_lab

/*
* 2) create an Array of integer.
* Use java.util.Random to fill the Array with 100 random
number between 1 and 100.
* Go through collection and print values less than or equal
to 10*/

import java.util.Random

fun main(){

    val numbers = IntArray(100)

    val random = Random()

    for(i in numbers.indices){
        numbers[i] = random.nextInt(100)
    }

    for(number in numbers){
        if(number <= 10){
            println(number)
        }
    }

}