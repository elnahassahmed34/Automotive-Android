## Fragement

- Activit vs fragment lifecycle
1. A Oncreate start
2. F OnAttach 
3. F on Create
	- build the object of fragment in anythong which don't belong to ui
4. OncrateView
	- build UI of fragment
5. onViewCreated
	- 
6. Onstart
7. A On start
9. Onresume
10. F on Resume
11. A F ON pause
11. A F ON Stop
12. F ondestroy onviewDestroy
13. A onDestroy

## Ading fragment
1. Add fragmentContainerView to XML layout
2. add static code

### XML steps
1. create seprate layput file contains apperance
2. creates class extends fragment
3. use on create view method to link its apperance
4. ataach the fragment iside the activity through using fragment containerview

## lab
- add fragment 
- leave life cycle only
- fragment static

## Adding fragment dynamiclly

### fragment manager
- each acticity has its own fragment manager
- fragment manager : getsupportfragment manger
- maintaints refrences to all fragments inside the activity
- refrencing object in layout : find by id
- but for fragment you can use fragment manager : find fragment by id or find fragment by tag

## fragment transactions
- fragment manipulations are done throigh adding removing closing

- dynamic fragment
- fragment manager
- fragment transctoiin
- trns.add(R.id.container_dynamic , dynamicFragment , DynamicFragment_tag)

## View
- view oncreateview
	- inflation
- onviewcreated
	- btnfrag : find by id
	- btn.setOnClickListner()new Vieq.OnClickListner(){

	}



## lab -> action on one fragment affect other
- simulate communication between two fragments

## Inter fragment communication
- fragments should be coubled
- donot maintain direct refrence of fragments with each others
- Fragment A x->x Fragment B
- fragment A -> interface
- Interface -> Activity -> fragment B


## lab 3
- Activity A -> fragment A -> counter
- Activity B -> fragment B -> text view
- Intent to communicate between two activities
- landscape two fragments A B on same activity
