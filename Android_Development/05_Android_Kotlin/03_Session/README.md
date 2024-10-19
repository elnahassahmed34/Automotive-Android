# Services

- service is like activity but without ui not like the thread
- component that rins in the background to perform long running operations without to interact with user
- for example : play music bk , fetch data over network without blocking user interaction with an activity
- can work in background and can interact with it
- like soundcloud music

## service states
- started
	- service is started when an app component 
	- activity -> start service()
	- once started a service can run in the background indefinitly , even if the component that started is destoryed
	- like map
	
- bound service
	- app comp. bound it
	- request and respond model like sound cloud
	- send request and get results 
	- even do so across process with IPC

- if you want to donload big file you shouldn't do it in thread 
	- download it using service
	
## Service creation
- create kotlin class extend service base class or one of its classes
- service methdos :
	- oncreate -> sys call this method when service create one time setu
		- startservice or bindservice

	- onDestroy
		- syscall this method when the service is no longer used 
		- your service should implement this to clean up any resource such as threads listneers
		
	
	- start command
		- make thread here
		- stopSelf(inside) or stopService(outside) methods to close service
		

## onbind -> bound service
- syscalls this method when another componenet wants to bind with the service by calling the bindservice
- if you implement this method you must provide an interface that clients use to communicate with the service , by returning an Ibinder object
- you must always implement this method but if don't want to allow binding , then you should return null
- IBinder -> responsible for IPC between service and activity or broadcast

- onUnbind
	- this syscall when all clients have disconncted from particular interface published by the service
	- this is called by calling unbindService -> call onUnbind

- onRebind
	- syscall this method when new client hace connected to the service
	

## service lifecycle
- call to start bind service
- oncreate
- onstartcommand , on bind
- service running , client are bound to serveic
- on unbind
- ondestroy


## demo


## Intent Service
- Intent service class is a convenience class sets uo a worker thread for handling bk task and handles each reques in an sync manner
- onhandled intent 
```
class MyIntenstserccLIntentSerces
override fun onHandleIntent(intent:Untent?){
	
}
```

- adding service to the mainfest
```
Intent in activity
to start service
```

//package:mine tag=:services


## foreground services
- perform opertopms that are noticable to the iser
- to make foreground service you shoud add this permission to your mainfest
- 
- interaction between it and ui
"android.permission.ForeGROUND_SERVICE"

- app target android14 choose foreground service type that represnt
- now we should use startforegroundservice() -> activity fragment notifictions

## notification Anatomy
- small icon appname timestamp title text notififcation action , large icon
- setcontent set smallIcon contenttule , content tezt priority
- for android 8.0 and higher , you must isntead set the channel importance

-API level 26+
```

private fun createNotChannel(){
	
	if(build.Vesion.sdk_Int >=)
	val name = getstrin
	val desccriptipm
	int importance NotManfer
	ival channel = natification channel
	notification manager
	notificationmanger.create
}


val buidler = notifaccompate.builder
	.setsmall conten
	priory
	.setcontentintent(pendingIntent)
	.setAuticancel(true)

val intent = Intent(this , AlertDetails)
intent.setflags()
val pendingIntent = pwndingIntent.getActitvy(this , 0 , intent , pending)



```
- pending service in the future of nitification
- no UI for this intent
- flagactivity new task , or Intent.FLAG.Activity_Clear_TASk

-notififcationmanage.notifty(id , bulder.buikd)
- permission post_Notifition


## demo
- extend intent service
- on handledIntent(){
	start foreground
}

-btn.setonclicklisten{
	- intntnet
	- start foreground service
}

- mainfest -> foreground service + postnotification
- tag

## background service
- push notfication
- as from whatsapp server then it give me notification
- GCM google cloud messaging

## JobIntent service
- hel[er for processing work that has beem emqueued for job/service
- the work will be dispatched as job via JobSchedular.enquque
- whn running on older version context.startserivice
- you must publish your subclass as a jobservice in your mainifest for system to interact
- limit the duration of the service
- abstarct fun onHandleWork(intent : Intent) = onhandledintent
- called serially for each work dispatched to and processed by service 10 minuts
- this method is called on bg thread -> you can do dlong blocking operations here
- upon returning , that work will be considered complete and either the next pendign work dispatched here here or overrall service
- Enqueues work in job scheduled

##work with it
- add this permission and service tage
companion object{
	id
	myEnqueuework{
		
	}
}
val intent = Intent
- MyJobService.myEnqueueWork(this , intent)


## Demo : 
- class myJobIntentService
- myjobIntentService
- mainferst -> wake lock + 
- permission


## Bound Service
- unlike started , provide a mechnism for implwmting com. between android service and one or more client components
- bound services are created as sub classes of android service class and must at a minimum , implement the onBind() method
- we need service to do IPC
- example : Activity object to talk with service object
- service has method
- we donot have refrence , we need one and call it
- so we need IPC
- clent compnotntsbind service
- on bind return Ibinder object

## - Ibinder is an interface 
- light witght remote procedure call
- public class Binder
- extends object implement Ibinder
- the first bind request to bound service in a call so that sercics on bind method can perfoemr


## client server interaction
- clients wishing to bind impmements service connection
- onservice connected and disconeted
- binder will be sent to onService connected

## Client Server Implementation -> refrence for this remote service and call service
1. subclass service (bound service 
2. subclass binder-> within bound services
	- impent method that return ref to service
3. inside services subckass add one or methids called by clients
4. create an object from your binder subclass
5. let the onbind return binder object
	- returns object from custom class
6. register your service in the mainfest
--- clent
7. create class implements service connect
	- onservice connected
		- cast the incomming Ibinder to your binder subclass
		- get refrence to your bound from the binder
		
8. bind the client to the service
9. let the client interact with bound service 


## Example
- App that have a button that shows the time
- the time will be on the text view

## bound service
```
class boundService : service{
	private val mybind

	on bind -> retrun myBinder

	innerclas get current
	

	
}


2. mainefest

3. activit

{
	private myconnect L service coniction = object L Service{
	
		onservice connected
	
		
	}

}


4. intent connection + bind service 
5. showTime
```

## mybound service
- one object of service will be created


## broadcast reciever
- app listens for specicfic broadcast intents
- class extent broadcast reciever -> onReciever
- broadcast reciever within code
- when battery low there is a broadcast
- part of registerns in extends intent

```kt
//reviever

class Myreciever : Broadcast(){
	onRecieve
}

//sender
fun broadcastIntent(view){
	val intent = Intent()
	intent.action = com.example.SendBroadcast
	intent.addflags()
	sendBriadcast(intent)
}

```

- os take a loop in the manfest of app and see whan care about this intent
-








































































































































































































		
		
		
		
		
		
		
		
		
		
		
		




