# RbPi

## Booting seq of Rbpi

1. Boot Rom -> 1st BL : Searches for bootcode.bin
2. bootcode will search for start.elf
3. start.elf searches for three files 
    - fixup.dat
    - config.txt
    - cmdline.txt

### 1 through disk application
- make boot 500 mb fat32
- make rootfs the rest ext4
 sudo mount /media/nahass/sdcard/boot/    /dev/mmcblk0p1
 sudo mount /media/nahass/sdcard/rootfs/  /dev/mmcblk0p2


### 2 make these files
- sudo touch config.txt
- sudo touch cmdline.txt

## 3 install toolchain
- sudo apt install gcc-arm-linux-gnueabi

## 4 build the uboot
- export ARCH=arm
- export CROSS_COMPILE=arm-linux-gnueabi-
- ls -l configs/ | grep rpi
- make rpi_3_32b_defconfig
- make -j4

## 5 edit config.txt and add
```
kernel=u-boot.bin
enable_uart=1
device_tree=bcm2837-rpi-3-b-plus.dtb
```
## 6 edit cmdline.txt and add
```
console=serial0 
```
## 7 connect tty
```
sudo picocom -b 115200 /dev/ttyUSB0
```
## 8 ping
```
ping 192.168.1.50 
# from qemu ping through ethernet periphral
```
## 9 lab
```
echo $kernel_addr_r 
ls mmc 0:1 
fatload mmc 0:1 $kernel_addr_r zImage.txt
md $kernel_addr_r  

```

