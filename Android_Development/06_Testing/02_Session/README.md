# Android Testing

## Testing Repo
- only test code in that class
- repo is source of data in app 
- respo. to provide its users with data 
- testing repo is challenging
	- because it depends on local and remote sources
- there are repo's dependencies
- default tasks repo : 
	- Tasks Local Data Source (Room)
	- Tasks Remote Data Source (Network)

- create and manage database to do 
- room database need and android env to run
	- si it has to be an instrument test
	- use android x to get simulated android env
- networking code can take long tim to run
	- so it will be a long running
	- flaky tests
- proplem may be on one of the two data sources


## Test Doubles
- solution is that instread use test double
- version of class for testing
- replace real version in tests
- similar to how a stunt double is and actor
	- who specilizers in stunts 
	- and replaces the real actor for dangerous actions

- two classes same
	- same methods
	- implements same interface 

## Test doubles types
- fake : working implement
	- good for tests but unsuitable for production

- stub : test double no logic and only returns what you program it to return
	- stubtaskrepo could be programmed to return certain combinations of tasks from get tasks for example
	

- DefaultTasksRepo -> source
```
get tasks -> updata tasks

```
- return from local always

- get tasks 
- delete tasks , delete all

## wrong
- violate single respo
- source don;t know about testing


## dEPENDENCY injection

## Test Task Repo
- repo depe are hard code in body of class
- make it hard to fake
- providing these dep. will make it easy to swap imp and replace fake one
- providing dep , is called dep injection
- degatasks repo -> taksklocal + remote
- default -> injection local + remote


## Di
- two comman ways
- constructor injection or setter
- CI is preffered 
	- when constricting focus to the dep needed 
	- swap happens at constructing time so it will not result in a strange state

```
class Defaultrepo(private val remote : tasksDatasoirce , privat val local : tasksDatasource)

```
- it will wait for the interface , so it will accept any class which implements the interface

##

- in get instance
```kt DefaultTasksRepository(TasksRemoteDataSource , TasksLocalDataSource(database.taskDao()) ).also {
```             

- there will app class -> have remote local and others
- ot use Dependency Injection like dagger or hilt

```
## testing viewmodel
- same logic di and test doubles 
1. repo interface
2. repo implements interface
3. pass repo paramter to vm , create proper factory
4. use vm factory to create your custom vm

- steps in lecture

## refactor prev created tests
- create fake repo
- refactor test code
- previous lab change it

## labs 
- test repo's get task (done)

- apply dependency injection in VM



































































































































































































































