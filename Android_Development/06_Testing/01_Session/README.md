# Android Testing

- VM , LD , DI , doubles , repo , room , rules

## what is testing
- manual or if sys under test
- app correctness , functional behaviour , usabilbity
- during this course when mentioning anything related to writing a test will be referring to aitom procedure from of a test

## Goals
- Every thing is OK 
- safer code refactoring
- stable develpoment celocity
- inc . dev . speed , rapid feedback on failures
- Document your code
- when testing repo , not care about local or remote source

## Testing types local vs instrumented
- run locally on dev, machine's JVM , don;t req. an emulator or physical device , fast ,act less like they would , android junit 
- run on real or emulated android devices , related to UI
- much slower
- they reflect what will happen in real world
- android Instrumented test m Espresso



## Testing scopes
- unit test , integration test , end to end test , app

## Unit testing
- single function or class
- helps to point of failure
- run fast usually local
- low fidelity

## Integration test
- several classes or single feature 
- ensure classes work together 
- can be local or instrumnted
- testing vm + repo

## Emd to end test
- large portion of app
- test app work as hole
- always be instrumented test


## Testing source test
- source sets
- main : app code , build variants
- android tst : instrumented test
- test : contains local tests 

```
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}



@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.a01_session", appContext.packageName)
    }
}


```

## Testing dependency
- test imp , android testimp
- testImp("jubutLjunit:4.13.2")
- androidTestImp " "
- espresso junit
- they sould see the code in app completly
- but they don't depend on each other



## app
- to do list + statistics
- clear completed
- add , data , staticsts , tasks 
- util 

## readable
- naming , code structire (given , when , the)
- assertion

## naming
- subject _ action_result
- subject under test , actionorinput , result state
- pojo -> Task.kt ->
- statisticsUtils -> pojo result

## Given When Then
- Arrange Act Assert
- sets up the objects and state pf a[[
- when make actual and changes to subject under test
- then checks what happen when you do the action how your changes affect (often done using assertion framework)


## Asserion framework
- hamecrest , truth
- hamecrest library
- asserEquals(of , result.completedtaskspercen)
- assertThat(reslt.com , `is`(of))

## writing first test
- getActiveAndCompleteStats()
- will it be local or instrumented test ?
- local :

- fun get_nocomplet_100activenoCOmplet(){
	val tasks = listOf<tasks(Task())>
	result = fun
	assert Equals()
}

- generate -> test 
- statisticsUtinls test

```
class StatisiticKtTest{
	
	@Test
	fun getActiveAndCompletedStatus_noCompletedList_100Active0Completed(){
	
	//given : list without completed tasks
	val tasks = listOf(
		Task("tasks1")
	)
	
	//when getting active and completes status
	val result = getActiveAndCompletedstats(tasks)
	
	//Then : assert active is 100 and complete is 0% -> one by junit and other by hamcrast
	assertEquals(100f , result.activeTasksPercent)
	
	assertThat(result.completedpercentage , `is`(0f))
	
		
	
	}
	
```
- there are some methods don't need inpuit 
	- so no input in naming


## testing viewmodel
- app -> act -> fragment -> vm -> repo -> local or remote
- tasksViewModel
- fun addNewTask(){
	_newTaskEvent.value = Event(Unit)
}
- tasks -> tasksviewmodel
- assert if livedata has value or not

- create viewmodel provider or factory
- provide -> scope + change(not destoryed) 
- one object of view model
- constructor needs app -> provides in local test
-

## Androidx test , test runner , robolectric
- libs that helps me in testing
- runwith(AndroidUnit4::class)
- robolectroc -> lib 
- local instrumet -> androidxTest -> runner or robolectric

## testing VM steps
- add android x dependacy + robolectric
- swap out the runner
- use android x classes 


## observing live data in local test 
- using lifecycleowner for observing
- observe for eve
- create observer livedat , add newtask , assert , remove observer
- add in live data get and await


```
@RunWit(AndroidJUnit4::class)
class TasksViewModelTest{
	
	@Test
	fun addNewTask_NewTaskEventIsNotNull(){
	
	//given object of Vm
	val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
	
	tasksViewModel.addnewTasks()
	
	//method will be given
	val result = viewModel.newTaskEvent.getOrAwaitValue.getOrAwaitValue()
	 
	 
	 assertThat(result , not(nullValue()))
	 
	 
	}

}





```


## labs
1. 4 tasks should be passed -> fux last 2
- last twwo will be error , return method and check the error and make it path
- path 

2. add new task in vm
	- setfilter(privatemethod)
	- you will call another method
	- we will not call setFilter() 
		- we will call another method
		- test what filter concerned about

































































































































