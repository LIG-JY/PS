#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (20)
#define TABLE_SIZE (500000)
#define TRUE (1)
#define FALSE (0)

typedef struct node_t {
    char name[LENGTH + 1];
    struct node_t* next;
} node_t;

static node_t* table[TABLE_SIZE];   /* key와 head node mapping */

static void init(void)
{
    for (size_t i = 0; i < TABLE_SIZE; ++i) {
        table[i] = NULL;
    }
}

static void dispose(void)
{
    for (size_t i = 0; i < TABLE_SIZE; ++i) {
        node_t* p = table[i];
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
    while (*str != '\0') {
        hash = ((hash << 5) + hash) + (int)(*str);
        str++;
    }
    return hash % TABLE_SIZE;
}

static void insert(const char* str)
{
    unsigned int key = hash(str);
    node_t* node = malloc(sizeof(node_t));

    if (node == NULL) {
        perror("memory allocation failed");
        dispose();
        exit(1);
    }

    strncpy(node->name, str, LENGTH);
    node->name[LENGTH] = '\0';
    node->next = table[key];
    table[key] = node;  /* 연결 리스트 헤드에 삽입 */
}

static int search(const char* str)
{
    unsigned int key = hash(str);
    node_t* value = table[key];

    while (value != NULL) {
        if (strcmp(value->name, str) == 0) {
            return TRUE;
        }
        value = value->next;
    }
    return FALSE;
}

static void dispose_names(char** names, int m)
{
    for (int i = 0; i < m; ++i) {
        free(names[i]);
    }
    free(names);
}

static int comp(const void* a, const void* b)
{
    return strcmp(*(const char**)a, *(const char**)b);
}

static void read_input(char* buffer, size_t length)
{
    if (fgets(buffer, length, stdin) == NULL) {
        perror("error input");
        exit(1);
    }
    size_t len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }
}

int main(void)
{
    int N, M;
    char buffer[LENGTH + 2];  // +2 to accommodate the newline and null character
    int cnt = 0;
    int names_size = 1;
    char** names = malloc(sizeof(char*) * names_size);

    if (names == NULL) {
        perror("memory allocation failed");
        return 1;
    }

    read_input(buffer, LENGTH + 1);
    if (sscanf(buffer, "%d%d", &N, &M) != 2) {
        perror("invalid N, M");
        return 1;
    }

    init();

    for (int i = 0; i < N; ++i) {
        read_input(buffer, LENGTH + 2);
        insert(buffer);
    }

    for (int i = 0; i < M; ++i) {
        read_input(buffer, LENGTH + 2);
        if (search(buffer) == TRUE) {
            if (cnt == names_size) {
                names_size *= 2;
                char** temp = realloc(names, sizeof(char*) * names_size);
                if (temp == NULL) {
                    perror("memory reallocation failed");
                    dispose_names(names, cnt);
                    dispose();
                    return 1;
                }
                names = temp;
            }
            names[cnt] = malloc(strlen(buffer) + 1);
            if (names[cnt] == NULL) {
                perror("memory allocation failed");
                dispose_names(names, cnt);
                dispose();
                return 1;
            }
            strcpy(names[cnt], buffer);
            cnt++;
        }
    }

    qsort(names, cnt, sizeof(char*), comp);
    printf("%d\n", cnt);
    for (int i = 0; i < cnt; ++i) {
        printf("%s\n", names[i]);
    }

    dispose_names(names, cnt);
    dispose();

    return 0;
}