# Task

## 1. List three Linux Distributions.
- Ubuntu
- Fedora
- Debian

## 2. From the slides, what is the `man` command used for?
- The `man` command is used to display the manual pages for commands, providing detailed information about their usage, options, and functionality.

## 3. What is the difference between `rm` and `rmdir` using the `man` command?
- `rm`: Removes files or directories. It can remove directories and their contents recursively with the `-r` option.
- `rmdir`: Removes empty directories only. It cannot remove directories that contain files or other directories.

## 4. Create the following hierarchy under your home directory:

### Commands to Create the Hierarchy
```bash
mkdir -p ~/dir1/dir11 ~/dir1/dir12 ~/docs ~/Documents
touch ~/dir1/dir11/file1 ~/docs/mycv ~/Documents/OldFiles
```
- Removing Directories and Files
- a. Remove dir11 with rmdir in one step. What did you notice? And how did you overcome that?
Notice: rmdir fails with an error if dir11 is not empty.

```bash
rmdir ~/dir1/dir11
```
Error message: rmdir: failed to remove 'dir11': Directory not empty

Overcome: Use rm -r to remove the directory and its contents.

```bash
rm -r ~/dir1/dir11
```
- b. Remove OldFiles using rmdir -p command. State what happened to the hierarchy.
Command:

```bash
rmdir -p ~/Documents/OldFiles
```

Notice: rmdir -p removes the specified directory and its parent directories if they are empty. Since OldFiles is a file and not a directory, the correct command should be rm to remove the file:

```bash
rm ~/Documents/OldFiles
```
Hierarchy after removal: If OldFiles were a directory, rmdir -p would remove both OldFiles and its parent Documents if it becomes empty. Since OldFiles is a file, removing it will leave Documents as an empty directory.

- c. The output of the command pwd was /home/user. Write the absolute and relative path for the file mycv.
Absolute Path: /home/user/docs/mycv
Relative Path: docs/mycv


## 5. Copy the /etc/passwd file to your home directory making its name mypasswd.
```bash
cp /etc/passwd ~/mypasswd
```

## 6. Rename this new file to be oldpasswd.
```bash
mv ~/mypasswd ~/oldpasswd
```

##  7. You are in /usr/bin, list four ways to go to your home directory.
```bash
cd ~
cd /home/user
cd $HOME
cd
```
## 8. List Linux commands in /usr/bin that start with the letter w.
```bash
ls /usr/bin/w*
```
Examples include wall, watch, wc, wget.

## 9. What command type are used for? (from the slide)
Command types are used to determine whether a command is an internal shell command, an alias, or an external command.

## 10. Show 2 types of command files in /usr/bin that start with the letter c.
bash
Copy code
file /usr/bin/c*
Examples include:

/usr/bin/cat: ELF 64-bit LSB executable
/usr/bin/cp: ELF 64-bit LSB executable

## 11. Using man command, find the command to read a file. (Note: man takes options)
bash
Copy code
man -k read
Example:

less: a command to read a file page by page.
## 12. What is the usage of apropos command?
The apropos command searches the manual page names and descriptions for a given keyword, helping users find commands related to a specific topic.