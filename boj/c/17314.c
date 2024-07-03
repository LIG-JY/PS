#include <stdio.h>
#include <string.h>

#define LENGTH (100000)
#define TRUE (1)
#define FALSE (0)

int main(void)
{
    char buffer[LENGTH + 1];
    char stack[LENGTH + 1];
    int stack_top = -1;
    size_t len;
    const char* p;
    int in_tag = FALSE;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        perror("error while input");
        return 1;
    }
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }
    --len;

    p = buffer;
    while (*p != '\0') {
        if (*p == '<') {
            /* 스택 비우기 */
            int i;
            for (i = stack_top; i >= 0; --i) {
                printf("%c", stack[i]);
                --stack_top;
            }
            printf("%c", *p);
            in_tag = TRUE;
            goto next;
        }
        if (*p == '>') {
            printf("%c", *p);
            in_tag = FALSE;
            goto next;
        }
        if (*p == ' ') {
            if (in_tag == FALSE) {
                /* 스택 비우기 */
                int i;
                for (i = stack_top; i >= 0; --i) {
                    printf("%c", stack[i]);
                    --stack_top;
                }
            }
            printf("%c", *p);
            goto next;
        }
        if (in_tag == TRUE) {
            printf("%c", *p);
            goto next;
        }
        if (in_tag == FALSE) {
            stack[++stack_top] = *p;
            goto next;
        }
    next:
        ++p;
    }

    {
        /* 스택 비우기 */
        int i;
        for (i = stack_top; i >= 0; --i) {
            printf("%c", stack[i]);
            --stack_top;
        }
    }

    return 0;
}
