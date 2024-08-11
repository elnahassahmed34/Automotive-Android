#include "file_operations.h"

static char RED_1[3] = {0};
static char RED_2[3] = {0};
static char GREEN[3] = {0};

int global_minor;

enum devices
{
    RED_1_e = 2,
    RED_2_e,
    GREEN_e
} status;

int driver_open(struct inode *device_file, struct file *instance)
{
    dev_t dev_id = device_file->i_rdev;
    int major = MAJOR(dev_id);
    int minor = MINOR(dev_id);

    global_minor = minor;

    instance->private_data = &global_minor;

    printk("Opened device with major number %d and minor number %d\n", major, minor);

    return 0;
}


int driver_close(struct inode *device_file, struct file *instance)
{
    printk("close FUNCTION was called!\n");

    return 0;
}

ssize_t driver_write(struct file *File, const char *user_buffer, size_t count, loff_t *offs)
{
    printk("Write function is entered\n");
    char (*value)[3] = NULL;
    int not_copied;
    
    if (*(int *)File->private_data == 0)
    {
        printk("The minor who called write is minor 0\n");
        value = &RED_1;
        status = RED_1_e;
    }
    else if (*(int *)File->private_data == 1)
    {
        printk("The minor who called write is minor 1\n");
        value = &RED_2;
        status = RED_2_e;
    }
    else if (*(int *)File->private_data == 2)
    {
        printk("The minor who called write is minor 2\n");
        value = &GREEN;
        status = GREEN_e;
    }

    not_copied = copy_from_user(value, user_buffer, sizeof(RED_1));

    switch ((*value)[0])
    {
    case '0':
        gpio_set_value(status, 0);
        printk("gpio clear is done\n");
        break;
    case '1':
        gpio_set_value(status, 1);
        printk("gpio set is done\n");
        break;
    default:
        printk("gpio Invalid input\n");
        break;
    }

    count = count - not_copied;
    return count;
}


ssize_t driver_read(struct file *File, char *user_buffer, size_t count, loff_t *offs)
{
    printk("read function is called but this pin is just output\n");
    return -ENOSYS;
}
