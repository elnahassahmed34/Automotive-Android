# Linux Kernel Modules (LKM)

## Linux kernel 
- Handle task
- Interface during run time

## module -> driver
- not only for HW but also for SW

## Type static vs dynamic
### - static
- during linux compilation
- Zimage : modules become part of linux kernel

#### Disadvantages
1. size of zimage will increase
2. start up of the kernel will be slower


### - Dynamic 
-   during linux runtime 
- module .ko : loaded at runtime
- lsmod
- use insmod and rmmod (modprobe -> dep)

#### Disadvantages
1. size of .ko will be larger
2. startup of module will be slower
    - use system calls to load it


## Why LKM ?
- extend linux functionality
    - security
    - filesystem
    - device drivers -> we will focus here

## LKM syntax
### 1. Header section
    - #include (kernel headers)
        - .h .c -> kernel linux code
    - when choose kernel headers make sure it is compatible with linux kernel version
    - uname -r
    ```
    uname -r
    6.5.0-44-generic
    ```
    - ls /usr/src/linux
    ```
    ls /usr/src/linux-headers-6.5.0-44-generic/
    arch           include   lib             scripts
    block          init      Makefile        security
    certs          io_uring  mm              sound
    crypto         ipc       Module.symvers  tools
    Documentation  Kbuild    net             ubuntu
    drivers        Kconfig   rust            usr
    fs             kernel    samples         virt
    ```

### no user space library is used when writing kernel modules
- we work in kernel space not user space
    - we don't need sys calls


### 2. code section
- C functions
    - restrictions : linux gives you what you nedd (Template)

- I don't have main function
    - kernel already has its main function

### - two main functions
1. module init -> init function

2. module deinit (exit)

3. added to macro function
- module_init()
- module_exit()
- Acts as ptr to functions

4. add Module_license
    - because kernel code use GPL which your module will use

5. make file
- obj-m += mydriver.o
    - -m dynamic
    - -y static
        - need other steps

## why ko larger .o (static with kernel)
- static __init int kernel_init(void)
    - static : none can call function outside module
    - __init : delete this section after init

- static __exit void kernel_deinit(void)
    - __exit : if you compile static : this section willnot be used

## Implement (proc file system)
- kernel module
1. to create a file under proc use function proc_create()

2. operations file created under proc
    - read , write -> system calls

3. in write function
- recieve data from user
- static ssize_t my_write(struct file *file, const char __user *buff, size_t size, loff_t *loff)
    - buff -> from user
        - can't be derefrenced -> seg fault due to paging by MMU
    - so we will use copy from user
        - dest , source size

4. in read function 



## device driver categries
1. char device -> gpio uart
2. block device -> storage
3. network device -> wifi , eht0

## delete /var/log (kernel log + syslog)




