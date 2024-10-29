# lab2: Integrate with apps in the Android Build System

## Prebuilt App

1. Create new folder structure for the apps
2. Create Android.mk that will include info of single or multiple apps
>
        LOCAL_PATH := $(call my-dir)
        include $(CLEAR_VARS)

        LOCAL_MODULE := MY_APP_MODULE
        LOCAL_MODULE_TAGS := optional
        LOCAL_LICENSE_KINDS := legacy_restricted
        LOCAL_LICENSE_CONDITIONS := restricted
        LOCAL_SRC_FILES := $(LOCAL_MODULE).apk
        LOCAL_MODULE_CLASS := APPS
        LOCAL_MODULE_SUFFIX := .apk
        LOCAL_BUILT_MODULE_STEM := package.
        LOCAL_CERTIFICATE := PRESIGNED
        LOCAL_DEX_PREOPT := false
        LOCAL_PRIVILEGED_MODULE := true

        include $(BUILD_PREBUILT)

3. Add the defined module name to the product packages
>
        PRODUCT_PACKAGES += MY_APP_MODULE

## New Custom App Task
    Task Create new simple app and integrate it in Build System

## New Custom App Task
    Task Create new simple app and integrate it in Build System

## List and Discuss all BUILD_PREBUILT and BUILD_MAKE configurations
