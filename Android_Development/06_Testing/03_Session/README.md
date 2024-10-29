# Testing Android


## add before or after
- run befare or after every test
- in older versions of junit = before each
- before all , run one time when class created 

## Main Coroutine Rule
- junit rule classes where you can define generic test code that can excute

```
class MainCoroutineRule(val dispatch : restdisparcher : testwatcher() , test coroout){
	override fun stating(descrioptin(){
		super,statring
		dispatcher.setmain
	}
	
	finish{
		cleanupTestcoroitns
		dispatcher.reset
	}
	
}

@ExperimintanlCorootines
@get:Rule
var maincoroutinRule = MainCoroutineRule

```




## Coroutines and viewmodel
- dispatcher main has failed
- should change the dispatcher
- runTest -> Test scope
- we need test dispatcher too instead 
- becaise lack of android loo[per . get main looper
- errir message does tell you to use dispatcher.setMain from kolinx-coroutines test 

```
@EXpermintalcoroutineAPi
test disptacher

@before
dispatcher.setMain(testdispactcher)

@after
dipatchers.resetMain()
testdispatcher.cleanupTestCouroutines

```



##  How to create junitrule
1. extend test watcher whech implement test rule interface
2. implement test coroutines scope , to which you pass test coroutines dispatcher , main corotines rule ability to control coroutines timing



## Testing room
- room DAO + local data source 

## doa
1. add arch comp test lib to gradle
2. create task doa tes
3. set up taskdoatest
4. write doa test case

## 1
- android test impm , test imp
- we will choose it as local test
- always instrumnted if you run , use sqlite version on machine
- which could be very diff. from version of sqlite that ships with 
- run in local or instrumnted but it preferred to use it intrumnted , and try it on diff. devices

## 2

@ SmallTest
- mark the test as small run-time unit test
- @MediumTest integration tests and @LargeTest enddn to end
- this helps you group and choose which size test to run 
- doa test are considered unit test since you are only testing the doa , thus you can call thme small tests


-@expermintal

- 	var instantExcuteRule = InstantTaskExcutorRule()
}


- excute each tasks sync using arch comp.
- create another thread





```
@EXprimntedcoroutinAp
@RunWith(AndroidJUnit4::class)
@SmallTest
class TasksDoaTest{
	@get:Rule
	var instantExcuteRule = InstantTaskExcutorRule()
}



```
## set up tasks daoTest class
- database = room.inMemoryDatabasebuilder(
	getappcontext
	to doDatabase
).build

- normal db are meant to persist 
- in testing we need our db to be completly dleelted once the process that created it is killed and never stored on disk

@After -> fun closeDb() = database.close()



## 4 test cases
- inserTask + getTaskById
- create tasks in database
- retrieve id
- asserts that task was retrieved and that all its properties match the inserted task

```

Given
val taks
db.tasksDao().insertTask(task)

val loaded = database.taskDao().getTaskByID(task.id)

assertThat<task(laded as task , notNullValue())>

assertThat(loaded.it , `is`(task.id))
assertThat(loaded.title , `is`(task.title))


```


## Why tasks Local Data source test is an integration test
- Tasks ;oca; datasource is a class that takes the info returned by dao and converts it to format that is expected by repo
- it wraps returned value with success or error states
- you will be writing an integration test 

## tasks local data source test
1. create tasks local 
2. set up test
3. test cases

-- same things but 
- @ mediumTest

```
private lateinit local and

local data source = tasksLocalDatasource(
	database
	dispatcher.Main
)


```

## 3 test cases
- create 


## labs : Room

Doa
1. saveTask_RetrievesTask()
2. updateTask_AndGetById

Local
3. saveTask_retrievesTask()
4. completeTask_retirevedTask()



## project
- room -> local and doa 2 methods
- repo -> 2 methods
- view model -> 2 methods































































 





































