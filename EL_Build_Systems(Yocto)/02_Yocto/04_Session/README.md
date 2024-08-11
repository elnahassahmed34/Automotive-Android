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
- script -> local variable




