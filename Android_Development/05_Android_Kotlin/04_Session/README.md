## work manager

- how to decide your work
- work manager task in bg


## work manager
- the workmanager , jetpackarckcomp . api makes it easy to scedule deferrable , asynch tasks that must be run
- these APIs let you create task and hand it off to work manager to run when the work constraints are met
- work manager allow to observe
- Device API Level +23 jobscheduler 
	- 141-22 FSMnetworkmanager , custom alarm manager and broadcastreciever
- work manager uses an underlying job dispatching

## feature
- work constraints
	- as battery
- robust scheduling
	- donot ignore tasks
	- but delegate it
- expedited work
- flexible retry policy
- work chaining
	- tranmitting in order between tasks
- built in threading interoperability

## importance classes to know
- worker - does the work in bk thread , override doWork() method
- work reques 
- work manager - schedules the work request to be run
- constraint - condition on when the work can run


## dependeny , define work
- define the work that shall be done
- to create work

```
class MyWorker() : Worker{

	doWork():Result{
		return Result.success()
	}
	
}

```

## schdule a one time work re	uest
```
val
```

## scedule a periodic work Request
- Set a repeat interval
- set a flex interval


## Flex interval

## work constraints -> work input and output
- val compexMathWork = ontimerequestbuildr<>().setInputData(
	workDataOf{
		"x_arg" = 42
	}
).build()
- val x = inputData.getInt(key , 0)

## output
- Result.success() . failure , retry (output)


## Recieving data from worker
- to get extra information
- recieving data from worker

## Work Request constraints
- battery or network
- set req network
- set battery
- set storage

## example
- cval constraints = constraints.builder()
- then put those constraints

##
- worker , request ,, workmanager , constraints

## Chaining work
- work manager allows you to crate and quueu achain of work that specifies multiple dependent tasks
- to create a chain of work , you can use
1. work manager.begin with()
2. workmanagerbeginwith(List<OneTimeWorkRequest>)
the 
1. then(oneTimeWorkRequest)
2. then(list)


## Unique Work
- Unique work to do it once
- enqueue uniqe work
- .enqueeueUniqueWork("" , ExistingWorkPolicy.Keep , request)

## retry policy
- as mentioned work manager supports frim dowork
- results retry
- setBackoffCriteria(Backpolicy.linear , 10L m TimeUnit.Minuts)
- runAttemptCount
- if(run)

## observe WorkManger status
- Enqueue -> runnung -> suucess , faile , cancelled

## work manager if failure
## demo
- DownloadImageWorker
- activity : imageview + progress bar
- request -> workmanager
- getworkInfoIdLivedata
- state :
	- succed , running , failed ,



- lab
- retrofit helper
- dowork inside it the retrofit

- 1. class extend worker
2. list
3. 


## lab
// Using your first products app. Connect to the API:
https://dummyjson.com/products and get the products via one-timerequest then output the result. Observe the work status , once it
finishes, start populating your recyclerview with the incoming data 

1. make a worker class
2. make retrofit service
3. make retrofet helper(Retrofit clent)
4. make Network connection in worker
5. In your List fragment createRequest , enqueue it and observe

























































































