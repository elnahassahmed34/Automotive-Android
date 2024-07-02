## README

### Open Source Licenses

Open source licenses are legal frameworks that allow software to be freely used, modified, and shared. They ensure that the software remains open and accessible to everyone. There are various types of open source licenses, each with its own set of permissions and restrictions. Here are some common types:

1. **Permissive Licenses**:
   - **MIT License**: This is a simple and permissive license that allows for reuse within proprietary software provided all copies of the licensed software include the original license.
   - **Apache License 2.0**: This license provides an explicit grant of patent rights from contributors to users. It also allows for the use of the code in proprietary software but requires the inclusion of a copy of the license, a notice of any changes made to the original code, and a statement that the software is provided "as-is" without warranties.

2. **Copyleft Licenses**:
   - **GNU General Public License (GPL)**: This license requires that any modified versions of the software also be open source and distributed under the same GPL license. It ensures that derivative works remain free and open.
   - **GNU Lesser General Public License (LGPL)**: Similar to the GPL but with fewer restrictions, the LGPL allows developers to link to open source libraries in their proprietary software without having to open source their entire codebase.

3. **Other Notable Licenses**:
   - **BSD License**: There are two main types: the original BSD License and the Modified BSD License (also known as the 3-Clause or New BSD License). Both are permissive licenses but have slightly different terms regarding attribution and endorsements.
   - **Creative Commons Licenses**: While not typically used for software, Creative Commons licenses are often used for other types of creative works. They provide a range of permissions and restrictions to suit various needs.

### Linux History

Linux is a free and open-source operating system kernel that was first released on September 17, 1991, by Linus Torvalds. The history of Linux is intertwined with the development of the GNU Project and the open source movement. Here are some key milestones in Linux history:

- **1991**: Linus Torvalds, a computer science student at the University of Helsinki, releases the first version of the Linux kernel. It is initially a hobby project but quickly gains attention from developers around the world.
- **1992**: The Linux kernel is relicensed under the GNU General Public License (GPL), aligning it with the principles of the Free Software Foundation and the GNU Project led by Richard Stallman.
- **1993**: The first Linux distributions, such as Slackware and Debian, are created. These distributions bundle the Linux kernel with various software applications, making it easier for users to install and use Linux.
- **1994**: Version 1.0 of the Linux kernel is released, marking a significant milestone in its development. It is now considered stable and suitable for a wider range of applications.
- **1996**: Tux, the Linux mascot, is created by Larry Ewing. The playful penguin becomes a recognizable symbol of the Linux community.
- **1999**: IBM announces support for Linux, signaling a major shift in the perception of Linux as a viable operating system for enterprise use.
- **2000s**: Linux continues to grow in popularity, with distributions like Red Hat, Ubuntu, and CentOS becoming widely used in both server and desktop environments.
- **2010s**: The rise of cloud computing and containerization technologies like Docker and Kubernetes further drive the adoption of Linux in data centers and development environments.
- **2020s**: Linux remains a dominant force in the technology world, powering a vast array of devices from smartphones (Android) to supercomputers and serving as the backbone of the internet infrastructure.

Linux's success is attributed to its strong community of developers and users, its open development model, and its flexibility and adaptability across different types of hardware and use cases.


## Linux Distributions

Linux distributions (distros) are operating systems based on the Linux kernel, combined with various software packages and tools to provide a complete environment. Different distributions cater to different needs, from general use to specialized applications.

### Types of Linux Distributions

1. **General-Purpose Distributions**:
   - **Ubuntu**: Known for its ease of use and large community. It uses the APT package manager.
   - **Fedora**: Focuses on innovation and integrates the latest software and technologies. It uses the DNF package manager.
   - **OpenSUSE**: Offers stability and ease of use with the YAST configuration tool. It uses the Zypper package manager.

2. **Enterprise Distributions**:
   - **Red Hat Enterprise Linux (RHEL)**: Designed for enterprise environments, offering long-term support and stability. It uses the YUM/DNF package manager.
   - **SUSE Linux Enterprise Server (SLES)**: Provides enterprise-grade solutions with support for various architectures. It uses the Zypper package manager.

3. **Lightweight Distributions**:
   - **Arch Linux**: A minimalistic and flexible distribution that follows a rolling release model. It uses the Pacman package manager.
   - **Alpine Linux**: Known for its small size and security features, making it ideal for containers. It uses the APK package manager.

4. **Specialized Distributions**:
   - **Kali Linux**: Tailored for penetration testing and security research. It uses the APT package manager.
   - **CentOS**: Community-driven and compatible with RHEL, used for servers. It uses the YUM/DNF package manager.

#### Package Management Differences

Different distributions use different package managers to handle software installation, updates, and removal:

- **APT (Advanced Package Tool)**: Used by Debian-based distributions like Ubuntu. Packages are typically .deb files.
- **YUM/DNF (Yellowdog Updater, Modified / Dandified YUM)**: Used by Red Hat-based distributions like RHEL and Fedora. Packages are typically .rpm files.
- **Zypper**: Used by SUSE-based distributions like OpenSUSE. Packages are typically .rpm files.
- **Pacman**: Used by Arch Linux. Packages are typically .pkg.tar.xz files.
- **APK**: Used by Alpine Linux. Packages are typically .apk files.

#### Init Systems

The init system is responsible for initializing the system during the boot process and managing services. Different distributions use different init systems:

- **systemd**: The most widely used init system in modern Linux distributions, including Ubuntu, Fedora, and Arch Linux. It offers parallel service startup, on-demand activation of daemons, and more.
- **SysVinit**: An older init system still used by some distributions for its simplicity and reliability.
- **OpenRC**: Used by distributions like Gentoo, providing a dependency-based init system without using systemd.
- **runit**: A fast and simple init system used by distributions like Void Linux.

#### Libraries

Libraries are collections of pre-compiled routines that programs can use. Differences in libraries can affect compatibility and performance across distributions:

- **GNU C Library (glibc)**: The most common C library used by most Linux distributions.
- **musl**: A lightweight, fast, and simple alternative to glibc, used by Alpine Linux.
- **libc**: Different distributions may package different versions of the standard C library, impacting compatibility with software compiled for other systems.

Linux distributions offer a diverse range of environments tailored to various needs, from personal use to enterprise solutions. Understanding the differences in package management, init systems, and libraries helps in choosing the right distribution for your specific requirements.


## Kernel vs OS

Understanding the distinction between a kernel and an operating system (OS) is fundamental in the world of computing. Here’s a concise explanation of their roles and components.

### Kernel

The kernel is the core component of an operating system. It is responsible for managing the system's resources and facilitating interactions between hardware and software. Key functions of the kernel include:

1. **Scheduler**:
   - The scheduler determines which processes get access to the CPU and for how long. It ensures efficient utilization of the CPU by managing process priorities and execution times.

2. **Dispatcher**:
   - The dispatcher is responsible for the actual switching of the CPU from one process to another. It performs context switching, which saves the state of the currently running process and loads the state of the next process to be executed.

3. **Hardware Resource Management**:
   - The kernel manages hardware resources such as CPU, memory, I/O devices, and more. It handles requests from software to access these resources and ensures they are allocated and used efficiently.

### Operating System (OS)

The operating system is a broader concept that includes the kernel and additional software that provides a complete environment for applications to run. The OS can be divided into two main parts:

1. **Kernel**:
   - As described above, the kernel is the core part of the OS, responsible for managing hardware and low-level system functions.

2. **User Space**:
   - User space includes all the components outside the kernel that provide a user interface and application environment. This includes system libraries, application programs, user interfaces, and utilities.

### Summary

- **Kernel**: 
  - Manages system resources
  - Scheduler handles process priorities and CPU time
  - Dispatcher performs context switching
  - Directly interacts with hardware

- **Operating System (OS)**:
  - Comprises the kernel and user space
  - Provides a complete environment for running applications
  - User space includes libraries, applications, and interfaces

Together, the kernel and user space components form a complete operating system that allows users and applications to interact with the hardware seamlessly.


## Linux Components

Linux, a versatile and powerful operating system, is composed of several key components that work together to provide a complete and functional environment. Here’s an overview of the main components of Linux:

1. **Kernel**:
   - The core of the Linux operating system. It manages hardware resources, including CPU, memory, and I/O devices. The kernel handles system calls, process management, memory management, and hardware drivers.

2. **System Libraries**:
   - Essential libraries that provide standard functions and APIs for software applications. The GNU C Library (glibc) is one of the most commonly used system libraries in Linux.

3. **System Utilities**:
   - Basic command-line tools and utilities for performing system-related tasks. These include tools for file manipulation (e.g., `cp`, `mv`, `rm`), process management (e.g., `ps`, `top`, `kill`), and system monitoring (e.g., `df`, `free`, `uptime`).

4. **Shell**:
   - The command-line interface that allows users to interact with the operating system. Common shells include Bash (Bourne Again Shell), Zsh, and Fish. The shell interprets and executes user commands and scripts.

5. **System Daemons**:
   - Background processes that provide various services, such as logging, scheduling, and networking. Examples include `cron` for scheduling tasks, `sshd` for secure shell access, and `syslogd` for logging system messages.

6. **Graphical Server**:
   - The component that provides the graphical environment. The X Window System (X11) and Wayland are common graphical servers that manage display, input devices, and windowing.

7. **Desktop Environment**:
   - The graphical user interface (GUI) that provides a user-friendly environment for interacting with the system. Popular desktop environments include GNOME, KDE Plasma, XFCE, and LXDE.

8. **Package Manager**:
   - Tools for installing, updating, and managing software packages. Different distributions use different package managers, such as APT for Debian-based systems, YUM/DNF for Red Hat-based systems, Pacman for Arch Linux, and Zypper for SUSE-based systems.

9. **Application Software**:
   - Various user applications that run on the operating system, including web browsers, office suites, media players, and development tools. Examples include Firefox, LibreOffice, VLC, and GCC.

### Summary

Linux is composed of several integral components:
- **Kernel**: Manages hardware and core system functions.
- **System Libraries**: Provide standard APIs and functions.
- **System Utilities**: Basic tools for system management.
- **Shell**: Command-line interface for user interaction.
- **System Daemons**: Background services for various functions.
- **Graphical Server**: Manages graphical display and input.
- **Desktop Environment**: Provides a graphical user interface.
- **Package Manager**: Manages software installation and updates.
- **Application Software**: User applications and tools.

These components work together to form a robust and flexible operating system that can be used for a wide range of applications, from servers to desktops to embedded systems.


## Console, Terminal, and Shell

In the world of computing, especially in Unix-like systems, the terms "console," "terminal," and "shell" are often used. Each serves a distinct purpose in interacting with the operating system. Here’s a brief explanation of these components:

### Console

- **Definition**: The console is the physical or virtual interface that displays system messages and allows user interaction.
- **Appearance**: Often referred to as a "black screen," the console provides a basic text interface without graphical elements.
- **Usage**: It is typically used for system administration tasks, especially in situations where the graphical interface is not available.

### Terminal

- **Definition**: The terminal is a software application that emulates a physical terminal within a graphical environment.
- **Functions**:
  - **Read Value**: Accepts user input from the keyboard.
  - **Save Buffer**: Maintains a buffer of the input and output text.
  - **Print to Console**: Displays the text interface, effectively providing access to the console's capabilities.
- **Examples**: Popular terminal emulators include GNOME Terminal, Konsole, and xterm.

### Shell

- **Definition**: The shell is a command-line interpreter that provides a user interface for accessing the services of the operating system.
- **Functions**:
  - **Call Buffer**: Reads commands from the user (via the terminal).
  - **System Call to Kernel**: Interacts with the kernel by making system calls.
  - **Find and Execute Applications**: Locates applications in specific directories and executes them as processes.
- **Examples**: Common shells include Bash (Bourne Again Shell), Zsh, and Fish.

### Summary

- **Console**:
  - A basic text interface, often called a "black screen."
  - Used for direct interaction with the system without a graphical interface.

- **Terminal**:
  - A software application that emulates a physical terminal.
  - Reads user input, saves it in a buffer, and prints text to the console.

- **Shell**:
  - A command-line interpreter that processes user commands.
  - Reads commands, makes system calls to the kernel, and executes applications.

Together, these components provide a powerful and flexible environment for interacting with Unix-like operating systems, enabling users to perform a wide range of tasks efficiently.

## Kernel Components

The kernel is the core component of an operating system, responsible for managing system resources and facilitating communication between hardware and software. Here’s an overview of key kernel components and their functions:

### 1. Filesystem

- **Definition**: The filesystem is a method for storing and organizing files on storage devices.
- **Functions**:
  - **File Management**: Creates, reads, writes, and deletes files.
  - **Directory Management**: Organizes files into directories for easy navigation.
  - **Permissions**: Manages access control to ensure security.
  - **Mounting**: Integrates different storage devices into the unified filesystem hierarchy.
- **Examples**: Ext4, NTFS, FAT32, XFS.

### 2. Network

- **Definition**: The network subsystem handles communication between computers over a network.
- **Functions**:
  - **Protocol Management**: Implements network protocols (e.g., TCP/IP, UDP).
  - **Data Transmission**: Manages sending and receiving data packets.
  - **Routing**: Directs data packets to their destinations.
  - **Interface Management**: Controls network interfaces (e.g., Ethernet, Wi-Fi).
- **Examples**: Linux uses the Netfilter framework for firewalling and routing.

### 3. Device Driver

- **Definition**: Device drivers are specialized software components that allow the kernel to interact with hardware devices.
- **Functions**:
  - **Hardware Abstraction**: Provides a standard interface for interacting with hardware.
  - **Device Control**: Manages operations specific to a device (e.g., reading from a disk, sending data to a printer).
  - **Interrupt Handling**: Responds to hardware interrupts to process device events.
- **Examples**: Drivers for graphics cards, network cards, storage devices, and input devices.

### 4. Process Management

- **Definition**: Process management is the component that handles the creation, scheduling, and termination of processes.
- **Functions**:
  - **Process Creation**: Initiates new processes and assigns resources.
  - **Scheduling**: Determines which processes run at any given time based on priority and scheduling policies.
  - **Inter-Process Communication (IPC)**: Facilitates communication between processes.
  - **Process Termination**: Properly ends processes and releases resources.
- **Examples**: Linux uses the Completely Fair Scheduler (CFS) for process scheduling.

### Summary

The kernel manages several critical subsystems:
- **Filesystem**: Manages files and directories, ensuring organized storage and access control.
- **Network**: Handles data communication over networks, implementing protocols and managing interfaces.
- **Device Driver**: Provides hardware abstraction and control, enabling the kernel to interact with various devices.
- **Process Management**: Oversees the creation, scheduling, communication, and termination of processes.

These components work together to provide a stable and efficient operating environment, enabling users and applications to interact seamlessly with the system hardware.


## Windows vs Linux Terminology

When transitioning between Windows and Linux, it's helpful to understand the equivalent terms used in each operating system. Here’s a quick comparison:

### 1. Folder vs Directory

- **Windows (Folder)**:
  - A folder is a container used to organize files within the file system.
  - Folders can contain other folders (subfolders) and files.
  
- **Linux (Directory)**:
  - A directory serves the same purpose as a folder, organizing files within the file system.
  - Directories can contain other directories (subdirectories) and files.

### 2. Software (SW) vs Package

- **Windows (Software)**:
  - Software refers to applications and programs that can be installed and run on the operating system.
  - Examples include Microsoft Office, Adobe Photoshop, and web browsers like Chrome.

- **Linux (Package)**:
  - A package is a bundled collection of software and related files required to install, run, and manage applications on the operating system.
  - Packages are managed by package managers like APT (Debian/Ubuntu) and YUM/DNF (Red Hat/Fedora).

### 3. Admin vs Root

- **Windows (Admin)**:
  - An admin (administrator) user has elevated privileges, allowing them to manage system settings, install software, and perform other administrative tasks.

- **Linux (Root)**:
  - The root user is the superuser with full control over the system. Root has the highest level of access, allowing any administrative action on the system.

### 4. Admin Users vs Sudo

- **Windows (Admin Users)**:
  - Admin users are those with administrative privileges. They can perform tasks that standard users cannot, such as installing software and changing system settings.

- **Linux (Sudo)**:
  - `sudo` (short for "superuser do") is a command that allows permitted users to execute commands with root privileges without logging in as the root user.
  - Users granted sudo privileges can perform administrative tasks by prefixing their commands with `sudo`.

### Summary

| Windows Term   | Linux Term   | Description                                      |
|----------------|--------------|--------------------------------------------------|
| Folder         | Directory    | A container for organizing files.                |
| Software (SW)  | Package      | An application or program.                       |
| Admin          | Root         | A user with full system access and control.      |
| Admin Users    | Sudo         | Users with elevated privileges using `sudo`.     |

Understanding these terms helps in navigating and managing both Windows and Linux systems effectively.


## Linux Filesystem Directories

The Linux filesystem hierarchy is structured to organize files and directories efficiently. Here’s an overview of the key directories and examples of their typical contents:

### 1. /home

- **Description**: Contains personal directories for all users.
- **Example**: 
  - `/home/myname`: Personal directory for user "myname".

### 2. /etc

- **Description**: Contains system configuration files.
- **Example**: 
  - `/etc/hostname`: File containing the system's hostname.
  - `/etc/fstab`: File defining how disk partitions, block devices, or remote filesystems should be mounted.

### 3. /bin

- **Description**: Contains essential binary executables.
- **Example**: 
  - `/bin/ls`: List directory contents.
  - `/bin/cp`: Copy files and directories.

### 4. /sbin

- **Description**: Contains system binaries, usually for administrative tasks.
- **Example**: 
  - `/sbin/mkdir`: Make directories.
  - `/sbin/ifconfig`: Configure network interfaces.

### 5. /mnt

- **Description**: Directory for mounting temporary filesystems.
- **Example**: 
  - `/mnt/internal`: Mounted internal storage.

### 6. /media

- **Description**: Directory for mounting removable media.
- **Example**: 
  - `/media/usb`: Mounted external USB storage.

### 7. /boot

- **Description**: Contains files required for the boot process.
- **Example**: 
  - `/boot/vmlinuz`: The Linux kernel.

### 8. /root

- **Description**: Home directory for the root (administrative) user.
- **Example**: 
  - `/root`: Root user's personal directory.

### 9. /dev

- **Description**: Contains device files.
- **Example**: 
  - `/dev/sda`: First SATA drive.
  - `/dev/null`: Null device, discards all data written to it.

### 10. /sys

- **Description**: Virtual filesystem for kernel and system information.
- **Example**: 
  - `/sys/class/net`: Contains network device information.

### 11. /lib

- **Description**: Contains shared library files.
- **Example**: 
  - `/lib/libc.so.6`: GNU C Library.

### 12. /snap

- **Description**: Contains snap packages.
- **Example**: 
  - `/snap/core`: Core snap package.

### 13. /var

- **Description**: Contains variable data files.
- **Example**: 
  - `/var/log`: Log files.
  - `/var/spool`: Spool files.

### 14. /lib32

- **Description**: Contains 32-bit shared libraries.
- **Example**: 
  - `/lib32/libc.so.6`: 32-bit GNU C Library.

### 15. /lib64

- **Description**: Contains 64-bit shared libraries.
- **Example**: 
  - `/lib64/libc.so.6`: 64-bit GNU C Library.

### 16. /lost+found

- **Description**: Used by the system for recovering files after a crash.
- **Example**: 
  - `/lost+found`: Directory created by the filesystem to store recovered files.

### 17. /opt

- **Description**: Contains optional software packages.
- **Example**: 
  - `/opt/vmware`: VMware software.

### 18. /run

- **Description**: Contains runtime data for processes started since the last boot.
- **Example**: 
  - `/run/utmp`: Information about current logins.

### 19. /srv

- **Description**: Contains data for services provided by the system.
- **Example**: 
  - `/srv/ftp`: FTP server data.

### 20. /tmp

- **Description**: Contains temporary files.
- **Example**: 
  - `/tmp/file.txt`: Temporary file that may be deleted upon reboot.

### 21. /cdrom

- **Description**: Legacy mount point for CD-ROMs.
- **Example**: 
  - `/cdrom`: Mount point for CD-ROM.

### 22. /proc

- **Description**: Virtual filesystem providing process and kernel information.
- **Example**: 
  - `/proc/cpuinfo`: Information about the CPU.

### 23. /swapfile

- **Description**: Swap space for virtual memory.
- **Example**: 
  - `/swapfile`: File used for swapping.

### 24. /usr

- **Description**: Contains user-installed software and utilities.
- **Example**: 
  - `/usr/bin`: User binaries.
  - `/usr/lib`: User libraries.

### Summary

The Linux filesystem hierarchy is structured to keep the system organized and efficient:
- **/home**: User directories.
- **/etc**: Configuration files.
- **/bin**: Essential binaries.
- **/sbin**: System binaries.
- **/mnt**: Temporary mount points.
- **/media**: Removable media.
- **/boot**: Boot files.
- **/root**: Root user's home.
- **/dev**: Device files.
- **/sys**: System information.
- **/lib, /lib32, /lib64**: Libraries.
- **/snap**: Snap packages.
- **/var**: Variable data.
- **/lost+found**: Recovered files.
- **/opt**: Optional software.
- **/run**: Runtime data.
- **/srv**: Service data.
- **/tmp**: Temporary files.
- **/cdrom**: CD-ROM mount point.
- **/proc**: Process information.
- **/swapfile**: Swap space.
- **/usr**: User-installed software.

Understanding these directories and their contents is crucial for navigating and managing a Linux system effectively.

//proc -> running process
kernel provide user
1-to know running process
2-consume resource
size in ram not in hard disk


//sys systme
1-user interact HW through file
2-provided by kernel
size in ram not in hard disk
//gpio

//dev device node
dev/tty


compare between /sys and /dev


## /proc, /sys, and /dev in Linux

Linux provides several special directories (/proc, /sys, and /dev) that facilitate interactions between userspace applications and the kernel, especially concerning processes, system information, and hardware devices.

### /proc

- **Purpose**: Provides a virtual filesystem interface to kernel data structures.
- **Functionality**:
  1. **View Running Processes**: `/proc` allows users to view detailed information about running processes, such as process IDs, memory usage, and CPU usage.
  2. **Resource Consumption**: Users can monitor resource consumption by processes, including memory and CPU usage.
  3. **Size**: Data in `/proc` resides in RAM, not on the hard disk, and dynamically updates to reflect the current system state.

### /sys

- **Purpose**: Virtual filesystem for exposing kernel data structures and device information.
- **Functionality**:
  1. **User Interaction with Hardware**: `/sys` allows userspace applications to interact with hardware devices and kernel modules using files and directories.
  2. **Provided by Kernel**: It is provided directly by the kernel to expose information and configurations related to devices and drivers.
  3. **Size**: Similar to `/proc`, data in `/sys` resides in RAM, not on the hard disk, and provides real-time information about the system and hardware status.

### /dev

- **Purpose**: Contains device nodes that allow user-space programs to communicate with hardware devices.
- **Functionality**:
  - **Device Nodes**: `/dev` provides special device files (nodes) that represent physical and virtual devices.
  - **Examples**: `/dev/tty` represents the controlling terminal device.
  - **Size**: Device nodes in `/dev` are small metadata files stored in the filesystem, with actual data transfer occurring through memory buffers.

### Comparison between /sys and /dev

| Feature        | /sys                               | /dev                                      |
|----------------|------------------------------------|-------------------------------------------|
| **Purpose**    | Exposes kernel data and device info| Provides access to hardware devices       |
| **Interaction**| Configuration and monitoring       | Input/output operations                   |
| **Data Size**  | Resides in RAM                     | Resides in RAM                            |
| **File Type**  | Virtual filesystem                 | Special device files (nodes)              |
| **Examples**   | `/sys/devices`, `/sys/class`       | `/dev/tty`, `/dev/sda`                    |
| **Usage**      | Configuration and monitoring       | Device input/output operations            |

### Summary

- **/proc**: Virtual filesystem for accessing process and system information, useful for monitoring and managing running processes and resource consumption.
- **/sys**: Virtual filesystem exposing kernel data structures and device information, facilitating user interaction with hardware devices and kernel modules.
- **/dev**: Contains device nodes representing physical and virtual devices, enabling user-space programs to communicate with hardware.

Understanding these directories helps users effectively manage processes, monitor system resources, interact with hardware, and configure kernel parameters in Linux.


## Command Line Interface (CLI)

The Command Line Interface (CLI) is a text-based interface used to interact with the operating system or software by typing commands. Here are some basic commands and concepts related to CLI usage:

#### Navigation Commands

```bash
# cd (Change Directory)
# Changes the current working directory.
cd /home/user

# ls (List)
# Lists files and directories in the current directory.
ls -l

# pwd (Print Working Directory)
# Prints the current working directory path.
pwd
Information Commands
bash
Copy code
# help
# Provides built-in help for shell commands.
help cd

# man (Manual)
# Displays the manual pages for commands.
man ls

# info
# Provides information about commands and other topics.
```

### Types of Commands

Commands in the CLI can be categorized into three types:

- Internal Commands: Built-in commands provided by the shell itself.
Example: cd, pwd

- External Commands: Programs located in separate executable files.
Example: ls, grep

- Alias Commands: Custom shortcuts or aliases defined by users.
Example: alias ll='ls -l'

### man -k or apropos
man -k: Searches the manual page names and descriptions for a keyword.
Example: man -k string searches for commands related to "string".

### Relative Path vs Absolute Path
- Relative Path: Specifies a location relative to the current directory.
Example: cd Documents (moves to ~/Documents if current directory is ~).

- Absolute Path: Specifies the complete path starting from the root directory (/).
Example: cd /home/user/Documents.

Understanding these CLI basics allows users to navigate, execute commands, and manage files efficiently in Unix-like operating systems.



### Command Line Basics

#### Create Directory

- **mkdir**: Command to create a new directory.
  Example: `mkdir mydir`

#### Remove Directory

- **rmdir**: Removes an empty directory.
  Example: `rmdir mydir`

- **rm -r**: Recursive removal of files and directories.
  Example: `rm -r mydir`

#### Create File

- **touch**: Command to create an empty file or update file timestamps.
  Example: `touch myfile.txt`

#### Delete File

- **rm**: Removes files.
  Example: `rm myfile.txt`

#### Copy Files and Directories

- **cp**: Copies files and directories.
  Example: `cp -r mydir/* ~/ITI`

#### Move Files and Directories

- **mv**: Moves or renames files and directories.
  Example: `mv myfile.txt newfile.txt`

#### Wildcards

- **Wildcard Examples**:
  - `ls ~/h*o`: Lists files starting with 'h' and ending with 'o'.
  - `ls ~/h???o`: Lists files starting with 'h', followed by three characters, and ending with 'o'.
  - `ls ~/h[a-l]??o`: Lists files starting with 'h', followed by a character between 'a' and 'l', and then two more characters before ending with 'o'.
  - `cp ~/*.c source`: Copies all files with the extension `.c` from the home directory to the `source` directory.
  - `cp {*.c,*.pdf} source`: Copies files with either `.c` or `.pdf` extension to the `source` directory.

These basic commands and techniques allow users to efficiently manage directories, files, and perform operations using wildcards in a Unix-like command line interface.


# Understanding System Concepts: Variables, Processes, Threads, and Cores

## Variables: Local vs Global

### Local Variables
- **Definition**: Local variables are defined within a specific scope, such as within a function or script.
- **Example**:
```bash
  function myfunc {
      local var=3
      echo "Local variable: $var"
  }
  myfunc
```

### Global Variables

- Definition: Global variables are accessible across different scopes within a shell session.
Example:
```bash
VAR=3
echo "Global variable: $VAR"
#Exporting Variables
#Export: Allows a local variable to be accessed in child processes.
export VAR=3
#Unexport: Removes the variable from the environment of child processes.
export -n VAR
```

## Processes vs Threads
- Processes
Definition: A process is an instance of a program that is being executed.
Resource Sharing: Processes have separate memory spaces and must use inter-process communication (IPC) to share data.
Example: Each browser tab running independently is a separate process.
- Threads
Definition: Threads are lightweight processes within a process that share the same memory space.
Communication: Threads can communicate with each other directly through shared memory.
Example: A web server handling multiple client requests using threads.

## Core and Multi-core Processors
- CPU Cores
Definition: A CPU core is an independent processing unit capable of executing instructions.
- Multi-core CPUs: CPUs with multiple cores allow for parallel execution of processes and threads.
- Example: A quad-core processor can execute four sets of instructions simultaneously.
Benefits
- Performance: Enables parallel processing, improving overall system performance.
Concurrency: Allows multiple tasks to be executed simultaneously.

## Process and Thread Execution
Processes: Can utilize multiple cores to run different processes concurrently.
Threads: Can execute on different cores within a process, sharing resources more efficiently than separate processes.

## Summary
Understanding variables, processes, threads, and CPU cores is crucial for optimizing system performance and managing resource allocation effectively in computing environments. Variables control data scope, processes manage program execution, threads facilitate concurrent operations, and CPU cores enable parallel processing to meet modern computing demands.


# Understanding Environment Variables

Environment variables are dynamic named values that affect the behavior of processes in Unix-like operating systems. Here’s a guide to commonly used environment variables, their locations, and how to manage them.

## Common Environment Variables

### 1. HOME

- **Location**: Stores the path to the user's home directory.

### 2. PWD

- **Location**: Stores the current working directory of the shell or script.

### 3. USER

- **Location**: Stores the username of the current user.

### 4. PATH

- **Location**: Stores a colon-separated list of directories where executable files are located.

## Setting Environment Variables

Environment variables are typically set in shell configuration files such as `~/.bashrc`, `~/.bash_profile`, or by scripts during system startup.

### Temporary Change

To temporarily change an environment variable in the current shell session:
```bash
VARNAME=value   # Set the variable
export VARNAME  # Export it to make it available to child processes
```
### Permanent Change
To permanently change an environment variable for a user, modify their shell configuration file and add:

```bash
export VARNAME=value
```
Summary
Understanding environment variables is crucial for customizing system behavior and ensuring efficient operation of shell scripts and applications in Unix-like systems.


# Understanding the PATH Environment Variable

The `PATH` environment variable is a crucial part of Unix-like operating systems, containing a colon-separated list of directories where executable files are located. Here’s a guide to understanding `PATH` and various methods to adjust it.

## What is the PATH Variable?

- **Definition**: `PATH` specifies directories where the system looks for executable files without needing to provide a full path to the executable.
- **Default Value**: Typically includes directories like `/usr/bin`, `/bin`, `/usr/local/bin`, etc.

## Adjusting the PATH Variable

### 1. Temporary Adjustment

To temporarily modify `PATH` in the current shell session:
```bash
PATH=$PATH:/new/directory   # Append a directory to PATH
export PATH                 # Export PATH to make it available to child processes
```

### 2. Permanently Adjusting for a User
To permanently modify PATH for a user, edit their shell configuration file (~/.bashrc, ~/.bash_profile, etc.) and add:

```bash
export PATH=$PATH:/new/directory
```
### 3. System-wide Adjustment
To modify PATH system-wide for all users, add the desired directories to the system-wide configuration files (/etc/profile, /etc/environment, etc.).

### 4. Using Profile Scripts
You can also create or modify shell profile scripts (/etc/profile, /etc/profile.d/*.sh, etc.) to set PATH for all users or specific users.

### 5. Adjusting PATH in Scripts
Inside shell scripts, you can modify PATH locally for the script's execution by using:

```bash
#!/bin/bash
PATH=$PATH:/additional/path
```

### Summary
Understanding how to adjust the PATH environment variable is essential for managing executable files and ensuring that commands and programs are found and executed correctly in Unix-like systems.


# Understanding Command Types and Shells

## Types of Commands

Commands in Unix-like operating systems can be categorized into three types: external commands, internal commands, and aliases.

### 1. External Commands

- **Definition**: Commands that are executable files located in directories specified in the `PATH` environment variable.
- **Examples**: All commands found in `/bin`, `/usr/bin`, `/usr/sbin`, etc.
  - Examples include `ls`, `grep`, `find`, and `awk`.

### 2. Internal Commands

- **Definition**: Built-in commands provided by the shell itself, not external executable files.
- **Examples**: Internal commands provided by the shell (e.g., `/bin/bash`).
  - Examples include `echo`, `source`, `export`, `exit`, and `.`.

### 3. Aliases

- **Definition**: Custom shortcuts created by users to represent other commands or sequences of commands.
- **Examples**:
  - `alias ll='ls -l'`
  - `alias gs='git status'`

## Types of Shells

A shell is a command-line interpreter that provides a user interface for accessing the services of the operating system. There are several types of shells available in Unix-like systems.

### 1. Bash (Bourne Again Shell)

- **Definition**: The most commonly used shell, known for its compatibility with the Bourne shell (`sh`) and additional features.
- **Location**: Usually found at `/bin/bash`.

### 2. Zsh (Z Shell)

- **Definition**: An extended version of the Bourne shell with many improvements and additional features.
- **Location**: Typically found at `/bin/zsh`.

### 3. Ksh (Korn Shell)

- **Definition**: A shell developed by David Korn, which includes features of both the Bourne shell and the C shell.
- **Location**: Often found at `/bin/ksh`.

### 4. Tcsh (TENEX C Shell)

- **Definition**: An enhanced version of the C shell (`csh`), featuring command-line editing and other improvements.
- **Location**: Usually found at `/bin/tcsh`.

### 5. Fish (Friendly Interactive Shell)

- **Definition**: A user-friendly shell that includes syntax highlighting, autosuggestions, and other interactive features.
- **Location**: Typically found at `/usr/bin/fish`.

## Summary

Understanding the types of commands and shells available in Unix-like systems is crucial for efficient system administration and script writing. External commands are standalone executables, internal commands are built into the shell, and aliases provide customizable shortcuts. Different shells offer various features and capabilities, with Bash being the most commonly used.























