#include "file_operations.h"

MODULE_LICENSE("GPL");

MODULE_AUTHOR("NAHASS");

MODULE_DESCRIPTION("Hello");

struct platform_device platDevice = {
    .name = "LED_RED_2",
    .id = 1,
};

static int __init INIT(void)
{
    printk("LED_RED_2 Device has been inserted successfully\n");
    platform_device_register(&platDevice);
    return 0;
}

static void __exit DEINIT(void)
{
    printk("LED_RED_2 Device has been removed successfully\n");
    platform_device_unregister(&platDevice);
}

module_init(INIT);
module_exit(DEINIT);
