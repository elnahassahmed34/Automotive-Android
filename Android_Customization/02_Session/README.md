## labs

- .repo -> mainfest -> defaults.xml

- describe modules which will be dowloaded

- source

- lunch aosp_rpi4)car-ap2a-userdebug

## see in source code your products

- device/brcm/rbpi/
	- there are files where you can find your products
	- aosp_rbpi4_car.mk
		- here you can put the configurations
	
## 3 ways

1. adb
2. from sdb change the /system
3. before the build in aosp

## ADB

- adb --help
- reboot
- root , unroot
- start server

- fastboot
	- flash partitions
	- must be support recovery img

- lsusb : need to know the identifier


## hirarchy

- kernel -> kerne;


- system service -> externals

- HAL -> hardware

- system services :
	- packages
	- HAL

## add modifications on rbpi

- device/rbpi4
- target/board/
- target/product

## diff between board and product

- product for car or tv 
- board : same
- build/target/product/fullbase


## overlays

- produvt_package +=

- device/brcm/iti/iti_epi4_auto.mk
	- overlays
	- prbuilt
	- sepolicy
	- ui
	- iti_rpi4_auto.mk
	
## BUILD_PACKAGE -> for bulding app
	
## search for launcher app



























































