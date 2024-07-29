# init process types

## 1. busybox -> not used (inittab + init.d)

## 2. system v 
- Introduced the concept of run levels 
1. secure
5. multi user network with GUI 

### runlevels in embedded linux 
- App mode 
- service center

### init.d
- scripts for init process
- ssh bluetooth gui sh
### /etc/rc<>.d
- soft link to some scripts in init.d

## rc.c 
- run levels


## 3. system d
- consists of units
    - service  
    - socket
    - mount

