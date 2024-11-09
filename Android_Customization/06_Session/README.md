## agenda

- android native systym services

- create gpio system service lab

- runtime respurce overlays

- apply static and dynamic RROs lab


## android system services

- android native services and low level services that handle core functionalitites as 
	- system init
	- core system services
	- hal support
	- com between various comp
	

- bl init , kernel init , init proces , art , zygote , sys server m system apps and user apps	

- kernel :
	- hw memory dd 

- init process
	- user space init
	- start sys sevices
	- process spawing
	- handling run levels

- load and aot comp -> ahead of time
- rt optimiztion
- mm
- sec


- system server
- init core sys services
- reg , windows manager init , 

## system services examples

- init.rc
- structure
	- global setting : env vars , permis , basic config
	- service def , def of how servuces should be launched and managed
	- actions conditional actions to excute certain commands based on events
	
```
on boot 
export path

- service surface flonge
	- class user
	- capalitirs 
	- priorties	
```
	
## servuce structure in init.rc 
- service 
- class -> grouping of services -> class default
- user and group
- capalities -> netwrok modification in low level (kernel)
- priority
	

## service :
	- defines a new service to be managed by init process
	- service <name> <path_to_excutable>	

## 2. class

- determine the service's grouping for startup and shutdown seq
- common classes : core , main , late_start
	
## 4. capalities
- define priviligaes or cap granted to service
- ex " net admin or sys nive for priority managment

5. priotiy
	

## service classes

- common service class
- core service 
- main : started after core : fintion for most core android
- late_start : these services to prevent interface with crit
	
## service user and group : 
- system : service example_
- user 1 and multiple groups 
- Net+Admin : grants network adminsta 
- systume : a;;ows service tos et s
- sys nive : prioriyt for cpu
- block : ker critical for services req continous operations

## service caplit 

- service netconfig

## priotity 

- I/o pri
- spercidies for inpit
- real time priority rt provides guaranteed access levels
- cpu oriot dedines services priority kevel ,

##  system service life cycle :
1. service definations 
	- service 

2. init and start up
	- on boot
		- start myservice


3. activitions : 
	- on propertyLsys,boot_cimpleted
		- start my service

4. excution :
	- once started enter an active and moniterd by init proces
	- whuch ensures they are functionung property

5. monitering and restart : restart my_service

6. termination L stop my_service


## example
- disabled : manual activition

## test sesrvie 
- adb shell set prop log
- adb shell stop custom loogger

## android init language


## Android runtime resource overlays (RRO)

- modify app resource at runtime without modifying original app code
- valuable auto oem and custom AOSP builds 
- where you need to provide brand specific look and feel cusrimization across devices

- RRo
- allows developers to override default res of an android app or sys comp without modifying apk
- this is particullary useful for customizationin automotive

## key components 
- overlay apks each over us thes 
- overlays manager service
	- runs in sys server manafer acive amd priorty
	
- 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
