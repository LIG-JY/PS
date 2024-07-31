#include <stdio.h>
#include <assert.h>

#define MAX (100000)

static int s_stack[MAX];
static int s_top = 0;

static void push(int num);

static int top(void);

static int pop(void);

int main(void)
{
    int N;
    int next = 1;
    char output[MAX * 2] = { '\0' };
    int output_size = 0;

    scanf("%d", &N);

    for (int i = 0; i < N; ++i) {
        int num;
        scanf("%d", &num);

        if (num > next) {
            for (int j = next; j <= num; ++j) {
                push(j);
                output[output_size++] = '+';
            }
            pop();
            output[output_size++] = '-';
            next = num + 1;
        } else if (num == next) {
            push(num);
            output[output_size++] = '+';
            pop();
            output[output_size++] = '-';
            next = num + 1;
        } else {
            if (top() < num) {
                printf("%s", "NO");
                return 0;
            }

            while (top() >= num) {
                pop();
                output[output_size++] = '-';
            }
        }
    }

    for (int k = 0; k < output_size; ++k) {
        printf("%c\n", output[k]);
    }

    return 0;
}

static void push(int num)
{
    assert(MAX > s_top);

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
