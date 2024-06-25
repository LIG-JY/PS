#include <stdio.h>
#include <string.h>

#define LENGTH (50)
#define FALSE (0)
#define TRUE (1)

int main(void)
{
    char buffer[LENGTH + 2]; /* 개행문자 1, 널문자 1 */
    size_t len = 0;
    char* p;
    int num = 0;
    int res = 0;
    int is_negative = FALSE;
    int tmp = 0;

    if (fgets(buffer, LENGTH + 1, stdin) == NULL) {
        perror("reading input error");
        return 1;
    }

    /* 개행 문자 제거 */
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }

    p = buffer;
    while (*p != '\0') {
        if (*p != '-' && *p != '+') {
            num = 10 * num + (*p - '0');
        } else {
            if (*p == '-') {
                if (is_negative == FALSE) { /* 여는 괄호에서 - 만난 경우 부호 앞의 숫자를 결과에 바로 더함 */
                    res += num;
                } else {  /* 닫는 괄호에서 - 만난 경우 */
                    tmp += num;
                    res += -tmp;
                    tmp = 0;
                }
                is_negative = TRUE;
            } else {    /* +를 만난 경우 */
                if (is_negative == TRUE) {
                    tmp += num;
                } else {
                    res += num;
                }
            }
            num = 0;
        }
        ++p;
    }

    if (is_negative == TRUE) {
        tmp += num;
        res += -tmp;
    } else {
        res += num;
    }

    printf("%d", res);

    return 0;
}
