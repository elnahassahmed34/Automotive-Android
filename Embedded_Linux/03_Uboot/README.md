# system call

![Alt text](https://www.linuxbnb.net/wp-content/uploads/2018/06/system-call-overview-1.png)


- user app -> write -> glibc -> assembly code {write r7 =system call id , arguments r0 r1 r2 }

- kernel app -> read registers -> excute the id -> write

- follow these topics 
	- https://chromium.googlesource.com/chromiumos/docs/+/master/constants/syscalls.md
	- https://www.linuxbnb.net/home/adding-a-system-call-to-linux-arm-architecture/


- every system call has an ID

- **is system call and API(function called in application) ?**
	- no it is considered as IPC(inter process communication)
	- communication between user app and kernel


# booting sequence (bootstrap)

## In bare metal
1. init sp
2. reset handler
3. start up 
	- vector table
	- bss , data
	- init HW
	- call main

4. main 



## x86

1. **BL1 boot rom**(code from chip vendor) <- CPU -> SRAM
	- init sp
	- reset handler (ISR function) 0x00
	- init HW
		- clock
		- init DDRAM
		- Call BIOS

2. **BL2 BIOS** (DDRAM)
	- init HW I/O as screen and keyboard
	- storage device to boot

- every storage (SD card) has header that contains
	- partition MBR
	- bootable partition (ex : p2)
	- p2 : grub

3. **BL3 GRUB**
	- init HW
	- load kernel

4. **kernel**
	- mount rfs
	- init static modules
	- call init process
	- init dynamic modules
	- call shell


## RbPI

1. **BL1 boot rom**(code from chip vendor) <- GPU -> SRAM
	- init sp
	- reset handler (ISR function) 0x00
	- init HW
		- clock
		- init DDRAM
		- Call bootcode.bin (closed source) 

2. **bootcode.bin** (DDRAM)
	- call start.elf (closed source) so it gives config.txt
	- start.elf init cpu
	- search for config.txt (kernel = zimage) 
	

3. **BL3 Uboot**
	- init HW
	- load kernel

4. **kernel**
	- mount rfs
	- init static modules
	- call init process
	- init dynamic modules
	- call shell


## mount
- block storage
	- RAM , HDD , SSD , SD

- sd card -> raw memory (Zeus)

### file system (Algorithm)
- types : ntfs , ext4 (linked list) , fat
- how to store + how to retrieve data

- sd card :
	- partition table -> found addr in MBR
	- Header : 3 partitions
	- fat : ext4

## kernel -> VFS
- when dedicting SD card , kernel will mount it under VFS
- kernel has header like ext4.h and fat32 , so that it can understand partitions 
	- ex : mount /dev/mmcblockp1 /mnt/sdcard
	- so mount command ordered kernel to mount sdcard under this directory


## format
1. soft format -> delete partition -> can be recovered
2. hard format -> put zeros(^@) in each address 


## Emulator (QEMU) vs Simulator (Proteus)
- Simulator -> Just SW app doesn't take from processor
- Emulator  -> emulates the resources of the device 

## QEMU
- sudo apt install qemu-system-arm
- qemu-system-arm -M vexpress-a9 -sd .img

## Emulating SD card
- touch sd.img
- dd if=/dev/zero of=sd.img bs=1M count=1024
- cfdisk sd.img
- loop device -> make file as block storage
	- losetup -f --show--partscan sd.img
		- f = find  ,  show : which loop used , partscan : mount header of storage 

```sh
touch sd.img
dd if=/dev/zero of=sd.img bs=1M count=1024
cfdisk sd.img
	#choose dos , primary , bootable , type : FAT16 , write
	#New  primary   , type : Linux , write

sudo losetup -f --show --partscan sd.img

sudo mkfs.vfat -F 16 -n boot /dev/loop40p1
sudo mkfs.ext4  -L rootfs /dev/loop40p2

sudo mount /dev/loop40p1 sdcard/
sudo mount /dev/loop40p2 sdcard/

sudo umount /dev/loop40p1 
sudo umount /dev/loop40p2 
sudo losetup -d /dev/loop40 # -d deattached

```
