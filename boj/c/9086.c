#include <stdio.h>
#include <string.h>

#define LENGTH (1024)

int main(void)
{
    int T = 0;
    char line[LENGTH];
    char buffer[LENGTH];


    if (fgets(line, LENGTH, stdin) == NULL) {
        return 1;
    }
    if (sscanf(line, "%d", &T) != 1) {
        return 1;
    }

    while (T) {
        if (fgets(buffer, LENGTH, stdin) != NULL) {
            char* p;
            char start;
            char end;  /* 개행 문자를 제외하고 마지막 문자 */

            p = buffer;
            start = buffer[0];
            while (*p != '\0' && *p != '\n') {
                ++p;
            }
            end = *(p - 1);
            printf("%c%c\n", start, end);
        } else {
            return 1;
        }
        --T;
    }


    return 0;
}
