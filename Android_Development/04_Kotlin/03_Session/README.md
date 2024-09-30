# Kotlin programming

## pairs and triples
- Data classes can stroe two or three vars , 
- properties : first , second third
- methods toList , toString
- syntax : val name pair|Triple<First , secodn , third datatype> = Pair|triple

## Enum Class 
- ordinal : propertystore ordinal value
- name , values , valueOf

## Sealed Class
- Sealed class represents restricted class hierarchies that provide more control over inhertance
```kt

sealed class FailResponse():Response()
sealed class successResponse():Response()


```
- constructor are private
- class implicitly abstract
- all subclasses must be defined within the same kotlin file in any scope
- it can't be local nor anonmous object

## Singlton
- constructor private
- public static method
- refrence static
- check if it null or not 
- there is no satic in kotlin
- object MySingltonCLass{}
- object doesn't have a constructor -> they are created auto. as soon as it is accessed
- can be derived from other classes


## Companion Objects
- if you need to write function that can be called
- used as static objects in the class or factory for class
class Myclass{
	
	companion object Factory{
	
		fun create() : Myclass = MyClass() } }
	
	
	}

	
}


## Interface 
- contract between classes
- define common behaviour 
```
interface Time{

	//body
}
```
- one class can implement multiple interface
- class extend 1 class but implements more than 1 interface

## Nested and Inner Classes
- classes can be nested in other classes , you can also use interfaces with nesting , all combinations of classes and interfaces are possible , you cn nest interfaces in classes in iterfaces and interfaces in interacess
```kt
class outer{
	private
}
```
- inner -> normal class
- nested classes are static member inner class


## Anomyous
fun main(){

	var thread = Thread(object : Runnable{
		override fun run(){
			println("Hello from runnable")
		}
	})
	
	thread.start()
}


## Exceptions
- in java
- error happens in runtime
- due to unexpected behaviour
- exception thrown in runtime
- checked -> not developer
	- stop compilation 
- unchecked -> developer fault
	- fault to be handled


- in kotlin
- all excetion ckasses are descendants of class throwable
- although kotlin inherits the concept but no checked
- throw is an expresin in kotlin , it can be used to assign values
- the value returned from it belongs to the data type NOthing
- a famous example for a funtion that returns nothing is TODO

### runCatching
- runCatching{}.onsucces , onfailure
- fun mayThrowException(i : Int){
if(i>0)else throw EXception()}
- main runCatching{
	mayThrowEXception(-1)
}.onFailure{println("failed")}
}.onSuccess{print succeses}
print("Iam below")


## lab -> make it simple and less lines of code line
- class Person{ 
	
	name
	address
	
	class Address{
		
		streetName
		city
		building
	}

}


enum building{

	villa
	apartment


}

main{

	Person

}


- lab2
- implement
























