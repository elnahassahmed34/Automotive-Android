package com.example.a03_session


interface NumberSeries {
    var current: Int
    var start: Int

    fun getNext(): Int
    fun reset()
}

class ByThree(override var start: Int) : NumberSeries {
    override var current: Int = start

    override fun getNext(): Int {
        current += 3
        return current
    }

    override fun reset() {
        current = start
    }
}

fun main() {
    val series = ByThree(0)
    println(series.getNext())
    println(series.getNext())
    series.reset()
    println(series.getNext())
}
