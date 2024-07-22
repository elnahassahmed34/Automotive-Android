# Busy Box

## kernel Panic
- because it couldn't found Rootfs
- we will put it in ext4 -> p2

## bootargs variable Uboot
- we will put info for kernel
- ex -> rbpi : root=/dev/mmcblk0p2
-            : console=/dev/tty0
-    -> qemu : console=/dev/ttyAMA0  
- kernel will automatic do : mount -t /dev/mmcblock0p2 / , rw

## example 
vim main.c
```c
#include <stdio.h>

int main(){

	printf("hello nahass");
}
```

```sh
arm-cortexa9_neon-linux-musleabihf-gcc -static main.c 
file a.out 
mv a.out init
sudo cp init ~/source/sdcard/rootfs/
```

```
setenv bootargs "console=tty0 console=ttyAMA0,38400n8 root=/dev/mmcblk0p2 rw init=init" 
```

- you can add in extlinux 
```
    APPEND root=/dev/mmcblk0p2 rw init=init
```

## busy box
- manually you can clone every source code for commands (ls , chmod , ..)
- but busy box give you ability to compile all of them in one step 
### steps
```
clone repo
make menuconfig
compile -> make
make install
```
- then we will make a script to define the PATH and mount some filesystems (dev , proc and sys)
```
export PATH=/binL/sbin
mount -t devtmpfs   /dev 
mount -t sysfs      /sys 
mount -t procfs     /proc 
```

## diff between /sys and /dev 

Key Differences
### Purpose:

- /dev: Provides a way to access and interact with hardware devices.
- /sys: Provides a structured view of the kernel's device and driver model, exposing attributes and allowing for configuration.

### Content:
- /dev: Contains device files that act as interfaces to hardware devices.
- /sys: Contains directories and files representing the kernel's view of devices, drivers, and subsystems.

### Usage:
- /dev: Used by applications to read from and write to devices.
- /sys: Used to query and configure kernel parameters and device settings.

### Creation and Management:
- /dev: Managed by the udev system and created dynamically.
- /sys: Managed by the kernel and created dynamically to reflect the current state of the system.


## /etc/inittab
```
node: :action : app to run
```
types of action 
- sysinit 0x01 app to run first
- wait    0x02 wait for comletion
- once -> run app + don;t wait for completion
- respawn
- Askfirst
- ctraltdel
- Shutdown

## ubuntu mount these FS by a service
```
 2023  systemctl cat systemd-remount-fs.service
 2024  cat /lib/systemd/systemd-remount-fs
 2025  strings /lib/systemd/systemd-remount-f
```


## menuconfig
```
git clone https://github.com/mirror/busybox.git
make menuconfig
# from settings choose -> Build static binary (no shared libs)

#there will be error so make this
sudo gedit .config -> search for this paramater
CONFIG_TC=n

make install

sudo cp busybox /home/nahass/source/sdcard/rootfs

sudo ln -s busybox init
sudo ln -s busybox sh

setenv bootargs "console=tty0 console=ttyAMA0,38400n8 root=/dev/mmcblk0p2 rw init=sh" 


```
