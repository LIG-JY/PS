#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (1000)
#define TABLE_SIZE (500500)
#define TRUE (1)
#define FALSE (0)

typedef struct node {
    const char* start;
    const char* end;
    struct node* next;
} node_t;

static node_t* s_table[TABLE_SIZE];
static int s_element_cnt = 0;

static void init(void);

static void dispose(void);

static unsigned int hash(const char* start, const char* end);

static void insert(const char* start, const char* end);

static int contains(const char* start, const char* end);

static int cmp_string(const char* start, const char* end, const char* start2, const char* end2);

static void init(void)
{
    size_t i;

    for (i = 0; i < TABLE_SIZE; ++i) {
        s_table[i] = NULL;
    }
}

static void dispose(void)
{
    size_t i;
    node_t* p;

    for (i = 0; i < TABLE_SIZE; ++i) {
        p = s_table[i];
        while (p != NULL) {
            node_t* next = p->next;
            free(p);
            p = next;
        }
        s_table[i] = NULL;
    }
}

static unsigned int hash(const char* start, const char* end)
{
    unsigned long hash = 5381;
    int c;
    const char* p = start;

    while (p <= end) {
        c = (int)*p;
        hash = ((hash << 5) + hash) + c;
        ++p;
    }

    return hash % TABLE_SIZE;
}

static void insert(const char* start, const char* end)
{
    node_t* node;
    unsigned int key;

    if (contains(start, end) == TRUE) {
        return;
    }

    node = malloc(sizeof(node_t));
    if (node == NULL) {
        perror("memory allocation failed");
        dispose();
        exit(1);
    }
    key = hash(start, end);
    node->start = start;
    node->end = end;
    node->next = s_table[key];
    s_table[key] = node;
    ++s_element_cnt;
}

static int contains(const char* start, const char* end)
{
    unsigned int key = hash(start, end);
    node_t* p = s_table[key];

    while (p != NULL) {
        node_t* next = p->next;
        if (cmp_string(start, end, p->start, p->end) == TRUE) {
            return TRUE;
        }
        p = next;
    }
    return FALSE;
}

static int cmp_string(const char* start, const char* end, const char* start2, const char* end2)
{
    const char* p = start;
    const char* q = start2;

    if ((end - start) != (end2 - start2)) {
        return FALSE;
    }

    while (p <= end && q <= end2) {
        if (*p != *q) {
            return FALSE;
        }
        ++p;
        ++q;
    }
    return TRUE;
}

int main(void)
{
    size_t len;
    char buffer[LENGTH];
    size_t i;
    size_t j;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        perror("error while input");
        return 1;
    }
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
        --len;
    }

    init();

    for (i = 0; i < len; ++i) {
        char* start = buffer + i;
        for (j = i; j < len; ++j) {
            char* end = buffer + j;
            insert(start, end);
        }
    }

    printf("%d", s_element_cnt);
    dispose();

    return 0;
}
