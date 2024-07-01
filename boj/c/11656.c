#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (1000)

static int comp(const void* a, const void* b);

int main(void)
{
    char buffer[LENGTH + 1];
    size_t len;
    char** p;
    size_t i;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        perror("input error");
        return 1;
    }
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }
    --len;

    p = malloc(sizeof(char*) * len);
    if (p == NULL) {
        perror("memory allocation failed");
        return 1;
    }
    for (i = 0; i < len; ++i) {
        p[i] = buffer + i;
    }
    qsort(p, len, sizeof(char*), comp);

    for (i = 0; i < len; ++i) {
        printf("%s\n", p[i]);
    }

    free(p);

    return 0;
}

static int comp(const void* a, const void* b)
{
    const char** str_a = (const char**)a;
    const char** str_b = (const char**)b;

    return strcmp(*str_a, *str_b);
}