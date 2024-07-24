# Linux Kernel

## zImage
- compilation source code linux kernel

## DTB -> Device Tree Blob
- Description HW connection outside CPU
- it makes  kernel not depend on ARCH or periphrals

```sh
git clone --depth=1 git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git

make ARCH=arm vexpress_defconfig

make ARCH=arm kernelversion

make menuconfig
# configs
#Enable devtmpfs // enable all points for tmpfs
#Change kernel compression to XZ //search for XZ
export CROSS_COMPILE=arm-cortexa9_neon-linux-musleabihf- 
export ARCH=arm

make -j4 zImage modules dtbs

output : arch/arm/boot

```
## boot from mmc
- copy zImage and vexpress-v2p-ca9.dtb to boot partition then 
```
fatload mmc 0:1 $kernel_addr_r zImage
fatload mmc 0:1 $fdt_addr_r vexpress-v2p-ca9.dtb
bootz $kernel_addr_r - $fdt_addr_r
```

#### if you want to boot by extlinux
```sh
mkdir extlinux
touch extlinux.conf
```
- put this content
```
LABEL myextconf
    KERNEL ../zImage
    FDT ../vexpress-v2p-ca9.dtb
```
then from uboot
```
bootflow scan
```


## rbpi 3B+ kernel
```
git clone --depth=1 https://github.com/raspberrypi/linux

export CROSS_COMPILE=arm-linux-gnueabihf-
export ARCH=arm

make bcm2835_defconfig

make -j4

```

## booting from tftp
```sh
tftp $kernel_addr_r zImage

tftp $fdt_addr_r vexpress-v2p-ca9.dtb

md $kernel_addr_r

md $fdt_addr_r

bootz $kernel_addr_r - $fdt_addr_r

```