# Kotlin

## Function
- fub sayHello(username: String) : Unit{
	println("Hello , ${username}")
}

### named paramters
- fun foo(myStr : string){}
- foo(myStr = "this is my string")
- default paramters

### Single Expression Function
- fun double(x:Int) : Int = x*2
- fun double(x:Int) = x*2
- kotlin is a type inferred language , kotlin doesn't infer return types


### EXtension functions
- extension ability to extend a class with new functionality
- creating extension modfy the class
- dec . scope
```kt
fun String.checkEven() : Booleran {
	return when{
		
		this.length % 2 == 0 -> true
		else -> false
	
	}
}
```
- this is the reciever class
```
open class Shape
class Rectanngle : Shape()

fun Shape.getName() = "Shape"
fun Rectangle.getName() = "Rectangle"

fun printVlassName(s:Shape){
	s.getname()
}

fun main(){

	println(Rectangle())
}


## Infix Functions
- called with infix notation
- infix fun Int.shl (x : Int) : Int{}
- 1 shl 2 , 1.shl(2)


## operator overloading
- can be with member function or extension function
```kt

infix operator fun Complex.plus(complex : Complex):Complex{

	return Compex(this.real + complex.real , this.img + complex.img)

}



operator fun Complex.minus(complex : Complex):Complex{

	
	return Complex(this.real - complex)

}


fun main(){

	val Complex1 = complex(1 , 2)
	val Complex2 = complex(1 , 2)
	
	val complex3 = c1 + c2
	


}

```

## Casting
- void demo(object x){
	if(x instanceof string){
		String.lenth
		x.length
	}
}


- fun demo(x:Any){
	
	if(x is String){
		print(x.length)
	}
	
}



## lab
- Complex class
- primary and secondry constructor
- opeartor overloading
- print function as extension function
- Try to use named parameters ,and default parameters when working with function/
 	
	
	




















```





