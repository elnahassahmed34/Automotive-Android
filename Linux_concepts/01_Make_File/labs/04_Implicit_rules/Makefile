CC = gcc
CFLAGS = -Wall -g
LDFLAGS = 

# Source and object files
SRCS = main.c add.c
OBJS = $(SRCS:.c=.o)
TARGET = myapp

# Phony targets
.PHONY: all clean

# Default target
all: $(TARGET)

# Link object files to create the executable
$(TARGET): $(OBJS)

# Clean up build files
clean:
	rm -f $(OBJS) $(TARGET)
