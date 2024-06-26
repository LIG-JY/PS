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
    node_t* value = table[key];
    node_t* node = malloc(sizeof(node_t));

    if (node == NULL) {
        perror("memory allocation failed");
        dispose();
        exit(1);
    }
    strncpy(node->name, str, LENGTH);
    node->name[LENGTH] = '\0';
    node->next = value;
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
    int i;

    for (i = 0; i < m; ++i) {
        free(names[i]);
        names[i] = NULL;
    }
    free(names);
    names = NULL;
}

static int comp(const void* a, const void* b)
{
    char** str_a = (char**)a;
    char** str_b = (char**)b;

    return strcmp(*str_a, *str_b);
}

int main(void)
{
    int N;
    int M;
    char buffer[LENGTH];
    int i;
    char** names = NULL;
    int cnt = 0;
    int names_size = 1;

    if (fgets(buffer, LENGTH + 1, stdin) == NULL) {
        perror("error input");
        return 1;
    }

    if (sscanf(buffer, "%d%d", &N, &M) != 2) {
        perror("invalid N, M");
        return 1;
    }

    init();

    for (i = 0; i < N; ++i) {
        size_t len = 0;

        if (fgets(buffer, LENGTH + 2, stdin) == NULL) { /* 개행문자 포함해서 LENGTH + 1만큼 입력 */
            perror("error input");
            return 1;
        }

        len = strlen(buffer);
        if (buffer[len - 1] == '\n') { /* 개행 문자 제거 */
            buffer[len - 1] = '\0';
        }
        /* Ex) abc\n\0 -> abc\0\0 */
        /* Ex) 01234567890123456789\n -> 01234567890123456789\0 */
        insert(buffer);
    }

    names = malloc(sizeof(char*) * names_size);
    if (names == NULL) {
        perror("memory allocation failed");
        dispose();
    }

    for (i = 0; i < M; ++i) {
        size_t len = 0;

        if (fgets(buffer, LENGTH + 2, stdin) == NULL) { /* 개행문자 포함해서 LENGTH + 1만큼 입력 */
            perror("error input");
            return 1;
        }

        len = strlen(buffer);
        if (buffer[len - 1] == '\n') { /* 개행 문자 제거 */
            buffer[len - 1] = '\0';
            --len;
        }
        /* Ex) abc\n\0 -> abc\0\0 */
        /* Ex) 01234567890123456789\n -> 01234567890123456789\0 */
        if (search(buffer) == TRUE) {
            if (cnt == names_size) {
                char** temp = names;
                names = malloc(sizeof(char*) * (names_size + 1));
                memcpy(names, temp, sizeof(char*) * names_size);
                free(temp);
                ++names_size;
            }
            names[cnt] = malloc(len + 1);
            strncpy(names[cnt], buffer, len + 1);
            cnt++;
        }
    }

    qsort(names, cnt, sizeof(char*), comp);
    printf("%d\n", cnt);
    for (i = 0; i < cnt; ++i) {
        printf("%s\n", names[i]);
    }

    dispose_names(names, cnt);
    dispose();

    return 0;
}
