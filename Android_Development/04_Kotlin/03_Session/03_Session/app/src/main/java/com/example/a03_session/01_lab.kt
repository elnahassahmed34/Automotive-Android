//package com.example.a03_session
//
//enum class MealSize{
//    Large,
//    Medium ,
//    Small
//}
//
////fun main(){
////
//////    var myPair = myFunction("Nahass" , 39)
//////    println(myPair.first)
//////    println(myPair.second)
////
//////    var size = MealSize.Large
//////    println("name = ${size.name}")
//////    println("Ordinal = ${size.ordinal}")
//////    println("valueOf large = ${MealSize.valueOf("Large")}")
////
////    var myObj = Myclass.getInstance()
////
////}
//
//// Function that throws an exception if i is less than or equal to 0
//fun mayThrowException(i: Int) {
//    if (i > 0) {
//        println("Success! i = $i")
//    } else {
//        throw Exception("i is less than or equal to 0")
//    }
//}
//
//fun main() {
//    // Using runCatching to handle the exception
//    runCatching {
//        mayThrowException(-1)  // Will throw an exception
//    }.onFailure {
//        // This block is executed if an exception is thrown
//        println("Failed: ${it.message}")
//    }.onSuccess {
//        // This block is executed if no exception occurs
//        println("Success!")
//    }
//
//    println("I am below")  // This will always print, even if there's a failure
//}
//
//
//interface Interface1{
//    fun method1(){
//        println("interface1")
//    }
//}
//interface Interface2{
//    fun method2(){
//        println("interface1")
//    }
//}
//
//class ExternalSuccessResponse : Interface1 , Interface2{
//
//}
//
//
//class Myclass{
//
//    companion object Factory{
//
//        fun getInstance() : Myclass{
//
//            return Myclass()
//        }
//
//    }
//
//}
//
////
////object MySingleton{
////
////}
//
//
//
//
//
//fun myFunction (name:String , age:Int) : Pair<Int , String>{
//
//    return Pair(age , name)
//}
