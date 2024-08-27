#include <stdio.h>
#include <string.h>
#include <assert.h>
#include <stdbool.h>

#define BUFFER_SIZE (10)
#define CAPACITY (80000)

static int s_stack[CAPACITY];
static int s_count = 0;

static void push(int val);

static int pop(void);

static int top(void);

static bool is_empty(void);

int main(void)
{
    int N;
    char buffer[BUFFER_SIZE + 1];
    if (fgets(buffer, BUFFER_SIZE + 2, stdin) == NULL) {
        perror("input error");
        return 1;
    }
    if (buffer[strlen(buffer) - 1] == '\n') {
        buffer[strlen(buffer) - 1] = '\0';
    }
    sscanf(buffer, "%d", &N);

    long long int res = 0;
    for (int i = 0; i < N; ++i) {
        int h;
        if (fgets(buffer, BUFFER_SIZE + 2, stdin) == NULL) {
            perror("input error");
            return 1;
        }
        if (buffer[strlen(buffer) - 1] == '\n') {
            buffer[strlen(buffer) - 1] = '\0';
        }
        sscanf(buffer, "%d", &h);
        while (!is_empty() && h >= top()) {
            pop();
        }
        res += s_count;
        push(h);
    }
    printf("%lld", res);

    return 0;
}

static void push(int val)
{
    assert(s_count < CAPACITY);
    s_stack[s_count++] = val;
}

static int pop(void)
{
    assert(!is_empty());

    return s_stack[--s_count];
}

static int top(void)
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
