# yocto principles


## Licence
- LICENSE = "CLOSED"
- LICENSE_FILES_CHECKSUM
- md5 MIT , meta/files/common-license/MIT
- /home/nahass/source/poky/meta/files/common-licenses
- md5sum MIT

## schema
- file locaol -> machine 
- githup -> ssh , https
- http server -> wget

## SRC_URI
- clone file -> DL
- SRC_URI = "git://[link] , protocol=https,branch=main"
- SRC_URI = "file://main.c

## SRC_REV -> "commit hash"
- every githup commit has its hash

## there is another local variables hidden in each recipe
- PV -> package version
- PR -> package realease
- PN -> package name

- myrecipe_2.0_r3.bb -> PN_PV_PR.bb

- DL -> dwnload -> global
## other local
- WORKDIR -> top dirctory : where following are located
- S  -> unpack source directory
- D  -> destination directory used by pkg -> in image
- B  -> build folder (compile)

## How to know the value of local var
- bitbake -e recipe | grep ^S
    - bitbake : 
        - recipes as input
        - hidden vars
        - python commands



## build/tmp/expand
## ~/source/poky/build/tmp/work/core2-64-poky-linux/google/0.1-r0/git

- bitbake -e google > expand
- bitbake -c cleanall google

## FILEPATH:append

1. - B = ~/source/poky/build/tmp/work/core2-64-poky-linux/google/0.1-r0/google-0.1

2. - D -> image 
- ~/source/poky/build/tmp/work/core2-64-poky-linux/google/0.1-r0/image

3. bindir = /usr/bin


## important file 
- poky/meta/conf/document.conf
- poky/meta/conf/bitbake.conf -> setting variables

- bitbake -getvar "varName"

- in do_compile -> write bash script
    - if you want py -> write before it


## GLobal vars
- local.conf
- layer.conf
- distro.conf
- don't set any l


## task
- clone repo
- sudo apt instal cmake
- cmake -S . -B build -> do_configue
- make -C ${B}  -> do_compile

- inherit somthing
- configure cmake in do_configure
- then in compile use make
- check how make file used in yocto