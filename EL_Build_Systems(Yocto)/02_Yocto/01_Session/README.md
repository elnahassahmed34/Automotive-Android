# Yocto Project

## Open Embedded Community
cloning + conf -> bitbake (scripts in python) = Image

### make a dirctory called Image Generator
- inside it there will be :

#### Bitbake
- git clone bitbake 

#### layers two types : app(user space) + BSP (HW space)
- group of apps 
- git clone meta-core

#### layes BSP (Board support pkg)
- git clone meta rbpi

## Yocto refrence
- how to create image -> support compatibility
- meta poky + meta yocto bsp

### poky
- meta poky + meta yocto bsp
- meta core
- bitbake
- meta skelton

## branchs -> compatibility
- first one : Zeus
- dunfell 2018
- Kirkstone up to 2026
- scarthgap 2028
```
git clone -b kirkstone https://git.yoctoproject.org/git/poky
```

## bitbake 
```

source oe-init-build-env 
bitbake --runall=fetch core-image-minimal
bitbake core-image-minimal -k
```
```
bitbake -c listtasks virtual/kernel

bitbake -c menuconfig virtual/kernel
```

## meta data 
- conf + app + class + bbappend + includes(inc) -> Poky feeder -> bitbake
                                                    - Image
                                                    - SDK (Software Dev kit)

## bitbake functions
- clone -> unpack -> patch -> config -> build -> install(rootfs)
- variables 
    - S -> source
    - B -> Build
    - D -> Destination

## recipe .bb (app)
- meta layer
    - recipes_myapp
        - myapp
        - myapp.bb




