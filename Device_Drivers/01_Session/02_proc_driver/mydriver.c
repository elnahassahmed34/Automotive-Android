/* Header section */
#include <linux/module.h>
#include <linux/init.h>
#include <linux/cdev.h>
#include <linux/fs.h>
#include <linux/proc_fs.h>
#include <linux/uaccess.h>

MODULE_LICENSE("GPL");

/* Function prototypes */
static ssize_t my_read(struct file *file, char __user *buff, size_t size, loff_t *loff);
static ssize_t my_write(struct file *file, const char __user *buff, size_t size, loff_t *loff);

/* File operations for proc file */
static const struct proc_ops proc_file_operations = {
    .proc_read = my_read,
    .proc_write = my_write,
};

struct proc_dir_entry *proc_entry;

/* Read function */
static ssize_t my_read(struct file *file, char __user *buff, size_t size, loff_t *loff)
{
    printk(KERN_INFO "hello nahass from read\n");
    return size;  // return the size to indicate the operation was successful
}

/* Write function */
static ssize_t my_write(struct file *file, const char __user *buff, size_t size, loff_t *loff)
{
    char buffer[10];
    if (size > 10) {
        printk(KERN_WARNING "buffer overloading\n");
    } else {
        if (copy_from_user(buffer, buff, size)) {
            printk(KERN_ERR "copy_from_user failed\n");
            return -EFAULT; // Return an error if copy_from_user fails
        }
        printk(KERN_INFO "write done\n");
    }
    printk(KERN_INFO "hello nahass from write\n");
    return size;  // Return the size to indicate the operation was successful
}

/* Code section */
static int __init mykernel_init(void)
{
    proc_entry = proc_create("google", 0666, NULL, &proc_file_operations);
    if (!proc_entry) {
        printk(KERN_ERR "Failed to create /proc/google entry\n");
        return -ENOMEM;
    }
    
    printk(KERN_INFO "hello nahass from kernel\n");
    return 0;
}

/* Deinit function */
static void __exit mykernel_exit(void)
{
    proc_remove(proc_entry);
    printk(KERN_INFO "bye nahass\n");
}

module_init(mykernel_init);
module_exit(mykernel_exit);
