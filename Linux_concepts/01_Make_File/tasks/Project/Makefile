# Variables
CC = gcc
CFLAGS = -Wall -g
INCS = -Iinclude
SRC_DIR = src
BIN_DIR = bin
BUILD_DIR = build
SRCS = $(wildcard $(SRC_DIR)/*.c)
OBJS = $(patsubst $(SRC_DIR)/%.c, $(BIN_DIR)/%.o, $(SRCS))
TARGET = $(BUILD_DIR)/app

# Phony targets
.PHONY: all clean

# Default target
all: $(TARGET)

# Rule to link object files into the final executable
$(TARGET): $(OBJS)
	@mkdir -p $(BUILD_DIR)
	$(CC) $(CFLAGS) $(OBJS) -o $@

# Pattern rule to compile .c files into .o files
$(BIN_DIR)/%.o: $(SRC_DIR)/%.c
	@mkdir -p $(BIN_DIR)
	$(CC) $(CFLAGS) $(INCS) -c $< -o $@

# Clean up build files
clean:
	@sudo rm -rf $(BIN_DIR) $(BUILD_DIR)
