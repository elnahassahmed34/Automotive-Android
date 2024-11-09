## HAL layer

- diff between layer and stack

- app
	- system apps and user apps
	- give end user 
	- dialer , email , calender , camera
	- all interactions on level of app
	- telephone number

- hava api frameework
	- expose 
	- mangers are her
	-connect services to apps
	- manages from lower to upeer

- android runtime
	- ART 
	- dalvik
	- dalvik and art
		- run java apps generally
		- JVM -> dalvik
			- every app contains dalvik instance
			- thne it was very slow
		
		- ART : when i up OS there will be one instance 
			- create sandbox and run app
			- sandbox is like a container
			- memory addr and harddisk size
		
		- zygote
			- first app
			- it is an app like start up code
			- wake up before systems are up

- native c/c++ libs
	- speed things
	- performance 
	- speed of user to speed ao app
	- same app c++ or python
		- python is easy for dev but slow for os
		- c++ is oppisite
		- webkit and

## HAL 

- bridge between kernel and upper layer
- google and linux
- abstraction between hw and services
- if hw changed it is okay

## Hal and Vhal
- hw support in linux and android

- android hw support is sign diff from calssic approch typicallu found in linux and linux based and distru

## linix

- binderized hals : use android IPC to com with hw

- pass throigh L libs liked : it uses directly to driver 

- encasulte diver imp and offers uniform api for top levels

- hw vendors   use hals and dandroid is unaware of thier internal
	- so hal is hw specifif  sol 
	- oprimized and tuned for underlying tech
	- that provides a general user interface

- android app/framework uses java APIs (not by sys calls) to connect with withunderlying hw
	- linux connect to sys calls
	- android hal aloows android apps and framewod k to connect
- this abstraction permits OTA updates updates

- mobile have updates from samsung and google

- 


## OTA
- memory
- bl A B at single time you have A or B
- A android 14 , B android 15
- bl selects partition B
- rollback if not





## HAL

- android.hardware.sensors@<version>

## where to find
- AOSP_root/hardeare/interfaces

app calls audio
- sestem service audio manage
- JNI bridge : audio services calls native methods
- native service com with audo binder and HISDl
- HAL imp audio hal module send commands to alsa drocers to control
- hw excution : audio hhw produces sound

## HAL imp

- HAL HIDL or AIDL

- IDL : interface desc lang
	- which is an used to descile hal module is going to interfs
	
- AIDL : android interface description language
- files and written language but for android

- HIDL example
- create HAL Driver with HIDL for accessing GPIO

## HIDL
- define interface
- Genrate Android.bp file
- Generate default directory
- Implement Hal interface
- build app


## HIDL

- define interface folder
- create folder then
```
package android.hardware.luxoftio@1.0

interface ILuxIO{
	
	setGPIOState(pin , value) generates(bool success)	
	
	getGPIOState(pin , value) generates(bool value,bool success)
}


```

## generate android.bp
- source
- lunch
- ./update

##generate default directory
- export package and location
- hid;-grn

## implement HAL interfaces

## in java app
1. imp
2. crete object
3. gpioservice = ILuxoft.getService("default)
4. boolean success = gpioService.setGpio(pin , value)

- make an app and button with onclick listner

- from java i access a service its name is hidl 
- so you comm with service manager
- 

## AIDL

- AIDL is a new way android is handling HAL imp
- steps
	- create AIDL file -> describe interface
	- create service app
	- modify service manifest
	- create client app

- adaptive 
	- service oriented
	- app has data in classic socket
	- provider subscriber calls
	- method
	- AIDL has same method
	- service apply app 





## aidl 

- package
- interface + function

- create service app
- greet throws (return "hello world")

- public IBinder onBind(Intent intent){
	return binder ;
}


- modify monifest
- create new permission
- object + service + bind

- stubs are functions are empty and you should implement them 

## aidl native driver example

- steps 
- create aidl
- write HAL driver in c++
- create c++ service
- configure build system
- init script to start service
- create java app

## aidl
- create aidl in
	- frame/aidl/inter/gpio/src/main.aidl/luxfot/gpio
	
- IGPIOService.aidl
- add interface
- paclage com.luxoft.gpio
```
interface IGpioService{
	booleran setGPIO , getGPIO
}

```

## create hal driver file
- GPIO.cpp and GPIOhal.h

```
class GpioHal{
	export , set direction
}



```
- imp of hal over driver

## create service file
- c++ service
- / services
- include needed libs
- define namespace
- implemnt service function
- create main function

```
bngpioservice
gpiohal
bindermanger binder proces

using namespace aidl::com::

```

- // java client app
- c++ service
- c++ hal
- c++ hal talk to hw

```
service speaks to hal
main function

```

## configure build system
- cc_library_shared{
	name : "libgpiohal",
	srcs :
	shared_libs:[liblog]
}


```
cc_binary : a[[{
	name service
	srcs 
	shalred libbinder
}

```
class main
user system
group system
oneshot

```

```
## Vhal -> properties ,
	- you can extends this stack

- service running as rest

- access mode 
	 read , read)write , write
	 
- : change mode
	- on change , static , continous

- minsample rate

## adding  a new custom propety

- id too 
- unique + vehicle + od . property

1. open aildl testvehcleproperty
	- unique

2. json files and add 
	- 

3. framework layer
	- pkg/servies/
	- add you property

- aidl + id + framework


## custom vhals imp

- kitchen sync


 





























