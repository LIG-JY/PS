#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (10) /* N은 1,000,000,000보다 작거나 같은 자연수 */

static int ascii_comp(const void* a, const void* b);

int main(void)
{
    char buffer[LENGTH + 1];    /* 널문자 1자리 */

    if (fgets(buffer, LENGTH + 1, stdin) == NULL) {
        perror("error while reading input");
        return 1;
    }

    qsort(buffer, strlen(buffer), sizeof(char), ascii_comp);

    printf("%s", buffer);

    return 0;
}

static int ascii_comp(const void* a, const void* b)
{
    char* ascii_a = (char*)a;
    char* ascii_b = (char*)b;

    return *ascii_b - *ascii_a;
}
