package com.example.myapplication.functions

class Employee {

    fun setEmployeeData(name: String = "Dudu", age: Int = 20, salary: Long = 500) {
        println("3 para")
        println("name:$name\nage:$age\nsalary:$salary")

    }

    fun myFun() = print("hello")

    fun setEmployeeData(name: String , age: Int ) {

        println("2 para")
        println("name:$name\nage:$age\n")

    }

}


fun String.chEven() : Boolean{
    return if(this.length % 2 == 0)
        true
    else
        false
}



fun main(){

    var name = "nahass"
    println(name.chEven())

//    var emp1 = Employee()
//
//    emp1.setEmployeeData("Nahass" , 27 , 2000)
//    emp1.setEmployeeData(name = "Mohamed" , age = 62)
//    emp1.setEmployeeData()


}