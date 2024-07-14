# Define compilers
CC?=gcc

# Directories
SRC_DIR=src
OBJ_DIR=obj
INCLUDE_DIR=Includes
LIB_DIR=./lib
APP_DIR=app

# Source and Object files
SRC_FILES=$(wildcard $(SRC_DIR)/*.c)
OBJ_FILES=$(patsubst $(SRC_DIR)/%.c, $(OBJ_DIR)/%.o, $(SRC_FILES))

# Targets
STATIC_LIB=$(LIB_DIR)/libcalc.a
DYNAMIC_LIB=$(LIB_DIR)/libcalc.so
EXECUTABLE1=$(APP_DIR)/staticcalculator
EXECUTABLE2=$(APP_DIR)/dynamiccalculator

# Compiler flags
CFLAGS=-I $(INCLUDE_DIR)

# Default target
all: static dynamic

# Create object directory
$(OBJ_DIR):
	mkdir -p $(OBJ_DIR)

# Create library directory
$(LIB_DIR):
	mkdir -p $(LIB_DIR)

# Object files
$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c | $(OBJ_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

# Static library
$(STATIC_LIB): $(OBJ_FILES) | $(LIB_DIR)
	ar rcs $@ $^

# Dynamic library
$(DYNAMIC_LIB): $(OBJ_FILES) | $(LIB_DIR)
	$(CC) -shared -o $@ $^

# Executable with static linking
static: $(STATIC_LIB) $(APP_DIR)/main.c
	$(CC)  $(APP_DIR)/main.c $(CFLAGS) -L$(LIB_DIR) -lcalc  -o $(EXECUTABLE1)

# Executable with dynamic linking using rpath
dynamic: $(DYNAMIC_LIB) $(APP_DIR)/main.c
	$(CC) $(APP_DIR)/main.c $(CFLAGS) -L$(LIB_DIR) -Wl,-rpath=$(LIB_DIR) -lcalc  -o $(EXECUTABLE2)

# Clean
clean:
	rm -rf $(OBJ_DIR) $(LIB_DIR) $(EXECUTABLE1) $(EXECUTABLE2)
