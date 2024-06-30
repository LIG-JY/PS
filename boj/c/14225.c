#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (500)
#define TABLE_SIZE (10000)
#define TRUE (1)
#define FALSE (0)

typedef struct node_t {
    char value[LENGTH + 1];
    struct node_t* next;
} node_t;

static node_t* table[TABLE_SIZE];

static void init(void)
{
    size_t i;

    for (i = 0; i < TABLE_SIZE; ++i) {
        table[i] = NULL;
    }
}

static void dispose(void)
{
    size_t i;
    node_t* p;

    for (i = 0; i < TABLE_SIZE; ++i) {
        p = table[i];
        while (p != NULL) {
            node_t* next = p->next;
            free(p);
            p = next;
        }
        table[i] = NULL;
    }
}

static unsigned int hash(const char* str)
{
    unsigned long hash = 5381;
    int c;

    while (*str != '\0') {
        c = (int)*str;
        hash = ((hash << 5) + hash) + c;
        str++;
    }

    return hash % TABLE_SIZE;
}

static void insert(const char* str)
{
    unsigned int key = hash(str);
    node_t* node;

    node = malloc(sizeof(node_t));
    if (node == NULL) {
        perror("memory allocation failed");
        dispose();
        exit(1);
    }
    strncpy(node->value, str, LENGTH);
    node->value[LENGTH] = '\0';
    node->next = table[key];
    table[key] = node;
}

static int find(const char* str)
{
    unsigned int key = hash(str);
    node_t* node = table[key];

    while (node != NULL) {
        if (strcmp(node->value, str) == 0) {
            return TRUE;
        }
        node = node->next;
    }
    return FALSE;
}

int main(void)
{
    int i;
    int N;
    int M;
    char buffer[LENGTH + 1];
    int res = 0;

    if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
        perror("input error");
        return 1;
    }
    if (buffer[strlen(buffer) - 1] == '\n') {
        buffer[strlen(buffer) - 1] = '\0';
    }

    if (sscanf(buffer, "%d %d", &N, &M) != 2) {
        perror("input error");
        return 1;
    };

    init();

    for (i = 0; i < N; ++i) {
        if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
            perror("input error");
            return 1;
        }
        if (buffer[strlen(buffer) - 1] == '\n') {
            buffer[strlen(buffer) - 1] = '\0';
        }
        insert(buffer);
    }

    for (i = 0; i < M; ++i) {
        if (fgets(buffer, LENGTH + 2, stdin) == NULL) {
            perror("input error");
            return 1;
        }
        if (buffer[strlen(buffer) - 1] == '\n') {
            buffer[strlen(buffer) - 1] = '\0';
        }
        if (find(buffer) == TRUE) {
            ++res;
        }
    }

    printf("%d", res);
    dispose();

    return 0;
}
