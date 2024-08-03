/* Header section */
#include <linux/module.h>
#include <linux/init.h>
#include <linux/cdev.h>
#include <linux/fs.h>

MODULE_LICENSE("GPL");

/* Code section */
static int __init mykernel_init(void)
{
    printk(KERN_INFO "hello nahass from kernel\n");
    /* Init function success */
    return 0;
}

/* Deinit function */
static void __exit mykernel_exit(void)
{
    printk(KERN_INFO "bye nahass\n");
}

module_init(mykernel_init);
module_exit(mykernel_exit);
