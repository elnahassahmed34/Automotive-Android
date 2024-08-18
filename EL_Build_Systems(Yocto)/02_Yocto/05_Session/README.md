# Yocot 5

## recipe
- put it under pkg or BSP
- meta layer
    - recipe bsp
    - recipe core
    - conf -> distro -> nahass.conf 
    - recipe - image -> core-image-minimal (another name)


## bbclass -> module.bbclas
- recipe -> kernel module (SRC_URI)
- meta skeleton

## Patch
- file for beaglebone load at 0x300
- we want to ues this file rbpi
- manual adjust
- or do patch for this file
- for the demo app
    - modify
    - git status
    - git modify
    - git diff main.cpp > file.patch
    - git reset --hard
    - cat ../file.patch
    - git apply ../file.patch

- SRC_URI = "git://github.com/FadyKhalil/DemoApp.git;protocol=https;branch=main \
           file://file.patch
            "



## PROVIDE + DEPEND
- DEPEND -> lib
    - recipe_add.bb -> libadd.a 
        - PROVIDES = "libadd
    - recipe_calc.bb -> calc.exe
        - DEPENDS = "libadd"
- bitbake get-var PROVIDES

### Runtime depends
- RPROVIDES + RDEPENDS
- depends on app in run time so copy it to rootfs


## Task
- layer 
    - run myimage.bb
    - distro
    - local.conf
        - machine
        - Distro
- recipe
    - core-image-minimal
    - cmdline-> terminal
    - core-image-sato -> GUI
    - QT app -> version QT5
    - then host machine
    - what i need
        - sato / server
        - meta qt5 -> check out kerkstone
            - qtbase
        - recipe -> app -> inherit qmake.bbclass
        -  include recipe -> image install
        - make button
            - led on
            - led off

