#include <stdio.h>
#include <string.h>
#include <assert.h>
#include <stdbool.h>

#define CAPACITY (100000)

typedef struct pair {
    int height;
    int location;
} pair_t;

static pair_t s_stack[CAPACITY];
static int s_size = 0;

static void init_stack(void);

static void push(pair_t val);

static pair_t pop(void);

static pair_t top(void);

static bool is_empty(void);

int main(void)
{
    int N;
    int i;
    do {
        scanf("%d", &N);
        init_stack();
        long long int res = 0;
        for (i = 0; i < N; ++i) {
            int current_h;
            int current_l = i;
            scanf("%d", &current_h);
            while (is_empty() == false && top().height > current_h) {
                long long int temp = (i - top().location) * (long long int)top().height;
                if (temp > res) {
                    res = temp;
                }
                current_l = top().location;
                pop();
            }
            pair_t pair;
            pair.location = current_l;
            pair.height = current_h;
            push(pair);
        }
        while (is_empty() == false) {
            long long int temp = (N - top().location) * (long long int)top().height;   // N is last virtual index
            if (temp > res) {
                res = temp;
            }
            pop();
        }
        if (N != 0) {
            printf("%lld\n", res);
        }
    } while (N > 0);

    return 0;
}

static void init_stack(void)
{
    memset(s_stack, 0, CAPACITY);
    s_size = 0;
}

static void push(pair_t val)
{
    assert(s_size < CAPACITY);
    s_stack[s_size++] = val;
}

static pair_t pop(void)
{
    assert(s_size > 0);

    return s_stack[--s_size];
}

static pair_t top(void)
{
    assert(s_size > 0);

    return s_stack[s_size - 1];
}

static bool is_empty(void)
{
    if (s_size == 0) {
        return true;
    }

    return false;
}

// edge case

# if 0
5 1000000000 1000000000 1000000000 1000000000 1000000000
0

ans : 5000000000

Watch out for the output's data type..
#endif
