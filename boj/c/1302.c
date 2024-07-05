#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (50)
#define TABLE_SIZE (1000)

typedef struct node {
    char val[LENGTH + 1];
    int cnt;
    struct node* next;
} node_t;

static node_t* table[TABLE_SIZE];

static unsigned int hash(const char* str);

static void insert(const char* str);

static node_t* find(const char* str);

static void dispose(void);

static void init(void);

int main(void)
{
    size_t N;
    size_t i;
    char buffer[LENGTH + 1];
    size_t len;

    if (fgets(buffer, (LENGTH + 1) + 1, stdin) == NULL) {
        perror("error while input");
        return 1;
    }
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }
    --len;
    if (sscanf(buffer, "%zd", &N) != 1) {
        perror("error while input");
        return 1;
    }

    init();

    for (i = 0; i < N; ++i) {
        node_t* node_p = NULL;

        if (fgets(buffer, (LENGTH + 1) + 1, stdin) == NULL) {
            perror("error while input");
            return 1;
        }
        len = strlen(buffer);
        if (buffer[len - 1] == '\n') {
            buffer[len - 1] = '\0';
        }
        --len;

        node_p = find(buffer);
        if (node_p == NULL) {
            insert(buffer);
        } else {
            ++(node_p->cnt);
        }
    }

    {
        char* str = NULL;
        int max = 0;
        for (i = 0; i < TABLE_SIZE; ++i) {
            node_t* p = table[i];
            while (p != NULL) {
                if (p->cnt > max) {
                    max = p->cnt;
                    str = p->val;
                } else if (p->cnt == max) {
                    if (strcmp(p->val, str) < 0) {
                        str = p->val;
                    }
                }
                p = p->next;
            }
        }

        printf("%s", str);
    }

    dispose();

    return 0;
}

static unsigned int hash(const char* str)
{
    unsigned long hash = 5381;
    int c;
    const char* p = str;

    while (*p != '\0') {
        c = (int)*p;
        hash = ((hash << 5) + hash) + c;
        ++p;
    }

    return hash % TABLE_SIZE;
}

static void insert(const char* str)
{
    node_t* node_p = NULL;
    unsigned int key = hash(str);
    size_t len = strlen(str);

    node_p = malloc(sizeof(node_t));
    if (node_p == NULL) {
        perror("memory allocation error");
        dispose();
        exit(1);
    }
    strncpy(node_p->val, str, len);
    (node_p->val)[len] = '\0';
    node_p->cnt = 1;
    node_p->next = table[key];
    table[key] = node_p;
}

static node_t* find(const char* str)
{
    node_t* node_p = NULL;
    unsigned int key = hash(str);

    node_p = table[key];
    while (node_p != NULL) {
        if (strcmp(node_p->val, str) == 0) {
            return node_p;
        }
        node_p = node_p->next;
    }
    return NULL;
}

static void dispose(void)
{
    size_t i;
    node_t* p;

    for (i = 0; i < TABLE_SIZE; ++i) {
        p = table[i];
        while (p != NULL) {
            node_t* tmp = p->next;
            free(p);
            p = tmp;
        }
        table[i] = NULL;
    }
}

static void init(void)
{
    size_t i;

    for (i = 0; i < TABLE_SIZE; ++i) {
        table[i] = NULL;
    }
}
