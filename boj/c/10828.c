#include <stdio.h>
#include <string.h>
#include <assert.h>

#define MAX_SIZE (10000)
#define TRUE (1)
#define FALSE (0)

static int s_pos = 0;
static int s_stack[MAX_SIZE] = { 0, };

static void push(int val);

static int pop(void);

static int size(void);

static int is_empty(void);

static int top(void);

int main(void)
{
    int N;
    char buffer[100];

    fgets(buffer, 100 + 1, stdin);
    sscanf(buffer, "%d", &N);

    while (N > 0) {
        char order[6] = { 0, };
        int value = 0;

        fgets(buffer, 100 + 1, stdin);
        if (buffer[strlen(buffer) - 1] == '\n') {
            buffer[strlen(buffer) - 1] = '\0';
        }
        sscanf(buffer, "%s %d", order, &value);
        order[strlen(order)] = '\0';
        if (strcmp(order, "push") == 0) {
            push(value);
        } else if (strcmp(order, "pop") == 0) {
            printf("%d\n", pop());
        } else if (strcmp(order, "size") == 0) {
            printf("%d\n", size());
        } else if (strcmp(order, "empty") == 0) {
            printf("%d\n", is_empty());
        } else if (strcmp(order, "top") == 0) {
            printf("%d\n", top());
        } else {
            assert(0);
        }

        --N;
    }

    return 0;
}

static void push(int val)
{
    assert(s_pos < MAX_SIZE);
    s_stack[s_pos++] = val;
}

static int pop(void)
{
    if (is_empty() == TRUE) {
        return -1;
    }

    return s_stack[--s_pos];
}

static int size(void)
{
    return s_pos;
}

static int is_empty(void)
{
    if (s_pos == 0) {
        return TRUE;
    }

    return FALSE;
}

static int top(void)
{
    if (is_empty() == TRUE) {
        return -1;
    }

    return s_stack[s_pos - 1];
}
