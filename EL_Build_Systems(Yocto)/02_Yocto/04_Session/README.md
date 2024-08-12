# Yocto Principles

## Recap
1. recipe
- header section
    - SUMMARY
    - Document
    - LICENSE = MIT
    - LIC_files_CHKSUM

2. Development
- SRC_URI -> Download DL
    - do_fetch
- SRCREV = commit hash
- Tasks -> if you don't provide your own task imp. , there is a default one
    - do_unpack 
    - do_patch
    - do_configue
    - do_compile
    - do_install

## two ways to write task
- as default : do_configure
- as python : python do_configure

## All variables -> global
- = Direct assignation
- recipe -> local variable
    - ex : PV is diff. from one .bb to another

- bitbake-getvar -r example PV

## under build/conf : 
- layer.conf -> show your layers

## local.conf
- the most important file
- poky/meta/conf/document.conf -> for variables
- machine : specify your machine
    - poky/meta/conf/machine
    - beaglebone -> meta-bsp/machine -> provide by yocto
- rbpi -> from open embedded
- BB -> from texas ti

- DL_DIR -> fetch
- sstatecache-> caches for building
- TMPDIR 
    - work -> working dirc. for all recipes
    - deploy -> image : dd sd
- distro : change the name
    - layer -> conf -> distro -> nahass.conf
    - meta-poky/distro/poky.conf

### distro
- create your own distro
    - under your meta-iti/conf
        - mkdir distro
        - touch nahass.conf
        ```
        include meta-poky/conf/distro/poky.conf

DISTRO = "nahass"
DISTRO_NAME = "nahass (Yocto Project Reference Distro)"
#DISTRO_VERSION = "3.4+snapshot-${METADATA_REVISION}"
DISTRO_VERSION = "4.0.20"
DISTRO_CODENAME = "kirkstone"

MAINTAINER = "elnahassahmed34@gmail.com"
        ```

- diff between one distro to another
    1. pkg manager -> ipk | rbp | deb
    2. libraries glibc | musl
    3. init process sys V | D | busybox
    4. kernel version
    5. U-boot version

### pkg - rpm
- tmp/deploy/rpm
- excutables -> compiled already
- after it it will be installed

### patch resolve = "noop"
- error on terminal
- you can make it = "user"
    - open terminal to solve proplems


## meta data
### conf
- layer.conf
- bblayer.conf
- metalayer -> layer.conf
- machine.conf
- distro.conf

## recipe.bbappend
- ex : recipe_1.2.bb -> recipe_1.2.bbappend 
                    -> recipe_%.bbappend -> latest version
- if there is the same name of recipe -> latest version will be taken
    - if they have same version then the priority of layer will be the judge
- bbappend -> extend functionality of the main recipe
- extend the recipe
```
python do_display:append(){
    bb_plain""
}
```
- use case : bbappend
    - chnge from app to service

- recipe
```
SUMMARY = "C example recipe"
DESCRIPTION = "Recipe to build a C project using Make"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://main.c"

# Define the source directory
S = "${WORKDIR}"

# Compile the project using Make
do_compile() {
    ${CC} ${CFLAGS} ${WORKDIR}/main.c -o ${B}/myapp
}

# Install the compiled binaries
do_install() {
    # Ensure the destination directory exists
    mkdir -p ${D}${bindir}
    
    # Copy the compiled binary to the destination directory
    install -m 0755 ${B}/myapp ${D}${bindir}/
}


```

- append
```
SRC_URI:append = " file://myservice.service"

Inherit = systemd
SYSTEMD_AUTO_ENABLE = "enable"

# Install the compiled binaries
do_install() {

    install -d ${D}/${sysconfdir}/systemd/system/
    install -m 0666 ${WORKDIR}/myservice.service ${D}/${sysconfdir}/systemd/system

}

```
- service
```
[Unit]
DESCRIPTION = "my service"

[Service]
ExecStart = /usr/bin/myapp

[Install]
WantedBy = multi-target
```

## bbclass
- yocto create his own env.
- any thing that's inherit is class
- Inherit = cmake
- Inherit = systemd


## Image Install
IMAGE_INSTALL:append = " google python3 bash qt5"
- for qt5
    - git checkout kirkstone
    - download oe layer

## DISTRO_FEATURE
- add system d here as it is considered

## task
1- image rbpi
2- create layer
3- create your own distro -> #include poky.conf
4- create recipe -> ping to ip of computer
    - if it ping led off
    - if no ping led on
  



