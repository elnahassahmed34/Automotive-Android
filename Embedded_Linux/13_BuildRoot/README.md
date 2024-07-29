# Build roo

## 1- clone repo or download it as ZIP file
git clone https://github.com/buildroot/buildroot.git

## 2 - choose target

### - we will start with qemu 
- make qemu_arm_vexpress_defconfig

### or build for rbpi
make raspberrypi3_defconfig



## 3- edit configruations
- search for dropbear
- from system config. -> set root password (1234)
- search for init -> choose system v


## 4- build 
- make -j4

## 5- start qemu
qemu-system-arm -M vexpress-a9 -m 128M -sd output/image/sdcard.img -kernel output/image/u-boot.img -nograhic

## if you choose rbpi 3
### format
dd if=/dev/zero of=/dev/mmcblk0 bs=1M
### copy image
dd if=output/images/sdcard.img of=/dev/mmcblk0 bs=1M


