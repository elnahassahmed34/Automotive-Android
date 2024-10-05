# Kotlin


## collection in kotlin 
- group that cibtains number of objects of same type
- Collection<T is the root of collection hierrchy>
- list set map
- description
- order imp unde , isn't
- indicies , element , keys
- double , unique , unique keys
- null one null , null key

- immutable -> readonly collection once it is created its data can't be changed
- interface that procides operations for accessing collection elemnts
- covariant
- list set map
- mutable -> mutable list map set

## Immutable List example
```kt
fun main(){

	var primelist : list 


}

```



## List specific operations
- find elemnt indexof first occurence ,

## sets
- merge two sets -> union
- find intersection between two collectiolns -> intersect

## map
- keys values , filter , put
- val filterKeysMap = number.filterkeys{it.endsWIth{1}}


## traversing it , for each loop
- iterators - objects
- val listIterator = numbers.listIterators()
- while (listIterator.hasPrevious()) 
- println(listIterator.previous)
- numbers.forEach{
	println(it)
}


- lab
- help the libraries to managae the items within library which includes books magazines and journals
- your task is to create a library system that enables :
1. view current books
2. search for book 


## lambda 
- shorter way of describing a function lambdas
- var generatedouble = {98.6}
- Var generateRandom = {}
-> Math.random()*100)

- paramters , returntype , calling
- if there is no paramter you can omit -> arrow
- if there is single paramter you can refer by it
- predicate ckass one 
- class Mypredicate : Predicat<Int>{
	override fun test(t : Int) : Boolean{
		return t % 2 
	}
}


## SAM single Abstract Method Interface
- kotlin into interface 
- val runnable = Runnable{println("nahass")}
- val listner = object : View.OnClickListner{
	
}


## Anonymous Functions
- used when you need to specify return type 
- name can be omitted
- val FunctionName = fun (params) : returnType {}
- var functionName = fun(params) = bodyfunction
- val add = fun (x:Int , y:Int) : Int{return x+y}
- val multiply = fun (x:Int , y:Int) = x*y
- fun main (){var result = add(10,20)}
- function type -> typealias

## Higher order function -> function
- pass function as paramter or return function
- fun getconversionlambda(type:string) : (Double) -> double{
	return when(type){
		"Celsiustoferhen" -> {it -> it * 20.5}
		""
	}
}


## Higher order function -> trailing lamda
- public repeat(tines : Int , action L Int -> Unit)
- repeat(8){println("trailing")}

## scoped function
- functions in the kotlin ST whose purpose is to excute block of code within the context of object
- let , also run apply with
- class Person(var name : string , var id : Int){
	println(name)
	println(id)
}

main(){
	var person2 : Person? = person(nahass , 199)
	person?,apply{
		name = "adam"
	}
	println("After edition ${personOne?.printName()}")
	
}



labs 
1. create a simple {erson which has a name id , gender the use scoped funtion try scoped 3 functions
2. use HOF to make 










































