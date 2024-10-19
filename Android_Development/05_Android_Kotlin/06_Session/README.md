## Coroutines with android


- In android coroutines help to manage long running task 
- keep your app responsive while managing long tasks
- simplifing sync code in your android app
- write code in sequential way
- handle exceptions with try / catch

## benifits
- Light weight
- fewer memory leaks
- build-in cancellation support
- jetpack integration
	- work manager
	- view model
	
## suspend functions
- it is not blocking the task just suspend and resume
- it is called with coroutines

## example
- fetch -> main thread
- suspend -> get -> coroutines
- show

## dispatchers
- io -> fetch data or write in files
- main -> ui disptchers
- default -> work for cpu

## with contect 
- seitch from diffrent pools
- suspend fun get(url : String)
- start main
- withContext(Dispatcher.IO){
	
	switch to disptacher.IO
	perform blocking network IO here
}

- returns to dipatcher.Main


## coroutineScope
- coroutines must run in coroutineScope
- keep track of all coroutines started in it
- provides a way to cancel coroutines in a scope
- provides a bridge between regular finction and coirroutines
- types : GlobalScope , viewmodel has viewmodelscope , lifecyclehas life cyclescope


## async or launch -> lamda result from network

## Coroutines - Retrofit
- as mentioned coroutines make the heavy work easier
- newtwork connection
- using retfrofit with kotlin requires no extra dep,
- dependency 

## define retrofit service
```

interface SimpleService{

	@GET("posts")
	suspend fun listAll() : List<Post>
	
	@Post("posts/new)

}





## set uo retfrofit

object RetrofitHelper{
	retrofit.builder{.addconverte.baseurl.build}
}


object API{
	
	val retrofitService : SimpleService by lazy{
		RetrofitHelper.retrofit.create(simpleService::class.java)
	}

}


lifeCycleScopr.launch(Dispatcher.IO){
	val postList = reofitService.listAll
	withcontext(main){
	}
}	


```

## demo for retrofit



## coroutines room
- @Doa interface colorDao{
	@Query("Select * from colors")
	suspend fun getAll() : List <color>
}


## database
val instance = Room.databaseBulder(
).build
- Instance = instance 
instance}

- anotation for room
- an=bstract as room will build it
- = private static ClolorDatabase INSTANCe = null
- elvis contain null or not -> if(==null){}esle{}

- dependency 
- not use live data , as coroutines are used

## work manager with coroutine
- do work is susbend
- it works on dispatcher.default
- integrate with viewmodle scope


## lab connected -> coroutines + retrofit
## not connected room+coroutines
## for coroutines scope use lifecycle
## remove work manager -> lifecyclescope.launch


## lab 
1. work with retrofit using coroutines


2. work with UI 
	add button in activity 1 to go to fav
	add new activity where
	add delete in    

































