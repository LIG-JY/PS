#include <stdio.h>
#include <assert.h>

static char s_stack[100];
static int s_pos;
static int s_max;

static char pop(void);

static void push(char val);

/*
 * 1614. Maximum Nesting Depth of the Parentheses
 * */

int maxDepth(char* s)
{
    char* p = s;
    s_pos = 0;
    s_max = 0;

    while (*p != '\0') {
        char ch = *p;
        if (ch == '(') {
            push(ch);
        } else if (ch == ')') {
            pop();  /* It is guaranteed that parentheses expression s is a VPS(Valid Parentheses String). */
        }
        ++p;
    }

    return s_max;
}

static char pop(void)
{
    if (s_pos == 0) {
        return '\0';
    }

    return s_stack[--s_pos];
}

static void push(char val)
{
    assert(s_pos < 100);
    s_stack[s_pos++] = val;
    if (s_pos > s_max) {
        s_max = s_pos;
    }
}

int main(void)
{

    int answer = maxDepth("1+(2*3)/(2-1)");

    printf("%d", answer);

    return 0;
}
