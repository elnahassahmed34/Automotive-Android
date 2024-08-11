obj-m += GPIO.o LED_RED.o LED_RED_2.o
GPIO-y := platform_driver.o file_operations.o
LED_RED-y := platform_device.o
LED_RED_2-y := platform_device2.o

all:
	make -C /lib/modules/$(shell uname -r)/build M=$(shell pwd) modules

clean:
	make -C /lib/modules/$(shell uname -r)/build M=$(shell pwd) clean