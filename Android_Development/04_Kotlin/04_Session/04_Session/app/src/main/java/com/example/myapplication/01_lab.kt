class Complex(val real: Int = 0, val img: Int = 0) {

    constructor(real: Int) : this(real, 0)

    operator fun plus(other: Complex): Complex {
        return Complex(this.real + other.real, this.img + other.img)
    }

    operator fun minus(other: Complex): Complex {
        return Complex(this.real - other.real, this.img - other.img)
    }
}

fun Complex.print() {
    println("$real + ${img}i")
}

fun main() {

    val complex1 = Complex(real = 1, img = 2)
    val complex2 = Complex(real = 3 , img = 1)

    val sumResult = complex1 + complex2
    val subtractResult = complex1 - complex2

    println("Sum: ")
    sumResult.print()

    println("Difference: ")
    subtractResult.print()
}
