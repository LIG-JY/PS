#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (100000)

static int comp(const void* a, const void* b);

int main(void)
{
    char buffer[LENGTH + 1];
    char* ptr = buffer;
    int sum = 0;
    int flag = 0;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        perror("input error");
        return 1;
    }
    if (buffer[strlen(buffer) - 1] == '\n') {
        buffer[strlen(buffer) - 1] = '\0';
    }

    while (*ptr != '\0') {
        sum += (*ptr - '0');
        ++ptr;
    }

    if (sum % 3 == 0) {
        qsort(buffer, strlen(buffer), sizeof(char), comp);
        if (buffer[strlen(buffer) - 1] == '0') {
            flag = 1;
        }
    }
    if (flag == 1) {
        printf("%s", buffer);
    } else {
        printf("%d", -1);
    }

    return 0;
}

static int comp(const void* a, const void* b)
{
    const char* c_a = (const char*)a;
    const char* c_b = (const char*)b;

    return *c_b - *c_a;
}