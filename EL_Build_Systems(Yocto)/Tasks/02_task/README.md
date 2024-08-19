# qt with two methods 

## local.conf -> add these variables
```

#QT configuration
IMAGE_INSTALL:append = " make cmake"
IMAGE_INSTALL:append = " qtbase-tools qtbase qtdeclarative qtimageformats qtmultimedia qtquickcontrols2 qtquickcontrols qtbase-plugins cinematicexperience liberation-fonts qtbase-dev curl wget userland gstreamer1.0-plugins-bad qtsvg"
DISTRO_FEATURES:append = " x11 opengl wayland"
PACKAGECONFIG_FONTS:pn-qtbase = " fontconfig"

```

## add these layers
```
# POKY_BBLAYERS_CONF_VERSION is increased each time build/conf/bblayers.conf
# changes incompatibly
POKY_BBLAYERS_CONF_VERSION = "2"

BBPATH = "${TOPDIR}"
BBFILES ?= ""

BBLAYERS ?= " \
  /home/nahass/source/poky/meta \
  /home/nahass/source/poky/meta-poky \
  /home/nahass/source/poky/meta-yocto-bsp \
  /home/nahass/source/poky/meta-raspberrypi \
  /home/nahass/source/poky/meta-openembedded/meta-oe \
  /home/nahass/source/poky/meta-openembedded/meta-python \
  /home/nahass/source/poky/meta-openembedded/meta-networking \
  /home/nahass/source/poky/meta-iti \
  /home/nahass/source/poky/rbpi/workspace \
  /home/nahass/source/poky/meta-openembedded/meta-multimedia \
  /home/nahass/source/poky/meta-openembedded/meta-gnome \
  /home/nahass/source/poky/meta-openembedded/meta-xfce \
  /home/nahass/source/poky/meta-qt5 \
  "
``` 

## fetch
```
bitbake --runall=fetch core-image-sato
```

## build sdk
```
bitbake -c populate_sdk core-image-sato
```
- $BUILDDIR/tmp/deploy/sdk

