/* Header section */
#include <linux/module.h>
#include <linux/init.h>
#include <linux/cdev.h>
#include <linux/fs.h>
#include <linux/cdev.h>
#include <linux/uaccess.h>
#include <linux/device.h>

#define  BUFFER_SIZE 1024 
#define DRIVER_NAME "iti_driver"
char buffer[BUFFER_SIZE];


dev_t device_file ;
struct class * my_class ;
struct device * my_device ;


int my_open (struct inode * inode , struct file *filep){
    
    printk("hi from open \n");
    return 0 ;

}

int my_close (struct inode * inode , struct file *filep){
    printk("hi from close \n");
    return 0 ;
}

ssize_t my_read (struct file *, char __user *, size_t, loff_t *){
    printk("hi from read \n");
    return 0 ;
}

ssize_t my_write (struct file *, const char __user *, size_t, loff_t *){
    printk("hi from write \n");
    return 0 ;
}


struct file_operations fops = {
    .owner = THIS_MODULE ,
    .read = my_read ,
    .write = my_write ,
    .release = my_close ,
    .open = my_open ,
};
struct cdev cdev_object ;


/* Code section */
static int __init mykernel_init(void)
{   

    //reserve memory
    if(alloc_chrdev_region(&device_file , 0,1 ,DRIVER_NAME) < 0){
        printk("device couldn't be allocated\n");
        return -1 ;
    }
    else{
        
        printk("Major %d , Minaor %d\n" , MAJOR(device_file) , MINOR(device_file));
    }

    //create entry under /sys/class
    my_class = class_create("my_class");
    
    //create entry under /dev -> mapped under /sys/my_class
    my_device = device_create(my_class , NULL , device_file ,  NULL , "dev");


    //register device file in VFS 
    cdev_init(&cdev_object , &fops);
    cdev_add(&cdev_object , device_file , 1);

    printk(KERN_INFO "hello nahass from kernel\n");
    /* Init function success */
    return 0;
}

/* Deinit function */
static void __exit mykernel_exit(void)
{
    device_destroy(my_class , device_file);
    class_destroy(my_class);
    unregister_chrdev_region(device_file , 1);
    printk(KERN_INFO "bye nahass\n");
}

module_init(mykernel_init);
module_exit(mykernel_exit);


MODULE_LICENSE("GPL");
MODULE_AUTHOR("Nahass");
MODULE_DESCRIPTION("module for char device");