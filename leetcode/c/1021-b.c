#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*
 * 1021. Remove Outermost Parentheses
 * */

char* removeOuterParentheses(char* s)
{
    char* res = malloc(strlen(s) + 1);  // Allocate maximum necessary space
    char* p = s;
    int top = 0;    // stack top
    char* res_ptr = res;

    while (*p != '\0') {
        char ch = *p;
        if (ch == '(') {
            if (top > 0) {
                *res_ptr++ = ch;
            }
            ++top;
        } else if (ch == ')') {
            --top;
            if (top > 0) {
                *res_ptr++ = ch;
            }
        }
        ++p;
    }

    *res_ptr = '\0';  // Null-terminate the result string

    return res;
}

int main(void)
{
    char* answer = removeOuterParentheses("()()");
    printf("%s", answer);

    return 0;
}
