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




