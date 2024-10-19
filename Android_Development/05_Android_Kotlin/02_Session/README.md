# Locations

## Location based services (LBS) 
- where iam , how do i get there , what around me
- gamification , motization
- accelratores , incubatores ,  	

## LBS approach 
- process location data in server
- obtain data fo a device based app. that uses dorectly

## LBS expression
- real time posiftiong method
- accurancy
- location can be expressed in spatial terms or as text description


## Spatial terms
- latitude : 0-90 north or south 
- longitutude : 0-180 east or west


## determining the devic's location
- mobile phone network
- short range positioning becons
- satalites


## mobile phone network -> BTS : Base transceiver station
- current cell id can be ised to identy the base receiver station , that the device is communiccation and the location of that bts
- accuranny size of cell
- GSM cell may be anythwere from 2 to 20 KM in diamaters
	- GSM : call and sms
	- mobile data is needed for location

## Short range positioning becons
- in realtivly small areas such as single buildin , local are 
- for example appropriatly equibbed devices can use bluetooth for short range positioning
- Triangulation -> intersections of BTSs with each other

## satelites
- Global positiong system GPS
- GPS determines the devices position by calc dif, in the times signals from diff satelites take to reach the reciever
- GPS is the most accurate method (4-40 meter)
- GPS in mobile is just the reciever
- extra Hw can be costly , consume battery whule in use and requires some warm up after a cold start to get an initial fix 
- GPS reciever must has a clear view of the sky


## Location in Android
- Android gives your app access to location services by device
	- through the classes in android.location package
- central compnent of the location framework is the location manager 
	- provides APIs to determine location and bearing of the underlying device
- location manager is one of system services like inflater

## Location manageer
- access to system location servicess
- able to
	- query for list of all location provider -> network or GPS
	- register/un for periodic updated 
		- live location
	- register/un given Intent to be fired if the devuce comes within a givern proxmitally
		- specide by radius in meters of give latitude and longigtude
	

## Location providers
- locationManger.GPS_Network_Provider
- val provider L Location? = LocationManger.getprovider()


## example
```kt

override fun start(){
	
	super.onstart()
	// casting with as
	val location mnager : locatio = getSystesservice as location manager
	
	val provider = GPS provider
	val is enabled = is provider inableed
	
	- enable lcation setting{
		//implicit Intent -> take an action not like explicit which take destination
		val settingIntent L Intent = Intent(Setting.Action_source)Settings)
		srartActivity(settingIntent)
	}
	

}


```

## Criteria
- a class indicating the app criteria for selecting loc. prov.
- order : acc , power , ability to report , speed , moneary cost
```
val vriteria L Criteria = Critieria()
criteria.accurany,power,isaltitude.isCost = criterial
val best provider = get best provider

```


## Location
- class representing geographic location sensed at particular time
- location latitude longitutde , optiolanly speed
- get location using
	- locationManager.getLastKnownLocation(Location.GPS_Provider)

## Location Listner interface
- used for recieving notififcation from location manager when the location changed
- these methods are called if the location listner has been registered with the locationmanager service
- requestLocationUpdated(providerLString , minTime:long , minDistanceLFloat , listner:LocationListner -> callback)

## location listner interface
- fun on locationchanged(location 
- on providerDisabled)
- on provider Enabled
- on statusChanged(provider:String , status:Int , extras:Bundle)
	
	
## Persmissions
- Uses permissions is needed
- access permissions

## Google Play Services
- Using the google play services location APIs ,your app can request last kmown location
- in most cases , you are intersted in the user's current location
- use the fused location provider cloent to retrieve the devic's last known location

## Setup google play services
- Ensure downloading it via sdk + dependency

## Fused Location Provider Client
- the fused location provider client is one of the location APis 
- main entry point 
- managesmanage underlying location tech provide good support

## create location provider client
- privte lateinit var fusedClient : FusedLocationprovideCKient
- fused = getfused()
- getlastLocation() : Task<Location>
- returns most recent 
- returned null
- best accurany

## example
```
fused.lastlocation.addOnsuccesListnerr(this@main , object L onsucces){
	override fun Onsuccess(){
		Toast.makeText(),show()
	}
}


fused.last.add{location->llocation
	toast
}


```


## Request location updated
- fun requestloactionudpated(
	request : locationrequest
	callback
	looper) : Task<void>
)

- to detemine level of accurance + update period

## LocationRequest.Builder
- update interval
	- setIntervalMilis
- fastest updateinterval
	- setminUpdateInterval
- priorty
	- set_priority()
	- default value is priority.priory_Balancedpoweraccurany
	
## Priority constants
- Priority balanced accurancy , high power , low power, 
- no power : negligible impact on power cosumption , but want to recieve

## example
- val locationrequest = locationReques.builder.apply{
	highpower
}


## location callback
-locationcallback = object : locationcallvbakc(){
	onlocationlesult(location){
		log.i(tag , lication)
	}
}

## fused -> take the request + callback

## Runtime Permissions
- check if permission are granted
```kt

//handmade function
fun checkPersmissions() : Boolean{

	var result = false
	if(contextCompat.checkselfPermission(this , access_coarse_location) == packagemange.prermissionGranted)||
	(contextCompat.checkselfPermission(this , access_fine_location) == packagemange.prermissionGranted)||
	{reult = true}
	return result 
}


private const val My_location_permission_Id = 5005
Activity.requestpermission(
	this,
	arrayOf(Mainfest.pesmossion.Access_coarse_location+FIne) 
	my_Location_Permission_ID)
)


result:
override fun onRreqPerResult(request code , pesion , grantResults){
	super.onRequestPermissionResult(
		request, permision , grantResult
	)
	
	if(requestCode == My_Location_perm._ID){
		if(grandRsults[0] == permissionGranted){
			getLocation() -> handmade funditon
		}
	}
}

```

## lab -> demo
- location and make it on text view
- permission at first
1. check permission from slides
2. fun enabled loacation services
3. islocationenabled
4. get frsh location
	- fuse location
	- reuest location + priotity
	- request + callback + looper
5. activity -> from video


## lab
- get device GPS location

1- as demo make langitude and latitude from video -> just do this , it fine for me then try to add
	- download video
	- go with it

2- then address as a text description -> gio
	- put internet permission

3- SMS view -> to send the address and mobile number
	- implicit intent

4- open a map fragment in your app and add a pin to your and a pin to location

-- classx

























































































	



































	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	












		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		





























































