#include <stdio.h>

/*
 * 1614. Maximum Nesting Depth of the Parentheses
 * */

int maxDepth(char* s)
{
    char* p = s;
    int pos = 0;
    int max = 0;

    while (*p != '\0') {
        char ch = *p;
        if (ch == '(') {
            ++pos;
        } else if (ch == ')') {
            --pos;  /* It is guaranteed that parentheses expression s is a VPS(Valid Parentheses String). */
        }
        ++p;

        if (pos > max) {
            max = pos;
        }
    }

    return max;
}

int main(void)
{

    int answer = maxDepth("1+(2*3)/(2-1)");

    printf("%d", answer);

    return 0;
}
