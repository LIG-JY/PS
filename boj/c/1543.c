#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (2500)

int main(void)
{
    char buffer[LENGTH + 1];
    size_t len;
    char* src;
    char* substr;

    if (fgets(buffer, (LENGTH + 1) + 1, stdin) == NULL) {
        perror("input error");
        return 1;
    }
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }
    --len;
    src = malloc(len + 1);
    if (src == NULL) {
        perror("memory allocation error");
        return 1;
    }
    strcpy(src, buffer);

    if (fgets(buffer, (LENGTH + 1) + 1, stdin) == NULL) {
        perror("input error");
        return 1;
    }
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }
    --len;
    substr = malloc(len + 1);
    if (substr == NULL) {
        perror("memory allocation error");
        return 1;
    }
    strcpy(substr, buffer);

    {
        const char* p = src;
        const char* q = substr;
        size_t src_len = strlen(src);
        size_t substr_len = strlen(substr);
        size_t res = 0;
        const char* end = src + src_len;

        while (p < end) {
            if (*p == *q) {
                size_t i;
                for (i = 1; i < substr_len; ++i) {
                    if (p[i] != q[i]) {
                        goto next;
                    }
                }
                ++res;
                if ((long)substr_len > end - p) {
                    break;
                }
                p += substr_len;
                continue;
            }
        next:
            ++p;
        }

        printf("%zd", res);
    }

    free(substr);
    free(src);

    return 0;
}
