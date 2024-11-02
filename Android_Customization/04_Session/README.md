## Android customization

## syste, 

- ;ocatopm pf core android comp

- the system

## device
- config for specific devices
- device/brcm/rpi4
- inc bl ,device , drivers , kernel specific config

## vendor
- vendor specifif custpm
- device firmware 

## frame wokr
- exposed locaion media automa

## hw 
## hal 
- hal interface defination , it includes varios hw comp
- automotice vehile hal
- are critical here for managing hw like vehcole


## ysteme partions

- hosts the android
- kernel , system libs , system apps
- reads only with updates handled throigh OTA
- updates or flshing
- system services too

## vendor partion 
- contains device specific customiztion
- carrier req
- OEM feature
- and SOC optimization
- may be read only pr read write

## Product 
- introduced in 10 to organize the customiztion diff berween devices and same soc
- contains device specific customization
- OEM specicfic features
- device specific configuration

## Recovery partiotion

- bl bootrom , sec bl
- this partition is booted during OTA 

## other partitions

- cache
- misc
- userdata
- odm original design manufuture

- https://source.android.com/docs/core/architecture/partitions


## Android boot process

- boot rom

- bl1 if not -> recovery

- bl2 -> kernel

- kernel -> core process -> init proces -> system services

- init process -> discover hw + daemons
		-> then zygote -> ART or dalvik
		-> zygote -> service server
		-> then launch apps
	
- bootrom L init hw

- primary -> kerbek + init hw

- bl2 then dtb

- kernel -> kernel

- init proces 

- art -> manages apps excution and memory managment

## power on

- SOC noot up

- bootrom excure

- init hw


## primary boot

- loader init the dev hw

- sec bl
- recodey mode

## DTB

- bl loads dtb
- desctive dev hw

- dtb to descrive

## kernel boot

- passes to androd kernel
- mpints root fs and starts the init process

## Init process
## Zyfgore
- adds vehicle service -> ensuring hw needed to interact with the vehcol's

- system server has services inside it

- automotive add some services to be started

## init -> zygote -> services + apps

- ps -ef

## we will see soong + init.rc

##
- device/brcm/rpi4/ramdisk
	- fstab , init.rpi44.rc
	- .usb , uevend.rbpi4
	
- system/core/rootdir/init.rc

## lab

- config on soong -> animation

- change prebuild to soong

- how to get remote libs to soong


##
- certificates
- configuartion
- remote dependencies
- privilge



































