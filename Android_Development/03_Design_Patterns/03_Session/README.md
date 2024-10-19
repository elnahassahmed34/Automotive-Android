# Design patterns

## MVP in Action
- model data , view navigation  fragments , presenter logic validation
- easy , follows sepration of concerns , made unit testing easy
- that were our main goal of arch patterns
- un fortuntly , it has some drawbaks , which start to unfold as modre code and 
- more logic gets involved in the mvp traid

## mvp drawback
- tight coupling between view and presendter
- view and presenter will rapidlly expand in the code line size


## mvvm -> model view ViewModel
- model , presenter-> view + model , view
- model , ViewModel (model) , view  
- no refrence for view


## Introduction
- view m UI and informs other layers about user actions 
- viewmodel expose data
- model retrieves info from your darta source and exposes it to the viewmodels : POJO , Repo , and data sources


## View
- interact with user
- display interface 
- informs viewmodel about other actions
- view are usually represented in android as activities pr framgents


## model
- already wriiten 

## view model 
- layer procves info
-views can request info from any view model 
- new movie is responsible for it


## MVVM flow
- in mvvm view serves as the entry point for user input and starts to handle it 
- view -> viewmodel -> model
- view model exposes data and methods without caring 
- mvp is different as mvp care to link view and presenter

## demo
- model
- person -> data class Person()
- Repo -> mutable list -> init -> addpersons , get persons

## class my viewmodel
- add to list -> repo.addpersing , fun delte , 
- if with room we use lenghty opertion so observable is used
```kt

private var list = MutableLiveData<List<Person>>()
val personList L LiveData<<List<>Person>> = _list

```

- object -> mutable -> _personList
- two refrences -> mutable , Immutable personList

- parent p -> meth1 , meth2
- chaild C -> meth3
- parent p = newChidl ()

- LiveData = new MutableLiveData

- view model.personList.observe
- val observer = object : Observer<List> -> onChange
- list.observer(this , observer)

## Jetpackk viewmodel -> configuration change proplem
- on saveInstance in the bundle -> on create method
- this approach only work for primitive ->

- google has a speacial
- view model class adesigned to manage and store info in lifecycleawaremanner
- this means that the data stored inside it can survice

## using viewmodel
- when we declare call ViewModelProvide
- new one or already prepared one
- view model createswith the given scope
- it is retained when the view is detached

## use
1. create subclaas of vm
2. add methods
3. create instance


```
view model = Viewmodeprovide().get(myviewModel::class.java)

```

- have a hashmap to store the instance of view


## movie app with viewmodel
```

Viewmodel (repo) : viewmodel

// packing property 
mutableLiveData<><>
movies : LiveData 

getlocalmovies -> viewModelScope.launch(dispatcher -> _movies.postValue(irepo.))

```

## Activity
- viewModel has arguments
- viewmodel factory , fectory method is a creational design pattern
- that uses factory methods to create objects
- viewmodelfactory ubstatiates viewmodel obbject
- refrene of view model and how to pass it to viewmodel
- so we will use factory method

```
//implement interface of factory + pass object 
viewmodelprovide : ViewModelProvide:Factory{
	create(){
		return FavMoviesViewModle(_repo) as T
	}
}
class MyViewModelFactory 


val factory = MyViewModelFactory(repo remote + local)

viewmodel = viewmodelProvider(this , factory).get(model)


```

## Activity
- oncreate -> factory , viewmodel , recycler view -> viewmodel.movies.observe


## ViewModel
- handle config change
- lifecycle awarness
- data sharing
- kotlin coroutines support

## - shared view model
- sfragment A -> shredviewmodel -> FragmentB

```
class SharedViewModel : ViewModel(){
	
}


viewModel = ViewModelProvider(requireActivity.getshared)


```

## sharedview model vs safeargs
- safeargs use only bundles
- big data you need shared view model

## Android KTX

## dependency Injection
- constructor -> send paramters


## lab 
- xml from previous code

- room + retrofit from yesterday

- then have a repo

- then viewmodel



































































































































































 




