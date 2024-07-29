# Build roo

## 1- clone repo or download it as ZIP file
git clone https://github.com/buildroot/buildroot.git

## 2 - choose target

### - we will start with qemu 
- make qemu_arm_vexpress_defconfig

### or build for rbpi
make raspberrypi3_defconfig



## 3- edit configruations -> make menuconfig
### qemu
- search for dropbear
- from system config. -> set root password (1234)
- search for init -> choose system v

### rbpi
- build init for system d
- for rbpi -> from filesystem images -> change exact size to 250M
- choose uboot -> add in defconfig rpi_3_32b_defconfig


## 4- build 
- make -j4

## 5- start qemu
- run script from output/images/start-qemu.sh

## if you choose rbpi 3
### format
dd if=/dev/zero of=/dev/mmcblk0 bs=1M
### copy image
dd if=output/images/sdcard.img of=/dev/mmcblk0 bs=1M


