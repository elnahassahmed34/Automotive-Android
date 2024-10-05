# Kotlin

## Asynchrounous Programming 

- we want to avoid having the user wait
- threads , coroutines , others

## Threads
-class MyThread : THread(){
	pubkuc override fun run{}
}
- val anotherThread = Thread {println*(}
- fun main {thread(start = true){println()}}

## example
- for(i in 1..1_5000_00){
	thread(start=true{result++})
}
- cpu 100%
- threads not chead + infinite

## Coroutines
- Kotlin's light weight thrad
- suspendable computation
- non blocking code -> lengthy
- programming model and Apis remain the same
- platform independant -> compiler takes the care of adapting it to each platform
- runBlocking{
	for(i in 1.._1_500_00){
		launch{result++}
	}
}
- 


- Coroutines Main Element
- job : model a cancalble workflow with multiple states : file download
- dispatcher: define thread pools tp launch corouthins -> switch main and threads
- dispatcher.default -> cpu intenisve work -> complex xalc and similar
- dispatcher.IO -> networking or reading and writing files
- dispatchers.main -> reccomended dispatcher for performing UI- related thread
- dispatcher.unConfidend : not assigned to any specific thread
- newSingleThreadContext : allow user to define its own process. one has to manually close it after using it
- when there is no despatcher provided -> will dispatched on the same process of calling function

## Coroutine scope
- keep tracj of coroutines by define thier lifecycle , being able to cancel them and be notified if any failure
- types :
- Global scope : app lifetime , auto stop
- lifecucleScope : used in android for a life of parent object like activity
- viewmodelscope : used with android too
- custom coroutinescope L you can create your own coroutinesscope

## Coroutines builders
- Coroutines builders -> create coroutine , take suspending lambda as an argument
- launch -> fire and forget -> refrence the current job
- async : created when we want to get or expext a value
- runblocking -> runs a new coroutine and blocks the current thread interrupitly until its completion. (used less for special purposses)

## launch
```kt
val job1 = GlobalScope.launch{
	repeat(10){
		delay(100)
		println("nahass")
	}
}

val job2 = CoroutineScope(Dispatchers.Default).launch{
	delay(200)
	println("ahmed")
}

```
## async 
- created when we want to get or expect value
```kt

suspend fun doHeavyFactorial(timeLInt = 5) : Int{
	var counter = 1
	repeat(times)
}
return counter
}

fun main() = runBlocking{

	val a = async{
	
		doheavyfactorial(5)
	}
	
	println(a.await())
	
}


```

## runBlocking
```kt

fun main(){
	
	runblocking{
		launch {
			delay()
			println(iam the first)
		}
		launch {
			delay()
			println(iam the last)
		}		
			
	}

}


```

## Suspend vs block methods
- blocking call to a function means thata call to any other function
- from the same call to any other function
- will halt the parent's excution

- if you call a susbending function you can wasily push that other function to a differnent thread . in case it us a heavy operation , it won't block the main thread



## Continue
- dispatchers types , builders 
- delay is a suspend function



## Strutured Concurrency
- new coroutines can be only launched in a specific couroutinesscope
- which determine the lifetime
- ensuresnot lost
- all children complete
- ensures that any errors in the code are properly reported
- to enforce this reltionship coroutines are created inside coroutinesscope

## Jobs
- defered is a class extend job

## Cancelling Coroutines
- somtimes we want to cancel a coroutine . as structured concurrenct
- cancelling
```

funmain (){
	runBlocking {
		var job = launch{
			repat(1000)
			prinln("$it")
			Thread.sleep(100) -> replace with delay(1000)
		}
	}
	delay(1000)
	job.cancel()
	print("Cancelled")
}

```
- un cooperative code
- hace copertaive code :
- yield or delay , isActive

- reason for cancellation

## coroutines methods
- isActive : finished or not
- join : used to make one coroutine wait for other coroutines until it finishes
- yeild : unblocking
- job is class like ptr to function
- cancel and join 
- await 
- invokeonCompletion : register handler that invode after completion
- with context : inside the coroutines 

## using cancel and join
fun main(){
	runblocking{
		val job = launch {
			try{
				repat(){
				}
			}
		}
		catch(CancelExcetion){}
		delay(1100)
		job.cancelNddJoin()
		println()
	}
	
	

}

## withTimeOut
- val job withTImeOutOrNull{
	repeat(100){
		print 
		delay
	}
	if(job == null){
		println("time out")
	}
}

- we will use :
	- launch asyn
	- withcontext
	- suspend
	- dispatchers
	- handling exceptions


## Lab 
1. create a coroutine 1..10 async + launch
2. suspend
3. create two coroutines
4. create susbend function that takes an array as an input and output
5. create a job and try to use join and canceland joim

























































































































