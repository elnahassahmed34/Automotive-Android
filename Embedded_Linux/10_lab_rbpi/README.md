# lab

## fetch kernel + dtb by ftpt 
```
sudo cp zImage /srv/tftp/
sudo cp bcm2837-rpi-3-b-plus.dtb /srv/tftp/
```
```
setenv serverip 192.168.1.50 
setenv ipaddr 192.168.1.40
ping 192.168.1.50 
tftp $kernel_addr_r zImage 
tftp $fdt_addr_r bcm2837-rpi-3-b-plus.dtb
```

## rootfs through nfs
```
setenv bootargs console=serial0,115200 console=ttyS0 root=/dev/nfs ip=192.168.1.40:::::eth0 nfsroot=192.168.1.50:/srv/nfs/rootfs,nfsvers=3,tcp rw init=/sbin/init

bootz $kernel_addr_r - $fdt_addr_r 
```

### many errors we tried to put this in cmdline.txt + delete bootargs
```
console=serial0,115200 console=ttyS0 root=/dev/mmcblk0p2 rootfstype=ext4 rw rootdelay=5 elevator=deadline fsck.repair=yes rootwait
```

- it didn't work 

### another soluetion to put this inside bootargs 
```
setenv bootargs 8250.nr_uarts=1 console=ttyS0,115200 root=/dev/mmcblk0p2  rw init=/sbin/init
```

this is for qemu
```
bootargs=console=tty0 console=ttyAMA0,38400n8 root=/dev/mmcblk0p2 rw init=/sbin/init
```

### changed plan to boot from rbpi mmc through bootflow scan

- found this error 
```
Waiting for root device /dev/mmcblk0p2...
platform 3f202000.mmc: deferred probe pending
```

- add this in etc/init.d/rcS
```
# mount a filesystem of type `devtmpfs` to /dev
mount -t devtmpfs nodev /dev
```
- another error but it detected the mmc 
```
[    3.206620] Waiting for root device /dev/mmcblk0p2...
[    3.208042] mmc0: new high speed SDIO card at address 0001
[   13.273526] platform 3f202000.mmc: deferred probe pending
```


build 2709bcm_defconfig

cp arch/arm/boot/zImage /media/moatasem/rpi_boot
sudo cp arch/arm/boot/dts/broadcom/bcm2710-rpi-3-b.dtb /media/nahass/boot
