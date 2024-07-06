## 1. List the user commands and redirect the output to /tmp/commands.list

**Command**:
```sh
compgen -c > /tmp/commands.list
```

## 2. Edit your profile to display the date at login and change your prompt permanently.

Steps:

1. Open the profile file for editing:
```sh
nano ~/.bashrc
```
## 2. Add the following lines to the end of the file:
```sh
echo "Login date: $(date)"
PS1='[\u@\h \W]\$ '
```
- Save the file and exit.

## 3. What is the command to count the words in a file or number of files in a directory?
- Count words in a file:
```sh
Copy code
wc -w filename
```
- Count number of files in a directory:
```sh
ls -1 | wc -l
```

## 4. What happens if you execute: 

### a. cat filename1 | cat filename2
- This will concatenate the contents of filename1 and filename2 and display them sequentially.

### b. ls | rm
This will try to pass the output of ls to rm, which will fail because rm expects arguments as filenames to remove, not input from a pipe.

### c. ls /etc/passwd | wc -l
- This will list the file /etc/passwd and pipe the output to wc -l, resulting in the number 1 since there is only one line of output.

### 5. Write a command to search for all files on the system named “.profile”.

```sh
find / -name ".profile"
#or
locate .profile
```

## 6. List the inode numbers of /, /etc, /etc/hosts.

```sh
ls -i / /etc /etc/hosts
```

## 7. Create a symbolic link of /etc/passwd in /boot.
Command:

```sh
ln -s /etc/passwd /boot/passwd_link
```

## 8. Create a hard link of /etc/passwd in /boot. Could you? Why?

```sh
ln /etc/passwd /boot/passwd_hardlink
```

## 9. Echo \ it will jump to the next line, and will print >. Notice the prompt > what is that? and how can you change it from > to :.


- The \ character is an escape character, indicating that the command continues on the next line.
- The > prompt is the secondary prompt (PS2), which appears when a command is not yet complete.

- Command to change PS2:

```sh
export PS2=": "
```

- PS2 is the environment variable for the secondary prompt.
- export PS2=": " changes the secondary prompt to :.

- To make this change permanent, add the export PS2=": " command to your ~/.bashrc or ~/ profile file.