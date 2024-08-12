#include "file_operations.h"

#define DRIVER_NAME "Driver"

#define DRIVER_CLASS "Class"

MODULE_LICENSE("GPL");

MODULE_AUTHOR("NAHASS");

MODULE_DESCRIPTION("Hello");

struct mydata
{
    dev_t my_device_nr;         // Device number
    struct cdev cdev_object;    // Represents a character device
                                // and provides a way to manage and interact with it
    struct file_operations fops; // File operations structure
    struct class *my_class;     // Pointer to the device class
} teraData_st = {
    .fops = {
        .owner = THIS_MODULE,   // Owner of the file operations
        .open = driver_open,    // Function pointer to the open function
        .release = driver_close, // Function pointer to the close function
        .read = driver_read,    // Function pointer to the read function
        .write = driver_write   // Function pointer to the write function
    }
};

static struct platform_device_id device_id[] =
    {
        [LED_RED] = {.name = "LED_RED"},
        [LED_RED_2] = {.name = "LED_RED_2"},
};

int prob_device(struct platform_device *sLED_P)
{
    printk("%s device_detected", sLED_P->name);

    if (strcmp(sLED_P->name, "LED_RED") == 0)
    {
        gpio_request(2, "LED_RED_pin");
        gpio_direction_output(2, 0);
    }   
    else if (strcmp(sLED_P->name, "LED_RED_2") == 0)
    {
        gpio_request(3, "LED_RED_2_pin");
        gpio_direction_output(3, 0);
    }
    else if (strcmp(sLED_P->name, "LED_GREEN") == 0)
    {
        gpio_request(4, "LED_GREEN_pin");
        gpio_direction_output(4, 0);
        
    }


    device_create(teraData_st.my_class, NULL, teraData_st.my_device_nr + (sLED_P->id), NULL, sLED_P->name);


    return 0;
}


int device_remove(struct platform_device *sLED_P)
{
    if (strcmp(sLED_P->name, "LED_RED") == 0)
    {
        gpio_set_value(2, 0);
        gpio_free(2);
    }
    else if (strcmp(sLED_P->name, "LED_RED_2") == 0)
    {
        gpio_set_value(3, 0);
        gpio_free(3);
    }
    else if (strcmp(sLED_P->name, "LED_GREEN") == 0)
    {
        gpio_set_value(4, 0);
        gpio_free(4);
    }

    device_destroy(teraData_st.my_class, teraData_st.my_device_nr + (sLED_P->id));

    printk("device_remove");

    return 0;
}

struct platform_driver platform_driver_data =
    {
        .probe = prob_device,
        .remove = device_remove,
        .id_table = device_id,
        .driver = {
            .name = "mydriver"
        }
};

static int __init INIT(void)
{
    printk("PLatform driver inserted\n");

    alloc_chrdev_region(&teraData_st.my_device_nr, 0, 3, DRIVER_NAME) ;

    cdev_init(&teraData_st.cdev_object, &teraData_st.fops);
    cdev_add(&teraData_st.cdev_object, teraData_st.my_device_nr, 3);
    
    teraData_st.my_class = class_create(DRIVER_CLASS);
    
    platform_driver_register(&platform_driver_data);
    return 0;
}

static void __exit DEINIT(void)
{
    platform_driver_unregister(&platform_driver_data);

    class_destroy(teraData_st.my_class);

    cdev_del(&teraData_st.cdev_object);

    unregister_chrdev_region(teraData_st.my_device_nr, 1);
    printk("Goodbye\n");
}


module_init(INIT);


module_exit(DEINIT);
