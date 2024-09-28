package com.example.session2

open class Person(id : Int) {

    // init block is commented out as requested
    // init {
    //     println("primary")
    // }

    // init {
    //     println("init 2")
    // }

//    fun setSalary(s: Int) {
//        if (s >= 100_000) {
//            salary = s
//        } else {
//            salary = 22_000  // Corrected value to a valid salary format (22,000)
//        }
//    }

    var name: String = ""
        get() {
            return field + " nahass"
        }
        set(v) {
            field = v
        }

    // The `print` function is commented out as requested
    open fun print(){
         println("name: $name")
     }

    // The secondary constructor commented out as requested
    // constructor() : this("anonymous", 18, 1){
    //     println("secondary no args cons.")
    // }

    // The secondary constructor commented out as requested
    // constructor(salary:Int) : this(){
    // }

//    constructor(): this("nahass"){
//        println("anomyous")
//    }


}

class Child : Person {

    constructor():super(4)

    constructor(i:Int):this()

    override fun print(){
        println("name: $name")
    }

}


fun main() {
    // The commented-out person1 instance
    // val person1 = Person("Ahmed", 26, 1024)
    // person1.print()

    // Modified salary value in the constructor to match expected input
    val person2 = Person(100_000)
    person2.name = "ahmed"
    println(person2.name)
}
