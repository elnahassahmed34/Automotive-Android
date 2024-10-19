## kotlin


## Asyncronous
- code was in main thread
- thread for heavy tasks -> callback hell 
- Callbacks -> , lack of exception handling , unreadable
- RX -> observers + observables -> listen + condition , complicated
- Coroutines -> Async


## Intro
- cooperative routine (function)
- concurrency design pattern that you can use on android 
- is an instance of suspedanle computation
- similar to thread
- is not bound to any particular thread
- it may suspend its excution in one thread


## Concurrency vs parllesim
- conc : is when two or mre tasks can start run complete time periods
- it doesn't mean at same instant , Interruptily
-  Prallesim -> run at same time
	- Independantly
	
	
	
## why
- light wirght + fast
- fewer memory leaks
- build in cancellation support
- jetpack integration
	- boiler plate work , donkey work are offered
	- room lifedata viewmodel coroutines constraint layout listadaptor
	- so it can integrate with each other
	


## Exception handling
- scope , global or custom scope
- dispatcher -> IO + main , uncombined , default
	- thread pool
	- coroutine context
- builders : launch async runblocking -> block main thread
- integral part of async prog.
- error occured with API , crach the program
- exception propagation
	- its rather straight forward in coroutines
	- if the code throughs an exception , env woll propagat
- kind of coroutinesbuilder you use dicate how exception will propagate and how you can handle them
- when using launch coroutine builder as soon as they happen and propagate
- exceprtion are treated uncout
- when async is used as root coroutin builder, exceptions are thrown only when call await

```kt
val launchJob = global scope
{
	.join
}


try {

	deferred.await()
}catch(e:Exception){
	print
}

- structure concerruncy -> parent and child in coroutines
- in global scope no structure concurrency


## coroutines exception hanler
- customize behaviour by creating custom coroutineExceptionHandler , which serves as catch block
- coroutine context , some char . that descrive
- coroutine Exception Handler catches only exception that weren't handled in other way : uncought exception
- is invoked only on exceptions which are n't excepeted to be handled , so registeration it in async coroutines builder
- global scope it us useful

```

val exceptionhandle = couritneexceoption{
}

val job = Globalscope.laing(){
	throw
}
val deffered = GLobal.async{
	trow
}
joinAll(job , deffered)
```


## multiple child coroutine exception
- parent has 4 chilren
1. cancel child , cancel parent , propgate 
- propgated up the job hierarchy 
- job cancellation exception

```
## supervising coroutines
- ifUI coroutine it will be cancelled
- what use supervisor job
- with supervisorjob failure of child doesn't affect other children
- wan;t cancel itself or the rest of its children
- supervisorjob won;t oriogate tge exception either , and will let the child coroutine handle it
- if many exceptions happens -> it will be put in spperssed box


## Kotlin flow
- flows is a type that can emit multiple values sequentially
- flow to recieve live updates from a database

- flows are designed  to handle the async stream of data
- flows support are cold sync build value streams
- flows are a feature of coroutines

## hot streams vs cold
- observable -> data source -> hot live , cold not sent except if needed
- observe -> who see data 


## kotlin flow's Entites
- Consumer = observer 
- Intermediate
- producer = observable


## kotlin flow , live data , rxjava
- all of them provide a way to implement the observer pattern 
- live data simple observale data holder 
	- it is best to store UI state 
	- such as list of items

-RXJava -> reactive strewa, . but it has a steep learning curve
- flow falls somewhere in between liveDaata and Rxjava
- flow API even looks a lot like rx java


## flow builders
- there are the following basic ways to create a flow
- flow{} -> function to  construct arbitart
- asFlow extension function
- flow of colde
- chanel flow + mutable

## intermediate flow operators
- flow many deiff operators
- map uses to transform each valie in flow
- filter filters values in flow , only when predicate returns true , 

## Intermediate flow operators
- transform 
- take size liimiting 
- zip flow operator that emits a single item after combingn emision
- merge : merges the given flows into
- buffer : flow emission
	- bufferning the data until it is recieved


## Terminal flow operators
- flows are cold , they won't produce values until remal is called
- susbending function
- famous one is collect

## diff between list and flowof
- list can't be observed , operation are made in one time
- but flow is made item by item

## switching the context
- flow context can change it

## flow constraints
- because flow is easy to use , there have to be 
- flow has a context perservation , it encasulate its own excution contex 
- the producing and consuming contexts have to be the same
- should work on same context



## Exxception Transperancy
- catch operator
- throw from data
- exception can be rethrown 
- exception can be turned into emission of values using emit from body of catch
- exceptions can be ignored , logged , or processed by some other code
- how to ignore exception




## down stream from collector
- upstream from APIs 



## state flow
- must have initial value , and observe
- actuall stateflow is introduce to tackle varios proplems in live data
- what excatly were issues with live data 
	1. fires even no updates
- repo , vm(LD) , view(observer)
2. must be in the main thread
3. not safe call , can hold null
- modern altenative , full support for coroutines
- given stateflow os a flow -> intermediate
- fires when new update 
- be in view model 
- has initial value
- state flow is not lifecycle aware
	- not aware of life cycle of activity 

## state flow
- val stateflow = mutableStateFlow<Int>(0)
- two ways to get at the state flow value
	- directly access
	- subscribing to collect
	
- stateFlows are safe tp collect using repeatOnLifeCycle() functions
- lifeCycleScope.launch{
	repeatOnLifeCycle(Life.State.Started){
		viewModel.someDataFlow.collect{}
	}
}


































































































































































```
















	
		

