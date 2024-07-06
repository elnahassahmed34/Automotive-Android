# Bash Scripting Readme

## Introduction
Bash (Bourne Again SHell) is a command language interpreter that provides a command-line user interface for Unix-like operating systems. Bash scripting allows you to automate tasks, manipulate files, and perform various system operations.

## Variables
Variables in Bash can store values that can be referenced and manipulated throughout the script.

### Examples:
```bash
name=ahmed
name="ahmed"
name=${name}
```

## Reading User Input
- You can read user input using the read command.

Example:

```bash
read -sp "Enter password: " password
echo $password
```

### Command Substitution
You can capture the output of a command in a variable using command substitution.

Example:

```bash
output=$(command)
echo $output
```

### Test Conditions
- Bash provides test conditions to evaluate expressions. These can be used in conditional statements like if, while, and until.

### Integer Conditions
- eq: equal to
- ne: not equal to
- gt: greater than
- lt: less than
- ge: greater than or equal to
- le: less than or equal to

### String Conditions
- =: equal to
- !=: not equal to
- -z: zero length
- -n: non-zero length
- File Conditions
- -f: file exists
- -d: directory exists
- -x: file is executable

Examples:
```bash
# Integer comparison
if [ $a -eq $b ]; then
  echo "a is equal to b"
fi

# String comparison
if [ -z $str ]; then
  echo "String is empty"
fi

# File comparison
if [ -f $file ]; then
  echo "File exists"
fi
```

## Logical Operators
- Logical operators are used to combine multiple test conditions.

### Operators
- && or -a: logical AND
- || or -o: logical OR

### Syntax
- Syntax 1: [ <condition> ] && [ <condition> ]
- Syntax 2: [[ <condition> && <condition> ]]
- Syntax 3: [ <condition> -a <condition> ]
Examples:
```bash
# Using logical AND
if [ $a -eq 1 ] && [ $b -eq 2 ]; then
  echo "Both conditions are true"
fi

# Using logical OR
if [ $a -eq 1 ] || [ $b -eq 2 ]; then
  echo "At least one condition is true"
fi

```

## If Condition and Elif

### If-Else Syntax
Bash uses `if`, `elif`, and `else` to create conditional statements.

```bash
if [ <condition> ]; then
    # Commands to execute if condition is true
elif [ <another condition> ]; then
    # Commands to execute if the second condition is true
else
    # Commands to execute if none of the conditions are true
fi
```
Example
```bash
read -p "Enter a number: " num

if [ $num -gt 10 ]; then
    echo "Number is greater than 10."
elif [ $num -eq 10 ]; then
    echo "Number is equal to 10."
else
    echo "Number is less than 10."
fi
```
## Loops
### For Loop
- The for loop iterates over a list of items.

```bash
for item in list; do
    # Commands to execute for each item
done
```
- Example
```bash
for i in 1 2 3 4 5; do
    echo "Number: $i"
done
```
### Loop on Strings
You can loop through a list of strings as well.

```bash
for fruit in apple banana cherry; do
    echo "Fruit: $fruit"
done
```
### While Loop
- The while loop continues to execute as long as the condition is true.

```bash
while [ <condition> ]; do
    # Commands to execute
done
```
```bash
Copy code
counter=1
while [ $counter -le 5 ]; do
    echo "Counter: $counter"
    ((counter++))
done
```
### Until Loop
- The until loop continues to execute as long as the condition is false.

```bash
until [ <condition> ]; do
    # Commands to execute
done

#Example
counter=1
until [ $counter -gt 5 ]; do
    echo "Counter: $counter"
    ((counter++))
done
```
## Arrays
### Indexed Array
- Indexed arrays are arrays where elements are accessed using their numerical index.

```bash
#Declaration
- fruits=("apple" "banana" "cherry")

#Access Elements
echo ${fruits[0]}  # Output: apple
echo ${fruits[2]}  # Output: cherry

#Modify Elements
fruits[2]="melon"
echo ${fruits[2]}  # Output: melon

#Array Size
echo ${#fruits[@]}  # Output: 3
```

### Associative Array
- Associative arrays are arrays where elements are accessed using named keys.

```bash
#Declaration
declare -A fruits=([apple]="red" [banana]="yellow")
#Access Elements
echo ${fruits[apple]}  # Output: red
```
### Unset Array Elements
- You can remove elements from arrays using the unset command.

- Example for Indexed Array
```bash
unset fruits[2]

#Example for Associative Array
unset fruits[apple]
```

# Bash Scripting Readme

## C-Style Arithmetic

### Incrementing Variables
- In Bash, you can increment variables using C-style syntax with `((...))` or `expr`.

```bash
var=5
((var++))   # Increment var by 1
echo "Incremented var: $var"
```
###Using expr
- Alternatively, you can use expr for arithmetic operations.

```bash
var2=$(expr $var + 1)   # Increment var by 1 and store in var2
var3=$(expr 2 + 2)      # Perform addition and store result in var3
echo "var2: $var2, var3: $var3"
```

## Command Line Arguments

### $0 - Script Name
- $0 represents the name of the script itself.

```bash
echo "Script name: $0"
```
### $#, $@, $*
- $# gives the number of arguments passed to the script.
- $@ expands to all arguments passed to the script as separate words.
- $* expands to all arguments passed to the script as a single word.

```bash
echo "Number of arguments: $#"
echo "All arguments separately: $@"
echo "All arguments as a single word: $*"
```
### $1, $2, ...
- $1, $2, etc., represent the individual arguments passed to the script.

```bash
echo "First argument: $1"
echo "Second argument: $2"
```

### $?
- $? holds the exit status of the last command executed.

```bash
ls non_existent_file
echo "Exit status of ls: $?"
```
### Example
```bash
#!/bin/bash

echo "Script name: $0"
echo "Number of arguments: $#"
echo "All arguments separately: $@"
echo "All arguments as a single word: $*"
echo "First argument: $1"
echo "Second argument: $2"

ls non_existent_file
echo "Exit status of ls: $?"
```

## Case Statement

### Syntax
The `case` statement in Bash allows you to match a variable against multiple patterns.

```bash
read -p "Are you sure? (yes/no): " var
case $var in
    yes)
        # Commands to execute if $var equals "yes"
        ;;
    no)
        # Commands to execute if $var equals "no"
        ;;
    *)
        # Default case, if $var doesn't match any of the above patterns
        ;;
esac
```
### Example
```bash
#!/bin/bash

read -p "Are you sure? (yes/no): " var
case $var in
    yes)
        echo "User confirmed."
        ;;
    no)
        echo "User declined."
        ;;
    *)
        echo "Invalid input."
        ;;
esac
```
### Explanation
- The case statement checks the value of $var against the patterns (yes, no, *).
- Depending on the value of $var, the corresponding block of commands (;;) executes.
- acts as the default case if no other pattern matches.


# Bash Scripting Readme

## PS1, PS2, PS3, and Others

### PS1 - Primary Prompt String
`PS1` is the primary prompt string in Bash, displayed when a command is expected.

```bash
PS1="\u@\h:\w\$ "
```
- \u: username
- \h: hostname
- \w: current working directory
- \$: displays $ for regular user and # for root

### PS2 - Secondary Prompt String
- PS2 is the secondary prompt string in Bash, displayed when a command spans multiple lines.

```bash
PS2="> "
Example usage: Continuation of a multi-line command.
```
### PS3 - Select Prompt String
- PS3 is the prompt string used by the select command in Bash.

```bash
PS3="Please enter your choice: "
```
- Example usage: Prompt for user selection in a select statement.
### PS4 - Debug Prompt String
- PS4 is the prompt string displayed before each command when the -x option is set in Bash.

```bash
PS4="+ "
Example usage: Debugging output.
```
## Select Statement
### Syntax
- The select statement in Bash creates a simple menu for selecting items interactively.

```bash
PS3="Please enter your choice: "
select var in "date" "ls" "exit"
do
    case $var in
        date)
            date ;;
        ls)
            ls ;;
        exit)
            break ;;
        *)
            echo "Invalid option" ;;
    esac
done
```
### Explanation
- PS3 sets the prompt for the select statement.
- select var in ... creates a menu with options.
- User input is stored in var.
- case $var matches user selection to execute corresponding commands.
- break exits the select loop.

### Example
```bash
#!/bin/bash

PS3="Please enter your choice: "
select var in "Date" "List files" "Exit"
do
    case $var in
        "Date")
            date ;;
        "List files")
            ls ;;
        "Exit")
            break ;;
        *)
            echo "Invalid option" ;;
    esac
done
```

```bash
# Strings and String Operations

string="nahass ahmed"

# Length of a string
echo ${#string}  # Outputs: 11

# Substring extraction (starting from index 2)
echo ${string:2}  # Outputs: hass ahmed

# Functions in Bash

# Syntax 1: Basic function definition
DisplayArguments(){
    echo $0 $1 $2
}

# Syntax 2: Using 'function' keyword
function DisplayArguments {
    echo $0 $1 $2
}

# Syntax 3: Compact form without parentheses
function DisplayArguments { echo $0 $1 $2; }

# Calling a function with arguments
DisplayArguments "Ahmed" "Elnahass"

# Using the local keyword in functions

LocalFunction() {
    local var="Local variable"
    echo $var
}

LocalFunction
echo $var  # This will throw an error since 'var' is not defined outside the function scope
```

