# Uboot

## Flashing types

### 1 Flashing through physical memory
- fatload mmc 0:1 addr 

### 2 Flashing through server
1. install this pkg
```
sudo apt install tftpd-hpa

# reload
systemctl daemon-reload

# see what was installed
dpkg -L tftp-hpa

# see the port 69
netstat -tupl
```

2. there will be new user under /etc/passwd called tftp
```
cat /etc/passwd | grep tftp
tftp:x:130:139:tftp daemon,,,:/srv/tftp:/usr/sbin/nologin
# this is a system user with no login capaility
```

3. change in tftp config /etc/default/tftpd-hpa
sudo vim /etc/default/tftpd-hpa
```
# /etc/default/tftpd-hpa

TFTP_USERNAME="tftp"
TFTP_DIRECTORY="/srv/tftp"
TFTP_ADDRESS=":69"
TFTP_OPTIONS="--secure --create"
# add create so that it can run script under /etc/init.d
```

4. check for the status of the tftp daemon
```
systemctl status tftpd-hpa.service
```

5. change own 
```
sudo chown tftp:tftp /srv/tftp/
```

6. set server ip to the ip of your machine
```
setenv serverip 192.168.1.50
```

## bootflow scan command
- search EFI system partition (fat16 bootable + primary) for extlinux/extlinux.conf -> replace bootcmd=bootflowscan

``` 
LABEL myextconf
    KERNEL ../zImage # it will find it in /boot
    FDT ../my.dtb
```

## task
- can we load zImage by extlinux throgh tftp by uboot ?
