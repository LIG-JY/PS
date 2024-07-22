#include <stdio.h>
#include <assert.h>

#define MAX_SIZE (1000000)
#define TRUE (1)
#define FALSE (0)

static int s_stack[MAX_SIZE];
static int s_top = 0;

static void push(int n);

static int top(void);

static int pop(void);

static int is_empty(void);

int main(void)
{
    size_t N;
    size_t i;
    int input[MAX_SIZE];
    int output[MAX_SIZE] = { 0, };

    scanf("%zd", &N);
    for (i = 0; i < N; ++i) {
        scanf("%d", input + i);
    }

    for (i = 0; i < N; ++i) {
        if (is_empty() == TRUE) {
            push((int)i);   // push index
        } else {
            while (is_empty() == FALSE && input[top()] < input[i]) {    // compare input[the rightmost index to i] and input[i]
                output[pop()] = input[i];
            }
            push((int)i);
        }
    }

    while (is_empty() == FALSE) {
        output[pop()] = -1;
    }

    for (i = 0; i < N; ++i) {
        printf("%d ", output[i]);
    }

    return 0;
}

static void push(int n)
{
    assert(s_top < MAX_SIZE);
    s_stack[s_top++] = n;
}

static int top(void)
{
    if (is_empty() == TRUE) {
        return -1;
    }

    return s_stack[s_top - 1];
}

static int pop(void)
{
    if (is_empty() == TRUE) {
        return -1;
    }

    return s_stack[--s_top];
}

static int is_empty(void)
{
    return s_top == 0;
}
