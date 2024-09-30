# OOP


## Any
- Any is the root of the kotlin class hierarchy 
- every class has any as a super class
- kotlin has varios classes as data , sealed , Enum . Abstarct
- kotlin has interfaces

## Classes
- t ocreate object we donot use new keyword
- classes in kotlin have primary constructor or more secondry ones
- in kotlin class members : Constructors , initializer block , functions , properties , nested and inner classes + object declration

## syntax
-access moodifier class Classname[constructor](attributiodec.){
	<attributedec , method , seccons initializblock>
}
```kotlin

public class parent(val prepory1LInt , var property2: String , variable:boolean){
	
	val prperty : Int = 0 
	fun sayHello(){println("hello")}
	init{println("Call to primary")}
	constructor(x:Int):this(x , propery2)

}

```



## Attrubutes + methids
- can be dec. in only two places
	- with class body or parenthesses of class constructor(must have val | var)
	
- syntax : access modifier val|var identifiername : DataType
- access-modifier fun name (paramter) : returntype
	
	
## Constructors
### - Primary Constructor
- class in kotlin can have one primary constructor 	
- primary constructor is a part of class header 
- class className constructor(params{body})
- primary constructor can't contain any code , Initialization code is places in initializer block
- you can use val | var before cariables to make them properties in the class
- it is allowed to have named and default paramters
- primary constructor paramters can be used in property initializer

## demo
```kt

```

## Initializer blocks
- body of constructor	
- multiple init. block


## Secondry Constructors
- constructor overloading
- each secondry constructor need to delegate to the primary constructor , if exists , either directly or indirectly through another secondary constructors
- delegation to another constructor of the same class is done using the this keyword
- Syntax
1. if there is a primary constructor 
	- constructor (required paramters) : this(primary params){}
2. if there is no primary constructor
	- constructor (required params){}
	

## modifiers -> class member or top level
- public yes yes
- protected yes no
- internal  yes yes
- private yes yes
- final yes classess only
- abstract methods-classes  classesonly
- const - values only
- inner classes only 
	
	
## oop concepts
### Encapsulation : data + behaviours in one class
	- public and private
	- properties in kotlin declared in primary constructor or body of class
	- default access modifier in kotlin is public
### -  setters and getters
```kt
var stringrep : String
	get() = this.tostring()
	set(value) = stringrep = cvalue

class Course{

	val id : Int = 2
		get(){
			// field indicates the stored value
			return field.plus(1)
		
		}
		
	
	var name: String? = null
		set(value){
			if(value.isNullOrEmpty){
				field = "default"
			}
			else{
				field = value
			}
		}


}

```

### Inheritance
- Inheritance extend functionality of class
- all inherit any
- they are final by default
- if the derived has its primary then base must be primary
- if the derived class has no promary , secondry : init base -> super or delegate to another constructor -> init base type
```kt
open class Base(p:Int){}

class Derived : Base(){

	//init base type using super keywork
	constructor(params : Int) : super(param){}
	
	//delegate to another const
	constructor(params:Int , param2:String):this(param1)

}

```


### Polymorphism
- overloading , overriding
- by default functions are final , need to open

### polymorphism -> overriding properties
- overriding mechasm works on properties same way
- each declared propett -> overriden by init pr p
- val property can be overriden with var property but not vise verse
```kt

open class Shape{
	open val verexCount: Int = 0
}

class Rectangle : Shape(){

	override val verexCount = 4

}
```
### Data Class
- it is equal to pojo
- data class is used to manipulate data -> bean Pojo DTO
- data class provides are consice to avoid as much boilerplate as possible
- conveniant way to
	- to string , hashcode equals copy

- rules
1. primary constructor paramters need to be marked
2. all primary constructor paramters need to be marked
3. data classes can't be abstract , open , sealed , inner


















let's change the herarchy of each class to those ones as following and uses differnt constructors 
class Shape

Shape
dim
set field
get field
abstract calcArea( ):Double

Rectangle
private height
Rectangle( W, H)
Rectangle( )
setHeight( )
getHeight( )
calcArea( ):Double

Circle
dim
Circle (R)
Circle( )
calcArea( ):Double

Triangle
private Height
Triangle(B , H)
Triangle( )
setHeight( )
getHeight( )
calcArea( ):Double





	






















