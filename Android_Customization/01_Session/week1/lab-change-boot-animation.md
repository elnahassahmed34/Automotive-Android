# lab1: change boot animation

## 1- Follow bootanimation.zip file format

>https://cs.android.com/android/platform/superproject/+/android-14.0.0_r61:frameworks/base/cmds/bootanimation/FORMAT.md

[Another Description](https://blog.justinbull.ca/making-a-custom-android-boot-animation/)

## 2- Test

    adb root
    adb remount
    adb push bootanimation.zip /system/media/bootanimation.zip

## 3- Copy boot/shutdown/reboot animation files to recommended file system path(s)

    PRODUCT_COPY_FILES += \
        [animation_path/bootanimation.zip]:system/media/bootanimation.zip

## 4- make the new ROM image

    make bootimage systemimage vendorimage -j$(nproc)
    ./rpi4-mkimg.sh

### Investigate update the Shutdown and Reboot animations

    Use this info as start point

    https://cs.android.com/android/platform/superproject/+/android14-qpr3-release:device/google/cuttlefish/vsoc_x86_64_only/auto_portrait/aosp_cf.mk;l=35?q=bootanimation.zip&ss=android%2Fplatform%2Fsuperproject

    /oem/media/bootanimation.zip
    /oem/media/shutdownanimation.zip
    /oem/media/userspace-reboot.zip