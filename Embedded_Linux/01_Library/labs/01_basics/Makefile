# Variables
CC = gcc
CFLAGS = -Wall -g
TARGET = a.out
SRCS = main.c add.c
OBJS = $(SRCS:.c=.o)

# Phony targets
.PHONY: all clean

# Default target
all: $(TARGET)

# Pattern rule to compile .c files into .o files
%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

# Rule to link object files into executable
$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) $^ -o $@

# Clean up build files
clean:
	rm -f $(OBJS) $(TARGET)
