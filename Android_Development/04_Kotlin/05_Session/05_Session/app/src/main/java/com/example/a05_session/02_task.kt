package com.example.a05_session

class Person(var name: String, var id: Int, var gender: String) {
    fun printDetails() {
        println("Name: $name, ID: $id, Gender: $gender")
    }
}

fun main() {

    val person1 = Person("AHmed", 1, "male").let {

        it.name = "Nahass"
        it
    }

    val person2 = Person("Nahass", 2, "Male").run {
        this.id = 6
        this
    }

    val person3 = Person("Nahass", 3, "male").also {
        it.printDetails()
        it.id = 4
        it.name = "Ahmed"
    }

    person1.printDetails()
    person2.printDetails()
    person3.printDetails()
}