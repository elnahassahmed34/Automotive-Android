package com.example.a01_lab

fun main() {
    val str1 = "*"
    var str2 = "          *"
    var str = str1
    var strr = str2

    for (i in 0 until 5) {
        println(str + strr)
        str += str1
        strr = strr.substring(2) + " *"
    }
}

