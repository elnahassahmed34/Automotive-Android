# Auto build tools

## distro -> building image from scratch
- cross compile
    - uboot
    - kernel
    - busy box

## Auto build -> create her own envirnoment
- fetching + config -> scripts = full image

## stages
- source -> clone -> config -> build -> rootfs


## Yocto vs build root
|comp.      |yocto              | build root    |
|:---------:|:-----------------:|---------------|
|timimg     |more               | less          |
|footprint  |high               |low            |        
|features   |more               |less           |
|size       |big                |small          |        


## build root
- toolchain  -> choose lib
- sys config -> - init process
                - type of shell
                - enable rootfs
- Kernel -> version of kernel
- Target packages -> dropbear 

## task : add package

1. Create folder under package as following
```
mkdir -p ./package/simpleapp/src
```

2. Create source file under src and write a simple code
```
vim simpleapp.c
```
```c
#include <stdio.h>

int main(void) {
	printf("Hi nahass\r\n");
}
```

3. make file -> src
```
vim Makefile
```
```
.PHONY: clean
.PHONY: simpleapp

simpleapp: simpleapp.c
        $(CC) -g -Wall $(CFLAGS) $(LDFLAGS) $< -o $@

clean:
        -rm simpleapp
        
```

4. pkg make file -> pkg/simpleapp
```
vim simpleapp.mk
```

```
SIMPLEAPP_VERSION = 1.0
SIMPLEAPP_SITE = package/simpleapp/src
SIMPLEAPP_SITE_METHOD = local# Other methods like git,wget,scp,file etc. are also available.

define SIMPLEAPP_BUILD_CMDS
    $(MAKE) CC="$(TARGET_CC)" LD="$(TARGET_LD)" -C $(@D)
endef

define SIMPLEAPP_INSTALL_TARGET_CMDS
    $(INSTALL) -D -m 0755 $(@D)/simpleapp  $(TARGET_DIR)/usr/bin
endef

$(eval $(generic-package))
```

6. config file
```
vim Config.in
```
```
config BR2_PACKAGE_SIMPLEAPP
    bool "simpleapp"
    help
        simpleapp package.
```
7. Add the new Config.in in the configuration for buildroot

vim ./package/Config.in
Add new menu under Target Package
```
menu "SIMPLEAPP Packages"
    source "package/simpleapp/Config.in"
endmenu
```

8. enable pkg then rebuild and test it
```
make menuconfig
make -j8
sudo picocom -b 115200 /dev/ttyUSB0
simpleapp
```


