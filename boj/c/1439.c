#include <stdio.h>
#include <string.h>

#define LENGTH (999999)

int main(void)
{
    char buffer[LENGTH + 1];
    int z_cnt = 0;
    int o_cnt = 0;
    char* ptr;
    char start = 0;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        perror("input error");
        return 1;
    }
    if (buffer[strlen(buffer) - 1] == '\n') {
        buffer[strlen(buffer) - 1] = '\0';
    }

    ptr = buffer;
    while (*ptr != '\0') {
        if (start != *ptr) {
            start = *ptr;
            if (start == '0') {
                ++z_cnt;
            } else {
                ++o_cnt;
            }
            continue;
        }
        ++ptr;
    }

    if (z_cnt <= o_cnt) {
        printf("%d", z_cnt);
    } else {
        printf("%d", o_cnt);
    }

    return 0;
}
