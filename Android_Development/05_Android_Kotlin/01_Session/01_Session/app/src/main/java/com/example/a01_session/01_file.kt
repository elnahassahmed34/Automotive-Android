package com.example.a01_session

class A{


}


class B(val a:A){}

val myLazyVariable : B by lazy{

    println("first Line")
    val a = A()
    B(a)

}


fun main(){
    var x = 10
    if(x<10){
        val v = myLazyVariable.a
    }
    else{
        println("Value is n't less than 10")
    }
}



