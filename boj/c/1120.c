#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (102)

int main(void)
{
    char buffer[LENGTH + 1];
    size_t len;
    char* token;
    char* A = NULL;
    char* B = NULL;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        perror("input error!");
        return 1;
    }
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }
    --len;

    {
        token = strtok(buffer, " ");
        A = malloc(strlen(token));
        if (A == NULL) {
            perror("memory allocation error");
            goto dispose;
        }
        strcpy(A, token);

        token = strtok(NULL, " ");
        B = malloc(strlen(token));
        if (B == NULL) {
            perror("memory allocation error");
            goto dispose;
        }
        strcpy(B, token);
    }

    {
        const char* p = B;
        const char* end = p + strlen(B);
        size_t len_a = strlen(A);
        size_t min = len_a;

        while (end - p >= (long)len_a) {
            size_t i;
            size_t diff_cnt = 0;
            for (i = 0; i < len_a; ++i) {
                if (*(p + i) != *(A + i)) {
                    ++diff_cnt;
                }
            }
            if (diff_cnt < min) {
                min = diff_cnt;
            }
            ++p;
        }

        printf("%zd", min);
    }

dispose:
    free(B);
    free(A);

    return 0;
}
