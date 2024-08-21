#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>

#define BUFFER_SIZE (10)
#define CAPACITY (500000)

typedef struct pair {
    int height;
    int count;
} pair_t;

static pair_t s_stack[CAPACITY];
static int s_count = 0;

static void push(pair_t val);

static pair_t pop(void);

static pair_t top(void);

static bool is_empty(void);

int main(void)
{
    int N;
    char buffer[BUFFER_SIZE + 1];
    if (fgets(buffer, BUFFER_SIZE + 2, stdin) == NULL) {
        perror("input error");
        return 1;
    }
    buffer[strlen(buffer)] = '\0';
    sscanf(buffer, "%d", &N);

    int* pa_input = NULL;
    pa_input = (int*)malloc(sizeof(int) * N);
    if (pa_input == NULL) {
        perror("memory allocation error");
        return 1;
    }
    for (int i = 0; i < N; ++i) {
        if (fgets(buffer, BUFFER_SIZE + 2, stdin) == NULL) {
            perror("input error");
            return 1;
        }
        buffer[strlen(buffer)] = '\0';
        sscanf(buffer, "%d", pa_input + i);
    }

    long long int res = 0;
    for (int i = 0; i < N; ++i) {
        int h = pa_input[i];
        int c = 1;
        while (is_empty() == false && h >= top().height) {
            res += top().count;
            if (h == top().height) {
                c += top().count;
            }
            pop();
        }
        if (is_empty() == false) {
            ++res;
        }
        pair_t pair;
        pair.height = h;
        pair.count = c;
        push(pair);
    }

    printf("%lld", res);

    free(pa_input);
    pa_input = NULL;

    return 0;
}

static void push(pair_t val)
{
    assert(s_count < CAPACITY);
    s_stack[s_count++] = val;
}

static pair_t pop(void)
{
    assert(!is_empty());

    return s_stack[--s_count];
}

static pair_t top(void)
{
    assert(!is_empty());

    return s_stack[s_count - 1];
}

static bool is_empty(void)
{
    if (s_count == 0) {
        return true;
    }

    return false;
}
