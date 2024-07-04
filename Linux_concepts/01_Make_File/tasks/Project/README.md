# Basic C Application Project

## Objective
This project implements a basic calculator application in C. The application can perform basic arithmetic operations (+, -, *, /) based on user input.

## Directory Structure
- `src/`: Contains the C source files.
- `include/`: Contains the header files.
- `bin/`: Directory to store compiled object files.
- `build/`: Directory to store the final executable (`app`).

## Makefile Features
- Uses variables (`CC`, `INCS`, etc.) for compiler and include directories.
- Utilizes the `patsubst` function for pattern substitution.
- Implements the `foreach` function to iterate over lists in the Makefile.

## How to Compile and Run
1. Navigate to the project directory.
2. Run `make` to compile the application.
3. The executable will be created in the `build/` directory.
4. Run the application: `./build/app`.

## Clean Up
- Run `make clean` to remove the compiled object files and the executable.

## Example Usage
```sh
$ make
$ ./build/app
Enter expression ex:(a + b): 5 + 3
Result: 8.00
