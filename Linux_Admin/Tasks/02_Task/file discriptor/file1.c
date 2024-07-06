#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(){

char * var ;
int fd = 0 ;

int fd1 = 0 
fd = open("/sys/class/leds/input3::capslock/brightness");

read(fd , var , 1);
write(fd1 , var , 1);
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    char var;
    int fd = open("/sys/class/leds/input3::capslock/brightness", O_RDONLY);
    if (fd < 0) {
        perror("Failed to open capslock brightness file");
        return 1;
    }

    int fd1 = open("value.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);
    if (fd1 < 0) {
        perror("Failed to open value.txt file");
        close(fd);
        return 1;
    }

    if (read(fd, &var, 1) < 0) {
        perror("Failed to read capslock brightness");
        close(fd);
        close(fd1);
        return 1;
    }

    if (write(fd1, &var, 1) < 0) {
        perror("Failed to write to value.txt");
        close(fd);
        close(fd1);
        return 1;
    }

    close(fd);
    close(fd1);
    return 0;
}


}