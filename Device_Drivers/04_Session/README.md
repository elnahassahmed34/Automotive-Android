# platform driver

## platform_device_register()
- platform Bus
    - driver  -> looking for led 1 | 2 device
    - devices -> inject in the bus 

## device tree
```
struct platform_driver platform_driver_data =
    {
        .probe = prob_device,
        .remove = device_remove,
        .driver = {
            .name = "mydriver",
            .of_match_table = platDeviceIdDTS}};

```
- .of_match_table = platDeviceIdDTS
    - that's how the platform driver know about the device

- check in probe for the properties provided in DTS

## attributes
- add some attributes to the driver under /sys/class

```
struct device_attribute myDevsAttr[2] =
    {
        [0] = {
            .attr = {
                .name = "direction",
                .mode = S_IRUSR | S_IWUSR,
            },
            .show = teraShow1,
            .store = teraStore1},
        [1] = {.attr = {
                    .name = "value", 
                    .mode = S_IRUSR}, 
                .show = teraShow2, 
                .store = NULL}
                };

```
- attr for direction and another for reading values
- 2 file operations 
    - .show    -> reading (cat)
    - .store   -> writing (echo) 
- in probe function :
    - int retval = device_create_file(dev, &(myDevsAttr[i])); 
- you implement attributes under /sys/class
    - but file operations under /dev/device

## yocto integrates with kernel
- build it by in meta-skeleton/kernel
- /lib/modules/../extra

