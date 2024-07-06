# Embedded Linux Development Resources

This repository provides a collection of resources to empower you in your embedded Linux development journey. It covers essential topics to navigate the environment effectively and streamline your workflow.

## Topics

* **Shell Configuration Files**
    * `.bashrc`: This file customizes your shell environment on a per-user basis. You can define aliases, environment variables, and shell functions here.  For detailed information, refer to: https://www.digitalocean.com/community/tutorials/initial-server-setup-with-ubuntu
    * `.profile`: This file sets up your shell environment on login. It's often used for global aliases or configurations that apply to all interactive shells. Refer to: https://www.baeldung.com/linux/bashrc-vs-bash-profile-vs-profile for a deeper dive.

* **Vim: Your Text Editor Companion**
    * **Navigating and Editing:**
        * **Modes:** Vim operates in two primary modes: command mode for navigation and editing operations, and insert mode for entering text.
            * Enter command mode by pressing `Esc`.
            * Enter insert mode by pressing `i` (insert), `a` (append at the end of the line), or any other insertion-specific key.
        * **Movement:**
            * Use arrow keys (`h`, `j`, `k`, `l`) to move within the document.
            * `g` (go to), `G` (go to line end), `0` (go to line beginning) for efficient navigation.
        * **Deletion:**
            * `x` to delete the character under the cursor.
            * `d` followed by a motion (e.g., `dw` to delete word) to delete specific text.
        * **Copying and Pasting:**
            * `y` followed by a motion to copy.
            * `p` to paste the copied content.
    * **Essential Shortcuts:**
        * `:w` (write): Save the file.
        * `:q` (quit): Exit Vim.
        * `:wq` (write & quit): Save and exit.
        * `:x` (exit): Exit, discarding unsaved changes (confirm if necessary).
        * `u` (undo): Undo the last change.
        * `Ctrl+r` (redo): Redo the last undo.
        * `~` (repeat): Repeat the last change.
        * `/` (search): Search forward for a pattern.
        * `?/<pattern>`: Search backward for a pattern.
        * `/` (replace): Replace occurrences of a pattern with a new string (interactive or command-line mode).

* **Finding Files:**
    * **`locate`:** Efficient for frequently updated databases but may not reflect immediate changes for non-updated databases.
    * **`find`:** More flexible and customizable for searching with complex criteria.
    * **`grep`:** Search for text patterns within files or streams.

* **Redirection Operators:**
    * `<` (input redirection): Redirect input from a file to a command.
    * `>` (output redirection): Redirect the standard output of a command to a file.
    * `2>` (error redirection): Redirect standard error to a file.
    * `&>` (combine output and error): Redirect both standard output and error to a file.

* **File Descriptors (FDs):**
    * File descriptors are low-level integer identifiers that map to open files or special devices. Standard streams (stdin, stdout, stderr) have pre-defined file descriptors:
        * `0`: stdin (standard input)
        * `1`: stdout (standard output)
        * `2`: stderr (standard error)

# Piping (`|`)

Piping is a powerful feature in Linux that allows the output of one command to be used as the input to another command. This mechanism facilitates Inter-Process Communication (IPC) by chaining multiple commands together to perform complex operations efficiently.

**Example**:
- `ls -l | grep "txt"`: Lists all files in long format and pipes the output to `grep`, which filters and shows only lines containing "txt".

**Explanation**:
- The `ls -l` command lists all files and directories in the current directory in long format.
- The pipe symbol (`|`) takes the output of `ls -l` and feeds it as input to the `grep "txt"` command.
- `grep "txt"` filters the input and displays only the lines that contain the string "txt".

# Soft Link vs Hard Link

## Soft Link (Symbolic Link)

A soft link, also known as a symbolic link, is a special type of file that points to another file or directory. It functions like a shortcut in Windows and can span across different file systems.

**Characteristics**:
- If the target file is deleted, the soft link becomes a dangling link and is invalid.
- Can link to directories and files across different file systems.

**Example**:
- `ln -s /path/to/target /path/to/softlink`: Creates a soft link named `softlink` pointing to `target`.

**Explanation**:
- The `ln -s` command creates a symbolic link.
- `/path/to/target` is the file or directory being linked to.
- `/path/to/softlink` is the name of the symbolic link created.

## Hard Link

A hard link is a direct reference to the data of a file on the disk. Multiple hard links to a file share the same inode number, meaning they are indistinguishable from the original file.

**Characteristics**:
- Deleting the original file does not affect the hard link; the data remains accessible as long as one hard link exists.
- Cannot link to directories and must be on the same file system.

**Example**:
- `ln /path/to/target /path/to/hardlink`: Creates a hard link named `hardlink` pointing to `target`.

**Explanation**:
- The `ln` command without `-s` creates a hard link.
- `/path/to/target` is the file being linked to.
- `/path/to/hardlink` is the name of the hard link created.

# Summary

- **Piping (`|`)**: Allows chaining commands where the output of one command is used as the input to another.
- **Soft Link (Symbolic Link)**: A shortcut-like file that points to another file or directory, which can span across different file systems.
- **Hard Link**: A direct reference to the data of a file, sharing the same inode, and must be on the same file system.

Understanding and utilizing these features efficiently can greatly enhance file management and command execution in Linux.



task 2 programs

file descriptor (c program)
1 - file descriptor on file 
/sys/class/led/input::capslock/brightness

2- read content of file
print on filename (output.txt) in your home

3-another c program read file output
if var == 1 write on brightness 0

4-use piping command to communicate between them




