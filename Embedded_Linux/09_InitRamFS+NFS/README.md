# Intermediate Ram file system
we will compress rootfs into cpio image and put it under /boot

## ADV :
1. excution process faster from ram
2. flash from two banks (chroot)
3. security
4. recovery


```
cd ~/rootfs
find . | cpio -H newc -ov --owner root:root > ../initramfs.cpio
cd ..
gzip initramfs.cpio
mkimage -A arm -O linux -T ramdisk -d initramfs.cpio.gz uRamdisk
```

```
setenv initramfs_addr 0x62000000

fatload mmc 0:1 $kernel_addr_r zImage
fatload mmc 0:1 $fdt_addr_r vexpress-v2p-ca9.dtb
fatload mmc 0:1 $initramfs_addr uRamdisk
setenv bootargs console=ttyAMA0,115200 rdinit=/bin/sh

bootz $kernel_addr_r $initramfs_addr $fdt_addr_r
```
```sh
mount -t ext4 /dev/mmcblk0p2 /mnt/
ls /mnt
chroot /mnt/
```

### initramfs for rbpi
- bdinfo
- 0x30000000
```
setenv initramfs_addr 0x30000000

fatload mmc 0:1 $kernel_addr_r zImage
fatload mmc 0:1 $fdt_addr_r vexpress-v2p-ca9.dtb
fatload mmc 0:1 $initramfs_addr uRamdisk
setenv bootargs 8250.nr_uarts=1 console=ttyS0,115200 rdinit=/bin/sh

bootz $kernel_addr_r $initramfs_addr $fdt_addr_r
```


# Network file system
```sh
sudo apt install nfs-kernel-server
sudo cp -r ~/source/rootfs/ /srv/nfs/
```
vim /etc/exports
```
/srv/nfs/rootfs 192.168.1.10(rw,no_root_squash,no_subtree_check)
sudo exportfs -r
```
```
setenv bootargs console=ttyXXX root=/dev/nfs ip=192.168.1.40:::::eth0 nfsroot=192.168.1.50:/srv/nfs/rootfs,nfsvers=3,tcp rw init=/sbin/init
```