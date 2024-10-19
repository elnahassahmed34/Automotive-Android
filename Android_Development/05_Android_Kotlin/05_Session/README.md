## kotlin 

- View binding feature allows you to more easily write code taht interacts with viwes

- once it is enabled in a module , it generates binding objects 

- null safety , since view binding creates direct refrences to views , there is no risk of null ptr exception due to an invalid view id

- type safety : the fields in each binding class have types matching

- lateinit var btn : Button 
- oncreate -> btn = findViewById(R.id.et_input)
- so it caused class cast exception
- xml :
- constraintLayout 
- <EditText>
- <ImageView>
- <Button>
- binding is a generated class and have some items related to them

## methods used for binding
- inflate(inflted) -> activity
- inflate(inflater , parent , attachParen)

## cml activity
- xml -> acticity_main.xml
- generated class : ActivityMainBinding 

```

late init var bibing : ActivityMainBindid
binding = ActivitMainBinding.inflat(layoutInflater)
setContentView(binidng.root)
binding.btn.setonCLickListner{

}
binding.
```

- root elemtnt as Constraint layout

## if fragment

- in create view call inflate , method include in the generated bindign class
- bindign root

```

binidng - FragmentMybinding.infate(inflater , container , false)
val view = binding.root
return view

binding.rvcakes.adapter = myadapter
.layoutManfaer
binding.rvCakes.apply
```

## binding Usage in RV
- let ViewHolder constructor take a paramter of binding generated class type then inside the super constructor 

- class ViewHolder(val binding : ItemCakeBinding)
- RecyclerViewHolder(binding.root)

- inside oncReateViewHolder() call inflate() method included in the generated binding class
- this creates an instance of bibdin class for fragment to use

- inside onBindViewHolder() , holder.binding .givenid

```
onCreateViewHolder{
	val inflater : LayoutInfalter
}

on bind biewHolder(){
	//housing the data
	holder.binding.apply{
	
	}
}

binding.id.{

}

```


## Data Binding
- data binidng library is a support lib that allows to bind UI components in your layouts to data sources in your app
	- using declratice format ratheer than programettily
- bind compnanto in layout file lets to remoce many ui framework
- make xml smart contain objects + attributes using data binding

- a binding class generated for each layout 
- data binding layout files are slightly defferent and start with root tag of layout followd by data element

## data binding steps
- conver regulat xml layouts into data binding layout
- add data tag with variables bound to your data source
- use binidg expression to handle events emiited by your views
- bind your data source to your xml layouts

- add vaiable tag
- android:text="@{String.valueOf(index+)}"
- android:visibult(@{age>13?View.Gone : })
- android:text="@{user.display ?? user.latName}"


## bining data to activity
- val biniding = activitbinding.inglat setcontent binding roor
- val binding : Activity = data bundingUtil()

- binding.lifecycleoWenrt=this
- myAdapter = personAdapter(listOf)
- data source is linked
- element of jetpack so it cordinates everything

## binding with fragments
- oncreateview
- val binding = fragmentBlank.inflate(inflater , container , false)
- bindingmovie = movie 
- return binding.root
- oncreateviewholder

## adapter
- constructor
- oncreate -> inflate
- onbindViewholder -> refrence cureent object +
- interface onclick listner + send it to xml
- action.onPersonClick(person)

## disadvantages
- Glide -> image to imageview
- binding adapter -> to the image
- binding adapters are responsible for making the appropriate framework
- @binidngAdapter("myImageUrl" , "myError")
fun loadImage(view , url , myerror){
	picasso.get.load(url),errir,int
}
- this binding
1. applies to the app 
- can be appliet to every imageview
- makes the imageView show the image loaded via picasson or in case of failure

- app:imageUrl="@{movie.imageUrl}"

## - data binding not recommended
- use view binding if you want findviewbyid
- it is more complex -> need more compilation time


## lab
- refactor yoor last made products app so that it start to use data binding and view binding
- copy it to use view binding first then use data binding

- gpt and change them















































































