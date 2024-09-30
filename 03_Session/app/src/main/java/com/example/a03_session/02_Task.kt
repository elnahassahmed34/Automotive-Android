package com.example.a03_session


interface NumberSeries {
    var current: Int
    var start: Int

    fun getNext(): Int
    fun reset()
}

class ByTwo(override var start: Int) : NumberSeries {
    override var current: Int = start

    override fun getNext(): Int {
        current += 2
        return current
    }

    override fun reset() {
        current = start
    }
}

fun main() {
    val series = ByTwo(0)
    println(series.getNext()) // 2
    println(series.getNext()) // 4
    series.reset()
    println(series.getNext()) // 2
}
