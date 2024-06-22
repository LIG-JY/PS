#include <stdio.h>
#include <string.h>

#define LENGTH (100) /* 단어의 길이는 최대 100 */

int main(void)
{
    char buffer[LENGTH + 1]; /* 개행문자 1자리 포함 */
    const char* p;
    int cnt = 0;

    if (fgets(buffer, LENGTH + 1, stdin) == NULL) {
        clearerr(stdin);
        perror("error");
    }
    buffer[LENGTH] = '\0';

    p = buffer;
    while (*p != '\0' && *p != '\n') {
        if (*p == 'c') {
            char next = *(p + 1);
            if (next == '=') {
                ++p;
                goto next;
            }

            if (next == '-') {
                ++p;
                goto next;
            }
        } else if (*p == 'd') {
            char next = *(p + 1);
            if (next == 'z') {
                char next_next = *(p + 2);
                if (next_next == '=') {
                    p += 2;
                    goto next;
                }
            }

            if (next == '-') {
                ++p;
                goto next;
            }
        } else if (*p == 'l') {
            char next = *(p + 1);
            if (next == 'j') {
                ++p;
                goto next;
            }
        } else if (*p == 'n') {
            char next = *(p + 1);
            if (next == 'j') {
                ++p;
                goto next;
            }
        } else if (*p == 's') {
            char next = *(p + 1);
            if (next == '=') {
                ++p;
                goto next;
            }
        } else if (*p == 'z') {
            char next = *(p + 1);
            if (next == '=') {
                ++p;
                goto next;
            }
        } else {
            goto next;
        }
    next:
        ++cnt;
        ++p;
    }

    printf("%d", cnt);

    return 0;
}
