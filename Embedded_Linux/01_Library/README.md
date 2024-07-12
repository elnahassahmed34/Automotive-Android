# Embedded Linux: Static Library vs Dynamic Library

## Introduction

In embedded Linux, libraries are essential components that provide reusable code for various applications. Libraries can be classified into two main types: static libraries and dynamic libraries. This document provides an overview of the differences between static and dynamic libraries, their advantages and disadvantages, and how to build and link them using GCC.

## Static Libraries

### Overview
Static libraries are collections of object files bundled together into a single archive file with the `.a` extension. When you link an application with a static library, the library's code is copied into the executable.

### Advantages
- **Portable**: The executable can run on systems without the library installed.
- **Fast Execution**: No runtime linking is required, resulting in faster startup times.

### Disadvantages
- **Size**: Executables are larger because they include the library code.
- **Recompilation**: If the library changes, all executables linked with it need to be recompiled.

### Building and Linking Static Libraries

#### Example Code
`add.c`:
```c
int add(int a, int b) {
    return a + b;
}
```
- sub.c:

```c
int sub(int a, int b) {
    return a - b;
}
```
- Build Process
Compile the source files into object files:

```sh
gcc -c add.c -o add.o
gcc -c sub.c -o sub.o

- Create a static library:

```sh
ar -rcs libmylib.a add.o sub.o
```
- -r: Replace or add files.
- -c: Create the archive.
- -s: Create an index (symbol table).

- Link the static library with the main application:

```sh
gcc main.c -L. -lmylib -o my_program
```
## Dynamic Libraries
### Overview
- Dynamic libraries, or shared objects, have the .so extension. 
- They are loaded into memory at runtime by the system loader.

#### Advantages
- Smaller Executable Size: The executable contains only references to the shared library.
- Memory Efficiency: Multiple programs can share a single instance of the library in memory.
- Easier Updates: Updating the library does not require recompiling the executables.

#### Disadvantages
- Dependency Management: The shared library must be present on the system at runtime.
- Potentially Slower Startup: The library is loaded at runtime, which may introduce a small delay.
- Building and Linking Dynamic Libraries

Build Process
Compile the source files into position-independent code (PIC):

```sh
gcc -c -fPIC add.c -o add.o
gcc -c -fPIC sub.c -o sub.o
```

- Create a dynamic library:

```sh
gcc -shared -o libmylib.so add.o sub.o
```

- Link the dynamic library with the main application:

```sh
gcc main.c -L. -lmylib -o my_program
```

- Running Applications with Dynamic Libraries

#### Methods to Load Shared Libraries
- During Compilation: Embed the library path in the executable.
-rpath : for system loader , -L for compiler
```sh
gcc main.c -L. -lmylib -Wl,-rpath=.
```
- Using LD_LIBRARY_PATH: Set the environment variable to specify the library path.

```sh
export LD_LIBRARY_PATH=.
./my_program
```

- System Library Directory: Place the library in a standard directory like /usr/lib.

### Useful GCC Flags
- -Wall: Enable all warnings.
- -Werror: Treat warnings as errors.
- -Wextra: Enable additional warnings.

## Example Makefile
```makefile
# Makefile for building static and dynamic libraries and linking them

# Compiler
CC = gcc

# Compiler flags
CFLAGS = -Wall -Werror -Wextra

# Source files
SRCS = add.c sub.c main.c

# Object files
OBJS = add.o sub.o

# Static library
STATIC_LIB = libmylib.a

# Dynamic library
DYNAMIC_LIB = libmylib.so

# Executable
EXEC = my_program

all: static dynamic

# Build static library
static: $(STATIC_LIB)
$(STATIC_LIB): $(OBJS)
	ar -rcs $@ $^

# Build dynamic library
dynamic: $(DYNAMIC_LIB)
$(DYNAMIC_LIB): $(OBJS)
	$(CC) -shared -o $@ $(OBJS)

# Compile object files
%.o: %.c
	$(CC) -c -fPIC $< -o $@

# Link executable with static library
static_exe: $(STATIC_LIB)
	$(CC) main.c -L. -lmylib -o $(EXEC)_static

# Link executable with dynamic library
dynamic_exe: $(DYNAMIC_LIB)
	$(CC) main.c -L. -lmylib -Wl,-rpath=. -o $(EXEC)_dynamic

clean:
	rm -f $(OBJS) $(STATIC_LIB) $(DYNAMIC_LIB) $(EXEC)_static $(EXEC)_dynamic
```