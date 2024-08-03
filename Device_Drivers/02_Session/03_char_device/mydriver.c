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

dev_t mydevice ;

/* Code section */
static int __init mykernel_init(void)
{   
    if(alloc_chrdev_region(&mydevice , 0,1 ,DRIVER_NAME) < 0){
        printk("device couldn't be allocated\n");
        return -1 ;
    }
    else{
        
        printk("Major %d , Minaor %d\n" , MAJOR(mydevice) , MINOR(mydevice));
    }



    printk(KERN_INFO "hello nahass from kernel\n");
    /* Init function success */
    return 0;
}

/* Deinit function */
static void __exit mykernel_exit(void)
{
    unregister_chrdev_region(mydevice , 1);
    printk(KERN_INFO "bye nahass\n");
}

module_init(mykernel_init);
module_exit(mykernel_exit);


MODULE_LICENSE("GPL");
MODULE_AUTHOR("Nahass");
MODULE_DESCRIPTION("module for char device");