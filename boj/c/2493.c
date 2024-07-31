#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>

#define STACK_CAPACITY (500000)

static int s_stack[STACK_CAPACITY];
static int s_top = 0;

static void push(int num);

static int top(void);

static int pop(void);

static bool is_empty(void);

int main(void)
{
    int N;
    scanf("%d", &N);

    int* pa_input = malloc(sizeof(int) * (N + 1));
    memset(pa_input, 0, sizeof(int) * (N + 1));
    if (pa_input == NULL) {
        perror("memory allocation error");
        return 1;
    }
    for (int i = 1; i <= N; ++i) {
        int height;
        scanf("%d", &height);
        pa_input[i] = height;
    }

    int* pa_output = malloc(sizeof(int) * (N + 1));
    memset(pa_output, 0, sizeof(int) * (N + 1));
    for (int j = N; j > 1; --j) {
        int value = pa_input[j];
        int next_value = pa_input[j - 1];

        if (next_value > value) {
            pa_output[j] = j - 1;
            while (next_value > pa_input[top()] && !is_empty()) {
                pa_output[pop()] = j - 1;
            }
        } else {
            push(j);
        }
    }
    while (!is_empty()) {
        pa_input[pop()] = 0;
    }

    for (int k = 1; k <= N; ++k) {
        printf("%d ", pa_output[k]);
    }

    free(pa_input);
    free(pa_output);

    return 0;
}

static void push(int num)
{
    assert(s_top < STACK_CAPACITY);

    s_stack[s_top++] = num;
}

static int top(void)
{
    if (s_top == 0) {
        return -1;
    }

    return s_stack[s_top - 1];
}

static int pop(void)
{
    if (s_top == 0) {
        return -1;
    }

    return s_stack[--s_top];
}

static bool is_empty(void)
{
    if (s_top == 0) {
        return true;
    }

    return false;
}
