## Android Automotive 

- AOSP Customization training track 

## Objectives

- practical exp in building customizng + deploying AOSP automotice roms

- understand android automotive arch + build systems

- mastel hal and system service dev for integrating 3rd party

- be able to expose system services to android app layer

- Gain knoledge of debuginh testing and ceritfocation

## timeline

- intro to AOSP automotive
- setting up env
- basic android bs and commands

## week 2
- android automotive arch
- car service api framework
- exploring hal for automotive

## week 3
- customizing ssytem services
- hal integration
- customizing android auto framework



## week 4
- native c++ services
- AIDL + IPC
- SELINNUX customization + security


## week 5
- exposing APIs anroid apps 
- building custom android apps into aosp
- debugging

## week 6
- project


## AOSP intro

- android initially developped as os for digital cameras

- then acq by google 2005 + repproduced as smart phones OS

- AOSP is base platform for anrodi devices
	- it includes ths source code for android OS + tool + docs + APIs
	
- Android is based on modified kernel

## AOSP Intro
- android framework
- device manufucture apps
- system API
- HAL -> Hardware abstraction layer
- linux kernle
- Android APO
- Android Apss
- priviliage apps
- system services
- android runtime
- system sevices + daemons

## Hal

- abstraction over kernel
- optimize security

## system service
- every layer spwak to other
- add service in each layer

## framework layer
- offers functionalitites for apps

## apps

- user apps
	- dl by you
- system apps
	- integrated direct with firmware


## android automotive intro

- modify in hirarchy of android

- vechile hal -> not from scratch
	- googel offered this layer
	- has common feuture

- AOSP open soirce initiatice led by foofle

## AOSP signfcance in automotive industry
- customization
- AOSP allows manufuturees and developers to cutomizr android OS to meet specfication of automotice env

- this include integrating aitomotice specifi fayureds +HW + service 
	- infotainment + car diagnostics + navifgation + telematics -> 
		
## AOSP signficance in auto industry

- cist effiency 
- AOSP help automotice OEMS (original equiment manufactures)
	- reduce cost by leveraging a ready made highly scalable OS 
	- rather than developing propritary platforms scratch

- Comunit + ecosystem support
- by using AOSP automotive manufucture can tap into the vast android developer comunity
-which provides continued innovation and support new features , securuty updated + patchs












## AOSP sigina in industru

- integration of android apps
- automotive syste,s based on AOSP can utilize massive ecosystem of android apps
- enabling rich user ecp 
- that go beyond the traditional in car experiance
- such as integrating entertainmant + connectivity + smartphines projectiopn (like android auto)

- Rapid developmnet cycle
- AOSP provides a flexible platform for innovation
- allowing automotive manufuctures to develop features and customization rapidly
- responding to many things

- AOSP provides the perfect foundation of new standart like 
	- ADAS (Advance driver assitant system)
	- v2x (vehicle to everything) communication


## Embedded systems + android automotive

## Relevance to embedded system

- real timpe processing
- meet real time constraints + where actions must occur whtin a strict timeframe 
	- ex brake control system
- never used by linux or android
- another HW or computers
- car will have about 3 computers


- resource constraints
- these systems typically run on hw with limited resources
	- memory processing , power
- compared to general purpose systems like PCs or smarphones



- high reliability + safety
- many embedded systems are used in safety critical apps
	- automotive systems 
	- failure can lead to accidents or malfunctions

## Automotive control
- deals with varios hw comp. as sensors , camers actuatores

- RT req
	-focus on infotanment 

## embedded anroid 
- infotainment + connectivty
- focuses more on infotaimnet services such as
	- multimedia playback
	- internet connectivty
	- integration with mobile devices AOSP's standard service


- custom HW integration
	- highly modular which allowing dev, to integrate custom Hw
	- speedmeters , GPS systems
	- third party sensors + telematics devices



## linux
app -> user space

kernel

hw



#android

- app

- framework -> managers

- lib + art

- hal 

- kernel -> modify -> 

- device driver

- hw




## AOSP arch overview

## linux kernel

- the core which provide the low level managment of 
	- HW resource
	- memory
	- process

- diff between this and linux
### - memory managment as garabage collector
- acts low memory kernel
- but in linux there is out out of memeory kernel
- don't close any proces until its prioruty is low

### process managment + IPC

- linux has sys V
- but for android there is binder for IPC
	- don't rely on sys v
	- change layer
		- change calls procedures

### power managment
- battery managment 
- suspend rule
	- process will be susbended
	- it cause proplems
	- apps will be suspends bu wake locks
	- process call system that don't wake lock
	- there are many layers in wake locks
	- happends in nav system + phone calls


## HAL

- middle layer that bridges the android framewprk with hw drivers
- allowing android to interact with diff devices
- cameras displays sensors



## system services
- core services that manage device functions like
	- power mangment
	- telephone
	- networking

## Android framework

- provides high level APIs for app dev.

- for automotive this includes specialized APIs like car API

- bionic c vs glibc
	- as it is light weight library

- API to hide components nder it
	- speak with under layers

- mainly written in java

- add car API in frame work

- ART are same level with system services

## android run time

- dalviv sustitute

- build over java for apps

- build virtual machine 

- optimization to be android run time


## Android Automotive

- builds on top of AOSP by adding specific components and services
	- vehicle HAL + Car service

	- designed to interface with in car systems
		- like navigation , audio , diagnostics


## Android bs linux

- app kernel hw
- apps windowns manager libs
- pm IPC vfs , mm , network , selinux , DD , driver d module
- arch dependen 
*- [rocesor arch

- java api + mangart
- natice libs
- android run time
- HAL
- kernel

- content provider , view sys
- managers activitu locatio npkg resot window telephony
- webkit , opem max , libc m nedia framework 
- art core libs
- audio bluetooth came sensor
- audio binder , display , keypad , buletoh camer shared memoty , usb wifi
- power managmer


## Steps to add service
- HAL -> driver
- library -> system service
- managers -> frame work -> mainly written in java
- app

## AOSP vs linx arch
- kernel like standark android patch
- for increasing performance
	- process managment optimized with CFS completly fair schedular
	- support with priority managment
	- process has schediler

- lie but android has its patches
	- optimize power manament
	- conserve battery life
	- ensure mobile devices remain effecient while idle

- wake locks
	- allow apps to prevent system from suspedning when they perform critical tasks
	- app control this with OS

- ART instraed of linux user space , android rinti,e
- ART replace JVM and is opetmiafor memory usage

- sys libs android has irs own libs (bionuc libs )

## chal car service , car api customization

## vhal
- hw frame work
- abstracts varios such as sped metes
- allowing android to interact with vehcile specific hw 
- developes can extend vhal by defining new HW interface vehcle properties to android frame work


## car service
- car service runs in the system server and acts as central communication point between and android automotice features
- it manages vechile specific services like navigation climate control telephone and audio
- system server -> manage most 






## setting up the env for AOSP

## practical setup
- seeting up the envronment for AOSP dev
	- critical step to ensuring smooth development experience

- this includes istalling the necessory tools 
	- configure source managment system
	- dl android OSP source code
	- for building android auto roms

- for this guide we will focus on setting up android 14 for rbpo 4 as target device

## install required tools

- AOSP dev req sevral tool and libs to be installed , toolL 

- rbpi vanilla and android 14

- openjdk 17 as of android 14
- install open jdk
	- sudo apt-get update
	
	- sudo apt-fet install openjdk-17-jdk
	- java version

## python
	- build scripts
	- pythin 3

## git
- git is used for version contrlo and cloning repos
- sudo apt- get install git







## repo

- repo is google build tool tgat manages multiple git repos for large prokects like AOSP
- instal repo:
	- mkdire -p ~/bin
	- curl > ~/bin/repo
	- chmod a+x ~/bin/repo
		- add repo to your path by editing .rc or .zhrc
	- export PATH=~/bin:$PATH
	
- configuration ile -> mainfest file
- pythins scripts to control gits repos
- one commit wiil be done parllel

## Additional tools
- instal required pkgs for building AOSP
	- this list may vary dep. on host OS

```sh
sudo apt-get install bc bison build-essentail curl flex g++ multilib gcc multilib git gnupg gperf imagemagick
lib32 lib32ncurses5-dev lib32realine-dev - libsdl1.2-dev libssl openjdk , libxml2-utils zib ,squashsh
```

## install and configure repo tool for source managment
- repo tool is ised to fetch and mange aisp 
- simplifies download

## configure repo
- cra director
- mkdir ~/aosp
- cd ~/aosp

- intializr repo for android 14 :
	- repo init -u url /platfor.mainfest -b android-14.0.0_r1

## 2 downloading source
- use command to sync dl aosp code

- repo sunc -j8
	- j8 flag sets the number used fir dl accirding your cpu

##3 diwnload and setup aosp spirce (and 14 rbpi 4)

- set up aaosp en 
- downlad device 
- git clone lical mainfest

- sync updated repos
- repo sync -j8

- clone repo for android
- then clone fro rbpi mainfest

##  dl and setup aosp siurce
3. setting up build enb
- source build/envsetup.sh
- lunch lineage_rpi4-userdebug

- solution you used
- allow you to be root but release not


## buidlign and flashing automotice rom rbpi4

1. building aosp image
- after en , start building soirce code
- m -j8
- this will take time -> enusre enough space

2. flashing image to rbpi
- out/target.product/rbpi-directory
- steps
- insert sd card
- wrote boot omage
- sudo dd if= of .dec.

## build system fundemtals

- aosp build system customizable and flexible
	- developers configure buld modify diff comp of android system

- understanding basics of build system to work effectivly with aosp


## introduction to soong and make

- make : android traditionallu used make build system
	- makefile to define the rules of copiling source code

- android is transitioning soong 
	- which offers more modern and effently build experience

- soong : this is new build system that android adopted starting from android 8.0 oreo

- it uses cinfig files android.bp written in blueprint
	- devlrative language
	- to define how module are build
	
- 1. Performance and Scalability:
2. Declarative Build System:
3. Modernization and Extensibility:
4. Simplified Build Files:
5. Parallel and Incremental Builds:
6. Cross-Platform Support and Multi-Architecture Builds:
7. Modular Builds:
8. Error Reporting and Debugging:
9. Native and Java Builds Unified:
10. Blueprint Language**:
11. Better Dependency Management:


## soong vs make
- modulat : soong allows for more modular builds to make
- speed : it offers faster incrmental builds by only 
- simple configuration -> android.bp files are simpler and more readable

1. create soong files 


## overview of envsetup , build commands (m , mm , mmm) module managment

- envsetup.sh
	- envsetup make the env

- m : m commands is wrapper the correct build sustem to build all
- mm this command is used specific module and its dep
- mmm this command builds module in directo
	- mmm pkgs/apps/launcherr3


## module managment

- aosp is madeup of various module
	- system services apps hals

- understanding how to manage these modules crucial android
- each module has its own android.bp or anroid.mk
- blueprind by sonng
- you can manage and customie modules by modifing these fules adding new build tagets
	- or removing unnecessary compnents
	
## summary






## basic android build system + commands

## understanding soong makefile ninja

- the android build system is a complex effecient system that compiles the AOPS code into functional IS

- it uses several tool to organize and manage build process

- soong generate ninja files 

## soong
- main build system for android

- it replaces older make file ystem
	- bringing effeciently and modularity to build process

- it uses blue print files android.bp to describe how modules are built

- modules in soong can be libraries apps or comp. of android itself

- soong handles dep. tracking and par. of tasks to optimize the build speed 


## example sample androd.bp

plaintext

java_library{
	name :
	srcs :
	sdk_version
	
}


## make file : traditional , uses makefiles
``

srcfiles 
module
path

``


## Ninja
- low level build that optimize 
- soong generate nibja buld
- ninja -c out/target/product/rpi4

## running debu image in android emulator

- anroid emulator is powerfil tool to test anroid automotive

## steps to tun automotive images

- install android emulator
- use sdk android sdk manager emulator

2. set up automotive virtual device
- select vehcile immage from availble hw to simulate automotive env. like screen size and car sensors

3. running the emulator
- launch the android emulator with automotive image
- emulator -avd automotive_avd_name


4 debugging automotive image
- use logcat and android studio debugging to monitor the behaviour of your andorid aumotive build
- yiy cab ubteracrwutg car api 
- run apps 
- test ui ux interactions similar it woild work with real vehcle


## common debugging 

## ADB
- android debug bridge
- versatile command line tool taht enables communication between computer and android device 
- it is widely used for tasks like apks
- 

## common adb commands
- adb devicesls 
- list all connected devices
- adb devics
- adb install intall apc 
- adb logcat streams system logs
- adb shell : opens remote shell to run commands on device


## fast boot
- fastboot is a tool to flash partitions on android devices
- especially during the boot processs when the device is in fast boot
- it commonly ysed for flashing system images
- recovery , bl , flashing partitions -> boot . root . home , system , build 

- userspace : apps

## common fast boot commands

- fasr boot devices : all device

fastbot flash , boot recovey system usb , system services 
- fast flash boot boot.omf

## lab change boot animation 
- customize boot animation of anroid automotive by replacing it with a new custom anomation































































































































































































































































































































































