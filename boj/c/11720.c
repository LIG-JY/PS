#include <stdio.h>
#include <string.h>
#include <assert.h>
#include <stdlib.h>

#define LENGTH (100)

int main(void)
{
    size_t n;
    char buffer[LENGTH + 1];
    char* numbers;
    char* p;
    int res;

    if (fgets(buffer, LENGTH + 1, stdin) == NULL) { /* 널문자 자리 + 1 */
        return 1;
    }

    if (sscanf(buffer, "%zd", &n) != 1) {
        return 1;
    }

    numbers = malloc(n + 1);    /* 널문자 자리 + 1 */
    if (numbers == NULL) {
        goto dispose;
    }
    if (fgets(buffer, (int)n + 1, stdin) == NULL) {
        goto dispose;
    }
    strncpy(numbers, buffer, n);
    numbers[n] = '\0';
    assert(strlen(numbers) == n);

    res = 0;
    p = numbers;
    while (*p != '\0') {
        res += (*p - '0');
        ++p;
    }
    printf("%d", res);

    return 0;

dispose:
    free(numbers);
    return 1;
}
