# Package Managers

## Debian-based Package Managers

### dpkg
- **dpkg** is the base package management system for Debian.
- It handles the installation, removal, and providing information about `.deb` packages.

#### Common dpkg Commands:
- Install a package: `dpkg -i package_name.deb`
- Remove a package: `dpkg -r package_name`
- Upgrade a package: `dpkg -u package_name.deb`

### apt
- **apt** stands for Advanced Package Tool.
- It fetches packages from repositories and resolves dependencies automatically.
- `apt` is essentially a front-end to `dpkg` with additional features for handling dependencies.

#### Common apt Commands:
- Update package list: `apt update`
- Upgrade installed packages: `apt upgrade`
- Install a package: `apt install package_name`
- Remove a package: `apt remove package_name`

### apt vs Manual Installation
- **apt** simplifies the process of installing software compared to manually downloading and installing packages on Windows. It ensures all dependencies are resolved and installed.

## Red Hat-based Package Managers

### rpm
- **rpm** stands for Red Hat Package Manager.
- It is used for managing `.rpm` packages on Red Hat-based systems.

#### Common rpm Commands:
- Install a package: `rpm -i package_name.rpm`
- Remove a package: `rpm -e package_name`
- Upgrade a package: `rpm -U package_name.rpm`

### yum
- **yum** stands for Yellowdog Updater Modified.
- It is a package manager for RPM-based distributions that resolves dependencies automatically.

#### Common yum Commands:
- Install a package: `yum install package_name`
- Remove a package: `yum remove package_name`
- Update all packages: `yum update`

## Snap Package Manager

### snap
- **snap** packages are like ISO images containing all the dependencies and libraries needed for the software to run.
- Snap packages are distribution-independent and can be installed on any system that supports `snapd`.

### Features of snap:
- Distribution-independent.
- Packages are self-contained and include all dependencies.
- Snap packages are updated automatically.

### Limitations of snap:
- Snap does not support Raspberry Pi (only for x86/64 architectures).

### Common snap Commands:
- Install a package: `snap install package_name`
- Remove a package: `snap remove package_name`
- List installed packages: `snap list`

### Additional Information
- **snap store**: A centralized repository where snap packages can be found and installed.

## Package Management Workflow

### APT Workflow
- `apt install`: Downloads and installs a package along with its dependencies.
- `apt upgrade`: Upgrades all installed packages to their latest versions.
- `apt update`: Fetches the latest list of available packages from the repositories.

## Archiving and Compressing in Linux
### Archiving
- Archiving involves consolidating multiple files into a single file for easier storage or distribution.

- Create an Archive (tar -cf):

```bash
tar -cf archive.tar file1 file2 file3
```
- c: Create a new archive.
- f: Specify the archive file name.

### Extract from an Archive (tar -xf):

```bash
tar -xf archive.tar -C /destination/path
```
- x: Extract files from an archive.
- f: Specify the archive file name.
- -C: Specify the destination directory.

## Compressing
- Compressing reduces file size using various algorithms like gzip, xz, or bzip2.

### Compression Commands:

- gzip: gzip file.txt creates file.txt.gz.
- xz: xz file.txt creates file.txt.xz.
- bzip2: bzip2 file.txt creates file.txt.bz2.

### Decompressing:

```bash
gunzip file.txt.gz
```
- Decompresses file.txt.gz to file.txt.

## User, Group, and Others
- Linux distinguishes users and groups to manage file access permissions.

### types 
1. normal users 1000-40K
2. system user 1-199 ssh example linking with kernel
3. service user 200-999 x11 service running with application

## User Management:

- Create a New User: sudo adduser username
- Modify User Groups: sudo usermod -aG groupname username
- View User Details: id username

## File System Basics:

- /etc/passwd: Stores user account information.
- /etc/shadow: Contains encrypted passwords.
- sudo: Privilege escalation tool allowing users to execute commands as another user.

### Example Lab: Adding a User to sudo Group

```bash
#Create a new group:
sudo groupadd hero

#Edit sudoers file:
sudo visudo

#Add the following line:
%hero  ALL=(ALL:ALL) ALL

#Add a user and check details:
sudo adduser ahmed
sudo cat /etc/passwd | grep ahmed

#Test sudo access:
su - ahmed
sudo visudo

#Ensure ahmed is listed in sudoers for hero group.
```

## soft link vs hard link

- if we have two partitions : 
p1    0x00     p2 0x00
file  0x24     link  0x24

- softlink can link the file create inode cary info of file inode
- hardlink can't  becaus it don't create new indoe , ptr to same inode of file
