#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (50) /* 단어의 길이는 최대 50 */

static void dispose(void* addr, size_t N);

static int str_comp_func(const void* a, const void* b);

int main(void)
{
    int N;
    int i;
    char buffer[LENGTH + 2]; /* 개행문자 1자리, 널문자 1자리 포함 */
    char** words = NULL;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        clearerr(stdin);
        perror("Failed to input first line!");
        return 1;
    }
    if (sscanf(buffer, "%d", &N) != 1) {
        perror("Failed to assign value to N!");
        return 1;
    };
    /* 문자열 입력 */
    words = malloc(sizeof(char*) * N);
    if (words == NULL) {
        perror("Memory allocation failure!");
        dispose(words, N);
        return 1;
    }

    for (i = 0; i < N; ++i) {
        words[i] = NULL;
    }

    for (i = 0; i < N; ++i) {
        char* word;
        size_t len;

        if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
            clearerr(stdin);
            perror("Failed to input lines!");
            return 1;
        }

        len = strlen(buffer);
        if (buffer[len - 1] == '\n') {
            buffer[len - 1] = '\0';
            --len;
        }

        word = malloc(len + 1);
        if (word == NULL) {
            perror("Memory allocation failure!");
            dispose(words, N);
            return 1;
        }
        strncpy(word, buffer, len);
        word[len] = '\0';
        words[i] = word;
    }

    qsort(words, N, sizeof(char*), str_comp_func);

    for (i = 0; i + 1 < N; ++i) {
        if (strcmp(words[i], words[i + 1]) == 0) {
            continue;
        }
        printf("%s\n", words[i]);
    }
    printf("%s\n", words[N - 1]);

    dispose(words, N);

    return 0;
}

static void dispose(void* addr, size_t N)
{
    int i;
    char** p = (char**)addr;

    for (i = 0; i < N; ++i) {
        free(p[i]);
        p[i] = NULL;
    }
    free(p);
    p = NULL;
}

static int str_comp_func(const void* a, const void* b)
{
    const char** str_a = (const char**)a;
    const char** str_b = (const char**)b;
    size_t len_a = strlen(*str_a);
    size_t len_b = strlen(*str_b);

    if (len_a == len_b) {
        return strcmp(*str_a, *str_b);
    }

    return (int)(len_a - len_b);
}
