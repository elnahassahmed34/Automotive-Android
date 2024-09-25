# Android Dev. using java

## history of phones
- Dump phone
- feature phone
    - not OS but just small firmware
- smart phone
    - OS + processor

## Challenges
- it should have low power consumption
- it should have low footprint(size in memory)
- it should be reliable and stable
- it should handle memory efficiently


## History of android
- Android is mob OS based on a modified version of linux kernel
- dev .by startup -> acq by google
- dev OS for cameras
- Google announced Open Handset Alliance (OHA)
    - realsed version of Android SDK

## Android features
- free open SQlite
- Coonectivity -> GSM IDEN , CDMA , UMTS , Bluetooth , wifi m WiMax , nfs
- messaging -> SMS , MMS
- Web browser -> open source Webkit + chrom's v8 javaScript engine
- multimedia
- Sensors , Imaging
- Directions + locations
- touch
- multitasking + multithreaded
- OPtimized Graphics


## Android framework Stack
- OS
- middle ware
- key Application


## Dev on android why ?
- simple powerfil SDK -> emulates for mobile
- no licensing fees
- excellent doc
- Thriving developer community


## Android 4.4 kitkat
- runs on entry level
- better memory mang.
- new NFC capalities
- printing framework
- sorage access framework
- low power sensors
- step detector and step counter sensor


## Android 5.0 Lolipop
- Material Design
- android runs exclusivly on the new ART runtime
- notifications
- Android TV
- Advanced connectivity

## Android Marshmallow
- Doze & App standby
- Apache Httop client removal
- Text selection
- Runtime permissions
- USB Type c support


## Android 7.0 Nougat
- Multi-window support
- Notifications enhancement
- Data saver
- Vulkan API
- Quick settings Tile API
- Number blocking


## Android Oreo 8.0
- Pictur in Pic 
- Notification badges
- Autofill framework
- Download fonts
- Autosizing textview


## Android Pie 9.0
- Indoor positiong wifi with rtt
- Display cutout support
- multi camera support
- unified biometric authetication dialog

## Android Q 10
- Support foldable
- Supports 5G
- ML edge
- Security enhancment


## Android 11
- Conversations -> bubbles
- device control -> IOT
- content capture -> current screen
- predictice tools
- media -> play music from other devices

## Android 12
- Introducing material you
- Mic + camera indicators and toggles
- Approximate Location permissions
- privacy Dashboard
- Enhanced Gaming
- Scrolling Screenshots
- EAsily seitch phones

## Arch of android
- App
    - home camera phone browser

- App frame work
    - 
- Android runtime
    - core libs + Dalvik virtual machine
    - Android run time is the engine power apps
    - along with libs forms the baseic app framework
    - 

- Libs
    - written in c or c++
    - surface manager . media framework , Sqlite + openGl , web kit
    - SGL -> fonts
    - ssl -> security
    - libc     
    - NDK -> native dev. kit

- Linux kernel 
    - diplay . binder , wifi Audio


## ART on kitkat
- android runtime 4.4 release
- this preview of work 
- this is available for the purpose of obtaingn warly dev . and 

## ART vs DVM
- DVM -> just in time which results in lower storage consumption but longer app load time
- ART -> AOT -> ahead of time -> which compiles apps when the are installed , eresulting in faster load times and lower process usage

- DVM -> works better for lower internal storage devices as


## App framework
- full acees to same framework APIs 
- app arch, to simpiy reuse
- Activity mangaer . window , content provider , view system , package manager , telephony , resource , location , Notification
- package manager : object creation of any apps building blocks
- Telephony manager 
- Resource manager -> manage all resources non code -> images videos

## develop android
- Actitiviy : UI compnents specially for one screen
    - top level container
    - javafx -> scene
    - swing -> jframe


- Broadcast Reciever (Intent Reciever) : Responds to notifications or status changes that can wake up ur process
    - watch status of battery and network and others 

- service : faceless task can run in background
    - like actitvity but no UI
    - example sound cloud or google play
        - install -> manager install it

- content provider : Access data of another app or to avail data from my app
- the four compnonts works on main thread

- you don;t crate any object of them -> created by package manager

## Activity
- Represent a single screen with user interface
- an app can have zero or more activities
- when new actitivity starts it is pushed into back stack and takes user focus
- the back stack abides to basic (LIFO) queue mechanism
    - so when the user is done with the current activity and presses the back key
    - it is poped from the stack and destoryed
    - and the previous activity resumes

### creating actitivty
- to create -> must create subclass activity 
- public class HelloAndroid Activity extends AppCompatActivit
- implement clalback methods that the system calss when the activity transistions between various states and its life cycle
- such as when the activity is being created stopped resumed or destoryed
- all callbacks are overriden but not called 
    - the activity manager is whom resposible to call

### Activity life cycle 
- Activity start
- Oncreate
    - build tje UI in this
- Onstart
    - initilize the objects
    - prepared to start
- onResume
    - the avtivity is showed and running on from of user
- Onpause
    - prepring to disappear
- onstop
    - disapperd but object is still alive
- on destroy
    - object is destoryed
- Activity stops

### Scenrio one
- click on icon to show activity
- create , start , resume
- back button -> puase , stop , destroy
- from anroid 12 . on destroy will not always be called on the launcher Activity upon pressing back button


### Scenrio Two
- vreate start resume
- button to activity two
- create start resume for activity two
- activity one pause stop
- back button -> two : pause 
- activity one -> on restart -> activity comes to foreground -> start resume
- activity one -> stop destroy


### Scenrio 3
- Activity portrait and activity landscape
- configuration change -> orientation or localiztion
- pause stop destroy then create start resume

### Scenrio 4
- Activited activity
- dialogue from another app
- activity to on pause then when dialogue then activity to resume

## Scenrio 5
- lock screen
- pause stop
- then start resume

## Scenrio 6
- if there is no memory
- kill activity in stop
- then moved to oncreate -> but saved status
- method called on save instance state (Bundle outState)
    - this is callback method after stop
    - bundle is package -> data saved in it as key value states
    - android saves changes for user in this bundle
- then android load the bundle again


## 

