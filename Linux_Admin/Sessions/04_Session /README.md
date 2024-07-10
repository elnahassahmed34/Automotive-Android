# Files and Permissions in Linux

## Devices
- Regular File: A typical file that contains data, such as text or binary data.

```bash
touch myfile.txt
```

- Character Devices: Devices that handle data one character at a time, such as serial ports.
```bash
ls -l /dev/ttyS0
```
- Block Devices: Devices that handle data in blocks, typically storage devices.

```bash
ls -l /dev/sda
```
- Network Devices: Interfaces for network communication, such as Ethernet devices.

```bash
ls -l /sys/class/net/eth0
```

- Directory: A folder that contains other files or directories.

```bash
mkdir mydirectory
```

## Permissions
### Permissions determine who can read, write, or execute a file. 
- There are three categories of users for permissions:
    1. Owner: The user who owns the file.
    2. Group: Users who are members of the file’s group.
    3. Others: All other users.

### Permission Types
    1. Read (r): Permission to read the file.
    2. Write (w): Permission to write to the file.
    3. Execute (x): Permission to execute the file.

#### Commands Requiring Read Permission
   
    - cat: Display file content.
    - less: View file content one screen at a time.
    - grep: Search for text in a file.

#### Commands Requiring write Permission
    - nano: Edit a file.
    - rm: Delete a file.
    - touch: Update file timestamp or create a new file.

## Changing Permissions with chmod
- The chmod command changes the permissions of a file or directory.

### Symbolic Mode:

```bash
chmod u+rwx,g+rx,o+r myfile.txt
```
- This sets read, write, and execute permissions for the owner, read and execute permissions for the group, and read permission for others.

### Octal Mode:

```bash
chmod 755 myfile.txt
```
- This sets read, write, and execute permissions for the owner, and read and execute permissions for the group and others.

## Changing Owner with chown
- The chown command changes the owner of a file or directory.

- Change owner:
```bash
sudo chown newowner myfile.txt
```

- Change owner and group:
```bash
sudo chown newowner:newgroup myfile.txt
```
## Special Permissions
- Set User ID (SUID): When set on an executable file, this allows users to execute the file with the permissions of the file owner.

```bash
chmod u+s myfile
```

- Set Group ID (SGID): When set on a directory, new files created within inherit the group ID of the directory.

```bash
chmod g+s mydirectory
```

- Sticky Bit: When set on a directory, only the file owner can delete or rename the files within.

```bash
chmod +t mydirectory
```


## Processes
- In a Unix-like operating system such as Linux, processes are instances of executing programs. 
- Each process has a unique Process ID (PID) and Parent Process ID (PPID), which are crucial for process management.

- PPID (Parent Process ID): The PPID is the PID of the parent process that started the current process.
- PID (Process ID): The PID uniquely identifies each process running on the system.

### /proc Filesystem
- The /proc directory in Linux is a virtual filesystem that provides detailed information about system processes.

- Process Information: Each directory under /proc represents a running process and contains files with information such as process priority, memory usage, and command-line arguments.

### Example:

```bash
cat /proc/<PID>/status
```
- CPU Architecture: /proc/cpuinfo provides detailed CPU architecture information.

Example:

```bash
cat /proc/cpuinfo
```
- Block Storage Mounts: /proc/mounts lists all mounted filesystems on the system.

Example:

```bash
cat /proc/mounts
```

### Types of Processes
- Processes in Linux can be categorized based on their state:

1. Running: Processes currently executing on the CPU.
2. Ready: Processes waiting for CPU time to execute.
3. Waiting: Processes waiting for an event to occur, such as I/O completion.
4. Terminated: Processes that have finished execution.

### Process Priority
- Process scheduling in Linux is influenced by process priority, managed using commands like nice, renice, and monitoring tools such as top and ps.

- Set Priority: Adjusts the scheduling priority of a process.

Example:

```bash
nice -n 10 ./my_program
```
### View Processes: Lists all processes and their details.

Example:

```bash
ps aux | grep <process_name>
```
### Monitor Processes: Interactive process viewer showing real-time system usage.

Example:

```bash
```

## Signals
- Signals are software interrupts used in Unix-like operating systems to communicate with processes and manage their behavior.

- Send Signal: Sends a signal to a process to perform actions like terminate (SIGKILL), interrupt (SIGINT), or stop (SIGSTOP).

Example:

```bash
kill -9 <PID>
```
- Find and Kill Process: Terminates processes by name.

Example:

```bash
pkill <process_name>

# Manage Background Jobs: Lists and manages background jobs.
jobs
```
## Operating Systems
###  Linux as a Real-Time OS
- Linux supports real-time capabilities through preemptive scheduling, allowing tasks with higher priority to preempt lower-priority tasks. 
- This is crucial for applications requiring deterministic response times, such as industrial automation and embedded systems.

### QNX
- QNX is a microkernel-based real-time operating system known for its reliability and deterministic performance.
- Each process in QNX runs in user space, communicating with the kernel through well-defined microkernel services. 
- This architecture enhances system stability and security.

