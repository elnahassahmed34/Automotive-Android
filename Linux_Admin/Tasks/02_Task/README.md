## 1. List the available shells in your system.
To list the available shells on your system, you can check the `/etc/shells` file.

```sh
cat /etc/shells
```
### output
- /bin/sh
- /bin/bash
- /usr/bin/bash
- /bin/rbash
- /usr/bin/rbash
- /usr/bin/sh
- /bin/dash
- /usr/bin/dash

## 2. List the environment variables in your current shell.
To list all environment variables in your current shell, use the printenv or env command.

Command:

```sh
printenv
```

or

```sh
env
```
 
### output :
- XDG_CURRENT_DESKTOP=ubuntu:GNOME
- VTE_VERSION=6800
- WAYLAND_DISPLAY=wayland-0
- INVOCATION_ID=2c6f327af8ef4f21963bea418ef1ac89
- MANAGERPID=1511
- GNOME_SETUP_DISPLAY=:1
- LESSCLOSE=/usr/bin/lesspipe %s %s
- XDG_SESSION_CLASS=user
- TERM=xterm-256color
- LC_IDENTIFICATION=en_US.UTF-8
- LESSOPEN=| /usr/bin/lesspipe %s
- USER=nahass
- DISPLAY=:0
- SHLVL=1
- LC_TELEPHONE=en_US.UTF-8
- QT_IM_MODULE=ibus
- LC_MEASUREMENT=en_US.UTF-8
- DBUS_STARTER_ADDRESS=unix:path=/run/user/1000/bus,guid=d6f8d7373eecaa2dedbdd12a6688dbe3
- PAPERSIZE=letter
- TILIX_ID=1d7a2dde-2cb7-4f3e-a9a9-86178e8d4ed2
- XDG_RUNTIME_DIR=/run/user/1000
- LC_TIME=en_US.UTF-8
- JOURNAL_STREAM=8:32832
- XDG_DATA_DIRS=/usr/share/ubuntu:/usr/local/share/:/usr/share/:/var/lib/snapd/desktop
- PATH=/usr/lib:/home/nahass/.local/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/snap/bin
- GDMSESSION=ubuntu
- DBUS_SESSION_BUS_ADDRESS=unix:path=/run/user/1000/bus,guid=d6f8d7373eecaa2dedbdd12a6688dbe3
- LC_NUMERIC=en_US.UTF-8
- _=/usr/bin/printenv

## 3. Display your current shell name.

Command:

```sh
echo $SHELL
```

### output
- /bin/bash


## 4. Execute the following command: echo \ then press enter. What is the purpose of \?
Command:

```sh
echo \
```
Explanation:
The backslash (\) is used as an escape character in the shell. When used at the end of a line, it indicates that the command continues on the next line. It effectively allows multi-line commands to be entered in the shell.

## 5. Create a Bash shell alias named PrintPath for the “echo $PATH” command.

```sh
alias PrintPath="echo $PATH"
```


