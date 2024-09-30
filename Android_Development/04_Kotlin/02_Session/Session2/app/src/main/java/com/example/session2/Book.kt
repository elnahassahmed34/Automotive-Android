package com.example.session2

data class Book(var isbn : Int , var title:String , var auther:String , var publisher:String) {

}

fun main(){

    var book = Book(500 , "nahass" , "ahmed" , "mohamed")
    println(book)

}

