# Compilation Native and Cross

This repository explains the concepts of native and cross-compilation, different types of compilers, and how to set up a cross-compilation environment using crosstool-NG.

## 1. Native Compilation

Native compilation refers to compiling code on the same architecture and operating system where it will be executed. This is the standard approach for most development work. The code is compiled into an executable binary that can run directly on the machine where the compilation took place.

**Concept:**
- Source code (e.g., `main.c`) is compiled using the native compiler (e.g., `gcc`) on the host machine.
- The output binary (`a.out`) is directly executable on the host machine.

## 2. Cross Compilation

Cross compilation involves compiling code on one architecture and operating system (the host) to be executed on a different architecture and/or operating system (the target). This is common in embedded systems development.

**Concept:**
- The application is divided into logic parts (e.g., arithmetic operations) and kernel/system calls (e.g., hardware interactions).
- Two types of compilers:
  - OS compilers: for compiling code that runs on an operating system.
  - Bare-metal compilers: for compiling code that runs directly on the hardware without an OS.

**Different Libraries:**
- `glibc`: The GNU C Library, the most common C library for Linux systems.
- `uclibc`: A smaller C library for embedded systems.
- `musl`: A lightweight, fast, and simple C library.

## 3. Crosstool-NG

Crosstool-NG is an open-source tool for building cross-compilation toolchains. It allows you to configure and build a cross-compiler tailored to your specific target environment.

### Configurations
1. Architecture: Specify the target architecture (e.g., ARM, MIPS).
2. Cross or Native Compile: Define whether you are building a cross-compiler or a native compiler.
3. Binutils: The binary utilities for the toolchain.
4. Choose Library: Select the C library (`glibc`, `uclibc`, `musl`).
5. Kernel Headers: Provide the headers for the target kernel.
6. Bare Metal and OS: Define if the target is a bare-metal system or an OS-based system.

