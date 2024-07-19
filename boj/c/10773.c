#include <stdio.h>

static int s_stack[100000];
static int s_top = 0;

static int pop(void);

static void push(int value);

int main(void)
{
    int K;
    int n;
    char buffer[10] = { 0, };
    int res = 0;

    fgets(buffer, 11, stdin);
    sscanf(buffer, "%d", &K);
    while (K > 0) {
        fgets(buffer, 11, stdin);
        sscanf(buffer, "%d", &n);
        if (n == 0) {
            pop();
        } else {
            push(n);
        }
        --K;
    }
    while (s_top > 0) {
        res += pop();
    }
    printf("%d", res);

    return 0;
}

static int pop(void)
{
    if (s_top == 0) {
        return -1;
    }

    return s_stack[--s_top];
}

static void push(int value)
{
    s_stack[s_top++] = value;
}