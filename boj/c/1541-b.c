#include <stdio.h>
#include <string.h>

#define LENGTH (50)
#define FALSE (0)
#define TRUE (1)

int main(void)
{
    char buffer[LENGTH + 2]; /* 개행문자 1, 널문자 1 */
    size_t len = 0;
    const char* p;
    int num = 0;
    int is_negative = FALSE;
    int res = 0;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        perror("reading input error");
        return 1;
    }

    /* 개행 문자 제거 */
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }

    p = (const char*)buffer;
    while (*p != '\0') {
        if (*p != '-' && *p != '+') {
            num = 10 * num + (*p - '0');
        } else {    /* 부호를 만나면 */
            if (is_negative == FALSE) {
                res += num;
            } else {    /* 음수를 만나고 부호를 만나는 경우 */
                res -= num;
            }

            if (*p == '-') {
                is_negative = TRUE;
            }

            num = 0;
        }
        ++p;
    }

    if (is_negative == FALSE) {
        res += num;
    } else {
        res -= num;
    }

    printf("%d", res);

    return 0;
}
