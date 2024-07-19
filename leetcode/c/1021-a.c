#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*
 * 1021. Remove Outermost Parentheses
 * */

char* removeOuterParentheses(char* s)
{
    char* res = NULL;
    char* p = s;
    char* start;
    char* end;
    int top = 0;

    res = malloc(sizeof(char) * 10000);
    memset(res, 0, 10000);

    start = p;
    while (*p != '\0') {
        char ch = *p;
        if (ch == '(') {
            ++top;
        } else if (ch == ')') {
            --top;
        }
        if (top == 0) {
            end = p;
            strncat(res, start + 1, end - start - 1);
            start = p + 1;
        }
        ++p;
    }

    return res;
}

int main(void)
{
    char* answer = removeOuterParentheses("()()");
    printf("%s", answer);

    return 0;
}
