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

### if you want to ping
- ip addr add 192.168.1.9/24 dev eth0
- copy script which we created in uboot qemu-ifup
- edit in start-qemu.sh to open tab
    - exec qemu-system-arm -M vexpress-a9 -smp 1 -m 256 -kernel zImage -dtb vexpress-v2p-ca9.dtb -drive file=rootfs.ext2,if=sd,format=raw -append "console=ttyAMA0,115200 rootwait root=/dev/mmcblk0"  -net tap,script=./qemu-ifup -net nic  ${EXTRA_ARGS} "$@"




## rbpi
- build init for system d
- for rbpi -> from filesystem images -> change exact size to 250M
- choose uboot -> add in defconfig rpi_3_32b_defconfig
    - error just add rpi_3_32b and the buildroot will add _defconfig


## 4- build 
- make -j4

## 5- start qemu
- run script from output/images/start-qemu.sh

## if you choose rbpi 3
### format
sudo dd if=/dev/zero of=/dev/mmcblk0 bs=1M
### copy image
sudo dd if=output/images/sdcard.img of=/dev/mmcblk0 bs=1M

### try to ping
ip addr add 192.168.1.40/24 dev eth0
ifconfig eth0 up

chmod 600 ~/.ssh/known_hosts

umount /dev/pts
mount devpts /dev/pts -t devpts

#### from your com.
sudo ip a add 10.0.2.14/24 dev enp2s0
ssh root@192.168.1.40



