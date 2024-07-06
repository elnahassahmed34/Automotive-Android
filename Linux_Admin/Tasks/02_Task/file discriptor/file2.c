#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    char var;
    int fd = open("value.txt", O_RDONLY);
    if (fd < 0) {
        perror("Failed to open value.txt file");
        return 1;
    }

    if (read(fd, &var, 1) < 0) {
        perror("Failed to read from value.txt");
        close(fd);
        return 1;
    }
    close(fd);

    int capslock_fd = open("/sys/class/leds/input3::capslock/brightness", O_WRONLY);
    if (capslock_fd < 0) {
        perror("Failed to open capslock brightness file");
        return 1;
    }

    var = (var == '0') ? '1' : '0';

    if (write(capslock_fd, &var, 1) < 0) {
        perror("Failed to write to capslock brightness");
        close(capslock_fd);
        return 1;
    }

    close(capslock_fd);
    return 0;
}
