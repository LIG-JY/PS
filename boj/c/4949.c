#include <stdio.h>
#include <string.h>

#define LENGTH (100)

static char stack[LENGTH];
static int stack_cnt;

int main(void)
{
    char buffer[LENGTH + 1];
    size_t len;
    size_t i;

    while (fgets(buffer, LENGTH + 2, stdin) != NULL) { /* 최대 100개 + 개행문자 입력 */
        if (buffer[0] == '.') {
            return 0;
        }
        len = strlen(buffer);   /* len의 최대값: 101 */
        if (buffer[len - 1] == '\n') {
            buffer[len - 1] = '\0';
            --len;
        }
        memset(stack, 0, LENGTH);
        stack_cnt = 0;
        for (i = 0; i < len; ++i) {
            switch (buffer[i]) {
            case '(':
                stack[stack_cnt++] = '(';
                break;
            case ')':
                if (stack[stack_cnt - 1] == '(') {
                    stack[--stack_cnt] = 0;
                } else {
                    printf("no\n");
                    goto next;
                }
                break;
            case '[':
                stack[stack_cnt++] = '[';
                break;
            case ']':
                if (stack[stack_cnt - 1] == '[') {
                    stack[--stack_cnt] = 0;
                } else {
                    printf("no\n");
                    goto next;
                }
                break;
            default:
                continue;
            }
        }
        if (stack_cnt != 0) {
            printf("no\n");
        } else {
            printf("yes\n");
        }
    next:
        continue;
    }

    return 0;
}

