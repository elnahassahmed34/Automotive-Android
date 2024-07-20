# U-Boot (Unified Bootloader)

## Properties
- Support many boards (Unified)
- CLI (command line interface)
- small in size (In compare to grub)

## Partitions 
- P1 FAT (boot)
    - U-Boot
    - Kernel + config.txt
    - bootcode.bin
    - start .elf
- p2 ext-4 (rootfs) 

- Uboot -> Compatibel -> board
-       -> compiler   -> CPU

- clone the repo
```sh
git clone https://github.com/u-boot/u-boot.git
```

```sh
make menuconfig

#board config
#commands
#Network (load from network)
```   


```sh
ls -l configs/vex*

copy vexpress_ca9x4_defconfig

make vexpress_ca9x4_defconfig

cat Makefile | grep CROSS 

#we use export because make will open new processes
export CROSS_COMPILE=arm-cortexa9_neon-linux-musleabihf- 
export ARCH=arm

make -j4

# run from source directory
qemu-system-arm -M vexpress-a9 -m 128M -nographic -kernel u-boot/u-boot -sd /home/nahass/source/sd.img

# -M specify the machine
# -nographic : specify that qemu need no graphics
# -kernel : specify the image
# -sd : specify the non-volatile  

```
## ENvironmet variable + commands
- bd info -> board information : DRAM , ip , Eth
- mmc dev -> check mmc card
- echo -> print variable
- printenv -> print variables

## Variables will be like scripts 
- run -> variable command
- setenv -> create new variable
    - ex : setenv myname "echo Hi; echo Nahass;"

    - ex1 : 
        - setenv myvar "if mmc dev; then echo sdcard exist;"
    - ex2 :  
        - setenv var = 1
        - setenv var = 1
        - setenv myvar "if test ${var} = ${xar}; then echo equal ; else echo no; fi;"
            - put them in ${} and leave spaces

- printenv bootcmd -> Autoboot
```
=> printenv bootcmd
bootcmd=run distro_bootcmd; run bootflash

=> printenv distro_bootcmd
distro_bootcmd=for target in ${boot_targets}; do run bootcmd_${target}; done
    => printenv boot_targets
    boot_targets=mmc1 mmc0 pxe dhcp 
        => printenv bootcmd_mmc0
        bootcmd_mmc0=devnum=0; run mmc_boot

=> printenv bootflash     
bootflash=run flashargs; cp ${ramdisk_addr} ${ramdisk_addr_r} ${maxramdisk}; bootm ${kernel_addr} ${ramdisk_addr_r}
    => printenv flashargs
    flashargs=setenv bootargs root=${root} console=${console} mem=${dram} mtdparts=${mtd}       mmci.fmax=190000 devtmpfs.mount=0  vmalloc=256M

```

- for loop
```
setenv myvar2 1 2 3 4
for i in ${myvar2} ; do echo ${i} ; done ;
```

- before making saveenv
    - go to make menuconfig
    - make it FAT
    - device + partition : 0:1
    - it will create uboot.env in FAT where it will save
    - unmount then mount then sync


- change boot delay
```
printenv bootdelay 
setenv bootdelay 5
saveenv
```

- load file in ram from sd card
    - bd info
    - DRAM bank   = 0x00000001
    - -> start    = 0x60000000
    - md 0x60000000
    - fatload mmc 0:1 0x60000000 zimage 
    - md 0x60000000

- similary we will put kernel , dtb and initramfs
    - fdt_addr_r + kernel_addr_r
    - they put fdt before kernel addr 
        - kernel need dtb
        - kernel is dynamiclly change but dtb is static


- help command show all commands


- virtual network interface 
    - it is created by x86 kernel
    - it is called Tap interface in x86
    - in qemu it is called -net

- Create a script qemu-ifup in uboot
```
#!/bin/sh
ip a add 192.168.1.8/24 dev $1
ip link set $1 up    
```

```
sudo qemu-system-arm -M vexpress-a9 -m 128M -nographic \
-kernel u-boot \
-sd /home/nahass/source/sd.img \
-net tap,script=./qemu-ifup -net nic
```

- load from tftp (triveal file transfer protocol)
    - it uses port 69
    - setenv ipaddr 192.168.1.9
    - Set the server ip address that we get from previous step
    - setenv serverip 192.168.1.8
    - ping 192.168.1.8 //from qemu

- task 
    - touch myboot
    - txt file uboot command
    - run -> script fat
    - mkimg for this task and source
    - script : load zimage sdcard (if)
        - elseif check communication server -> load from server
            - else no options
    - checking as for loop


