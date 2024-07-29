# system d

## types of process
- foreground : process running + user interacts
- background : process running - user interact

- Orphan process : whose father has died
- Zombie process : give resources and exit status to its paren
- daemon : running in back ground

## Units
.target , service , network , mount , socket

### Header section [Unit]
- desc , doc , source path , after , before ,want , requires


### Service
- Type 
      - simple  : app coupled with service
      - oneshot :
      - forking : not coupled with service
- Exec Start = app to run 
- EXec stop  = run this app when you got stop signal
- workdir = where the script
- restart =  (on-failure | always )


## systemctl
- start , stop , cat , edit

## targets -> group of services
### [install] -> wanted by 
- creation of new unit under /etc/systemd/sytem


#### lab
- systemctl get-default
      - graphical.target
- systemctl set-default multi_user.targe


## lab -> make a service which run app (print hello every 3 sec)

### 1-main.c
```c
#include <stdio.h>
#include <unistd.h>  // Required for the sleep function

int main() {
    while (1) {
        printf("hello nahass\n");
        fflush(stdout);  // Ensure the output is flushed immediately
        sleep(5);  // Wait for 5 seconds
    }
    return 0;
}
```
```sh
gcc main.c -o main
cp main /bin
```

### 2 - make service /etc/systemd/system/deamonapp.service
```
[Unit]
Description=app server
[Service]
Type=simple
ExecStart=/bin/main

[Install]
WantedBy=multi-user.target
```

###  3- test the service
```sh
# get the status
sudo systemctl status deamonapp.service 

# make link in /etc/systemd/system/multi-user.target.wants/deamonapp.service.
sudo systemctl enable deamonapp.service 

#  show status
sudo systemctl status deamonapp.service 

# start service
sudo systemctl start deamonapp

# show the logs of app
sudo journalctl -u deamonapp.service 

#stop the service
sudo systemctl stop deamonapp

# remove link in /etc/systemd/system/multi-user.target.wants/deamonapp.service.
sudo systemctl disable deamonapp.service 
```
