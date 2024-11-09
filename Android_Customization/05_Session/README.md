## gradle to soong


```
android_app{
	name:"testApp",
	srcs :[
		"src/**/*.java",
		"src/**/*.kt",
	],
	
	resource_dirs:[
		
	]

	aaptflags -> android asset packaging tool
	jni_labs -> java native interface
	
	static_libs:[
	],
	
	sdk_version:"",
	min_sdk_version:"",
	target_sdk_version:"",
	visibilty:[
		"package_name:public"
	],
	device_specific: true,
	vendor = true ,
}

```
- odm -> device -> product 

Original Design Manufacturer

original equipment manufacturer



- files group
	- generic file
	
	
- path : packages/**/*.bp

- android_library : if you need to build one -> out is android archive
- android_library_import :

## agenda

- linux run shell scripts (init scripts)

- integrate java app with aosp

- integrate native c/c++ lib

## init.rc

- used for config. system services and comp

- events , 
		
		
- triggers , 
	
	
- actions
	- shell comands	
	
- condition or system state change

- trigger 
	- identifier associated with specific evens 
	-on boots

- actions 
	-starting daemon , setting property , 

- boot , early init late init init 
- fs , post fs post fs data
- proerty change
- service start stop
- device added and removed
- firmware loaded
- charger


## boot

- trigged once system comp the initial boot-up


1. early init 
	- basic env and config

- init : runs right after early init setting up core system comp

- early fs 
	- handluing mounting of critical fs 

- fs : /systempost

- postfsdata
	- used for config setting and permision
	
- late init
	- run after core init and fs mounting are comp
	- often inc starting services and comp init setup

- boot :
	- triggerd to finilize sys boot
	- starts essential system and user facing

- late-fs
	- runs after services have started , finizlizing fs 

- property servies
	- runs in response to propert changes 
	- which trigger addition config or stat stop methid
	
## boot
- triggered 

- on property : <property_name>=value



- device added and device removed

- servie start stop
- triggered whenn a named service starts or stops
- allows actions to depend on status of ther services

## custom triggers

- include rc files in vendor etc init

- device.mk -> rbi4
- init -> /etc/init/hw/init

- ramdisk : 
- init.rc
- fstab -
- ueventd -> udev
- fstab :

- system / core / root / rootdir / init


## define a custom .rc fille

- custom boot trigger for product

- on boot start my custom servece
- setprop my product setting true

- you can deine custom trigger by asso them with unique cond as hw states spe services or sys prop

- custom trigger based on a property vhange

-  use property to 

- define product specific services and condition

3. create custom
- on device added /dev/mycustom device
	- start device specific

- define prodice


service my custom serivce
class custom
user system
group system

5. use custom event fkafs
- for devices with muktioe cinfi

6. 
	1. build and deploy intrgrate android bs 
	- include auto with you devuce
	- dtest
	- devvufing use adb shell to set propetires manually
	- setprop

- adb shell
- 











































































