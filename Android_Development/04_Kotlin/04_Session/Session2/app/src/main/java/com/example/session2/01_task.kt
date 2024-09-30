abstract class Shape {
     protected var dim: Double = 0.0
        get(){
            return field
        }
        set(value){
            field = value
        }

    constructor()

    constructor(dim: Double) {
        this.dim = dim
    }


    abstract fun calcArea(): Double
}

class Rectangle : Shape {
    private var height: Double = 0.0

    constructor(width: Double, height: Double) : super(width) {
        this.height = height
    }

    constructor() : super()

    fun setHeight(height: Double) {
        this.height = height
    }

    fun getHeight(): Double {
        return height
    }

    override fun calcArea(): Double {
        return dim * height
    }
}

class Circle : Shape {


    constructor(radius: Double) : super(radius)

    constructor() : super(0.0)

    override fun calcArea(): Double {
        return Math.PI * dim * dim
    }
}

class Triangle : Shape {
    private var height: Double = 0.0


    constructor(b: Double) : super(b)

    constructor(base: Double, height: Double) : this(base) {
        this.height = height
    }

    fun setHeight(height: Double) {
        this.height = height
    }

    fun getHeight(): Double {
        return height
    }

    override fun calcArea(): Double {
        return 0.5 * dim * height
    }
}

class Picture {

    fun sumAreas(shape1: Shape, shape2: Shape, shape3: Shape): Double {
        return shape1.calcArea() + shape2.calcArea() + shape3.calcArea()
    }
}

fun main() {

    val rectangle : Shape = Rectangle(4.0, 5.0)
    val circle = Circle(3.0)
    val triangle = Triangle(6.0, 8.0)

    val picture = Picture()
    val totalArea = picture.sumAreas(rectangle, circle, triangle)

    println("The total area of the three shapes is: $totalArea")
}
