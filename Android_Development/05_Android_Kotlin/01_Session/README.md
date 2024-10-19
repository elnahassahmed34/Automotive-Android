# Android Kotlin

## text view , button input
## lateinit
- using lateinit , initial value doesn't need to be assigned
- type doesn;t have to be nullable so ?. !! are n't used
- promise to initialize
- lateinit
- uninitialized property access
```
lateinit var person : Person
fun main(){
	println(person.name)
}

```

## lazy
```
val person2 : Person by lazy{
	println
	Person()
}

fun main

```
- is n't initialized except it is used

## lateinit vs lazy
## Anomyous class object expression

## Fragments
- create fragment extend fragment class
- xml then link it 
- add id to already made xml static fragment
- adding fully qualified name to cintainer creates xml fragment
```
class StaticFragment : Fragment
```


## Recycler View
- Acticity , repo , adapter set on click view
- data class language(var name : String , var img : Int)
- obect recycle view(){}
- class recycler view adapter -> viewholder
- holder : tx L ids + layout
- val inflater 
- view inflater.inflate item language
- return viewholder
- holder.languageImg.setImageResource
- activity implent listner -> provide on click
- create recycler adater
- recyclerview.apply{layoutmanageer+ adapter}
- interface to lambda
- // language ->Unit
- var myListner : (Language) -> Unit
- val lambda : (language) -> Unit = {lan : Language -> Toast.makeText(this , lan.name , Toast.LENGTH_SHORT).show()}
- send to adapter
- object : Runnable{
	override fun run(){
		this@class
	}
}


## Recycler view - notify data set
- notify item change -> DiffUtil

## DiffUtil
- is a class taht recycler view has , it is used for calc. the differnces
- added , which is much more effiecient tgan redoing the entire
- we will change in the adapter
- two lists compare

## using of diff util
1. model used to be displayed RV should provide for the equals method
2. create subClass extend diffutilcllback , implemetn itemthe same and are contentsthesame() methods
3. In your adapter extend listAdatped<model , ViewMHolder>
4. pass itemcallback subclass to the adapter constructor
5. make the list
6. remove getitemlist
7. inside inbindview replace data[position]- >
8. submitList() insteadof notifyDataSetChanged


## 1. create model
@ Entity(tableName = "persins")
data class Persom(@primaryKey var name:String , var age:Int)
- we used a data ckass as equal is 


val lang1 = lnaguage(kotlin , R.drawable.kotlin)
val lang2 = lnaguage(kotlin , R.drawable.kotlin)
- content equalit vs refrantial equality


## Subclass DiffUtil.ItemCallBack
class PesinDiffUtil : Diiffutil.itemcallback{
	are itemsthe same
	are contents the same
}

## step 3 4 5
- import ListAdapter + RecyclerView
- class PersonAdapter () : ListAdapter<Person m PersonViewHolder>(PersonDiffUtil)
- remove count
- mAdapter.submitList(list)

class MyDiffUtil : DiffUtil.ItemCallback<Language>{
	
}

- class ListAdapter : ListAdapter<Language , ListAdapterDemo.ViewHolder>(MyDiffUtil()){
	
	oncreateviewholder
		inflater : LayoutInflater = parent.context.getSystemService(Context.Lauout) as layoutinflater
		inflate
		object viewholder
		
	
	OnBindViewHolder
		val currentLanguage = getItem(position)
		holder.languageName.text = currentlanguage.name
		holder.language.setImageResource(currentlanguage.img)
	
}

lateinit var reccyclerView : ListAdaper

recyclerView = findViewByid(R.id.rv)

recyclerview.adapter()

recycleradapter.submitList(RecyclerRepo.getlanguagers().toMutableList())

- lab 
- two activities
- Activity A , ActivityB
fragment A , Fragment B
- list of products , productB Product Details
- Activity A -? fragment A + B

- intent from A To B
- landscape
- resource.configuration.oreintation
- communicator
- dummy data -> after that we will use retrofit and coroutines

##Lab
1. UI with chat gpt -> two activities (done)
 
2. data class dummy data -> slides (done)

3. first fragment -> recyclerview to list adater and diffutil 
	- easy in slides work it
	- then use what inside the videos
	- adapter 
	- fragment
	
	
4. 2nd fragment text contain name 





































































































