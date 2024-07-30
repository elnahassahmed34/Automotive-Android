# init process types

## 1. busybox -> not used (inittab + init.d)


## 2. system v 

### runlevels in embedded linux 
- App mode 
- service center

### init.d
- scripts for init process
- ssh bluetooth gui sh
### /etc/rc<>.d
- soft link to some scripts in init.d

## rc.c 
- run levels


- Introduced the concept of run levels 
- S -> start
0. shutdown
1. secure
2. single user  
3. multi user without GUI 
4. User defined 
5. GUI 
6. reset

### cat inittab
- node :runlevel:action:app
- rcS:12345:wait:/etc/init.d/rcS

### lab
#### add this to inittab
```
rc2:2:wait:/etc/init.d/hello
```
#### add script in init.d
```
#!/bin/ash
echo "hello"
```
#### move to run level 2
init 2

### task 
#### make hello as service 
- use switch case from repo



##### 1- make script in init.d 
- touch deamonapp 
```sh
#! /bin/sh
case "$1" in
      start)
           echo "Starting deamonapp........."
           start-stop-daemon -S -n deamonapp -a /bin/deamonapp &
           ;;
     stop)
           echo "Stopping deamonapp........."
           start-stop-daemon -K -n deamonapp
           ;;
     *)
           echo "Usage: $0 {start|stop}"
           exit 1
esac
exit 0
```
- chmod +x deamonapp
##### 2- make symbolic link in runlevel 2
mkdir rc2.d
```
ln -s /etc/init.d/deamonapp ./etc/rc2.d/S1deamonapp.sh
ln -s /etc/init.d/deamonapp ./etc/rc2.d/K1deamonapp.sh

```

#### add this in inittab
```
rc2:2:wait:/etc/init.d/rc 2
```

##### 4-add this app in /bin/deamonapp
```
#!/bin/sh
while true
     do
         echo "Daemonapp is running!" >> /tmp/daemon.test
         sleep 10
     done
```
- chmod +x deamonapp


###### 5 - add this rc script in init.d 
```sh
#!/bin/sh
# Check if one argument is provided
if [ $# -ne 1 ]; then
    echo "Usage: $0 <runlevel>"
    exit 1
fi
# Define the folder path based on the argument
folder="rc$1.d"
# Kill scripts starting with K
for i in /etc/$folder/K??* ;do
     # Ignore dangling symlinks (if any).
     [ ! -f "$i" ] && continue
     case "$i" in
        *.sh)
            # Source shell script for speed.
            (
                trap - INT QUIT TSTP
                set stop
                . $i
            )
            ;;
        *)
            # No sh extension, so fork subprocess.
            $i stop
            ;;
    esac
done
# Start scripts starting with S
for i in /etc/$folder/S??* ;do
     # Ignore dangling symlinks (if any).
     [ ! -f "$i" ] && continue
     case "$i" in
        *.sh)
            # Source shell script for speed.
            (
                trap - INT QUIT TSTP
                set start
                . $i
            )
            ;;
        *)
            # No sh extension, so fork subprocess.
            $i start
            ;;
    esac
done
```
- init 2

###### 6- create another runlevel to kill the app
mkdir /etc/rc3.d
ln -s /etc/init.d/deamonapp ./etc/rc3.d/K1deamonapp.sh

- add in inittab
rc3:3:wait:/etc/init.d/rc 3

- init 3

