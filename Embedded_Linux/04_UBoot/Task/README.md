# Task 

## Desc.
    - try load from tftp 
    - if not load from mmc

## 1- make a uboot script
```
setenv ipaddr 192.168.1.9
setenv serverip 192.168.1.8

setenv LOAD_SUCCESS "false"

setenv LOAD_FROM_SERVER 'echo "Loading from Server.."; if tftp $kernel_addr_r zImage; then echo "Loading from Server is DONE!"; md $kernel_addr_r ; setenv LOAD_SUCCESS "true" ; else echo "Failed to load from Server!"; fi'

setenv LOAD_FROM_FAT 'echo "Loading from FAT.."; if "$LOAD_SUCCESS" != "true"; then if mmc dev; then if fatload mmc 0:1 $kernel_addr_r zImage; then echo "Loading from FAT is DONE!"; md $kernel_addr_r ; else echo "Failed to load from FAT"; setenv LOAD_SUCCESS "true"; fi; else echo "mmc device not found"; fi; else echo "Error: Already Loaded from Server"; fi'

run LOAD_FROM_SERVER

run LOAD_FROM_FAT
```


## 2- Convert script into binary so taht it can be loaded in DRAM
```
sudo mkimage -A arm -T script -C none -a 0x60100000 -e 0x60000000 -n 'ubootScript' -d /home/nahass/source/ubootScript /media/nahass/boot/ubootScript
```


## 3- Change bootcmd to load this binary

```sh
make menuconfig
#put this value in bootcmd variable so that it can load the script:
bootcmd= load mmc 0:1 0x6010000 ubootScript; source 0x6010000

#then boot your qemu
sudo qemu-system-arm -M vexpress-a9 -m 128M -nographic \
-kernel u-boot \
-sd /home/nahass/source/sd.img \
-net tap,script=./qemu-ifup -net nic

```


