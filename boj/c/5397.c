#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (1000000)

typedef struct node {
    char value;
    struct node* next;
    struct node* prev;
} node_t;

static void dispose(node_t* head);

static void insert(node_t* head, node_t** p_cursor, char ch);

static void delete(node_t* head, node_t** p_cursor);

int main(void)
{
    char buffer[LENGTH + 1];
    size_t len;
    int M;
    int i;
    const char* p;
    node_t* head = NULL;
    node_t* cursor = NULL;

    fgets(buffer, LENGTH + 2, stdin);
    /* 입력 오류 처리 생략 */
    sscanf(buffer, "%d", &M);

    for (i = 0; i < M; ++i) {
        fgets(buffer, LENGTH + 2, stdin);
        /* 입력 오류 처리 생략 */
        len = strlen(buffer);
        if (buffer[len - 1] == '\n') {
            buffer[len - 1] = '\0';
        }
        --len;

        head = malloc(sizeof(node_t));
        head->value = 0;
        head->next = NULL;
        head->prev = NULL;
        cursor = head;

        p = buffer;
        while (*p != '\0') {
            char c = *p;
            if (c == '<') {
                if (cursor != head) {
                    cursor = cursor->prev;
                }
            } else if (c == '>') {
                if (cursor->next != NULL) {
                    cursor = cursor->next;
                }
            } else if (c == '-') {
                if (cursor != head) {
                    delete(head, &cursor);
                }
            } else {
                insert(head, &cursor, c);
            }
            ++p;
        }
        cursor = head->next;
        while (cursor != NULL) {
            printf("%c", cursor->value);
            cursor = cursor->next;
        }
        printf("%c", '\n');
        dispose(head);
    }

    return 0;
}

static void insert(node_t* head, node_t** p_cursor, char ch)
{
    node_t* current = *p_cursor;
    node_t* new_node = NULL;

    new_node = malloc(sizeof(node_t));
    /* 메모리 할당 오류 처리 생략 */
    new_node->value = ch;
    new_node->next = NULL;
    new_node->prev = NULL;

    if (current == head) { /* 헤드 바로 뒤 삽입 */
        if (head->next != NULL) {
            (head->next)->prev = new_node;
            new_node->next = head->next;
        }
        head->next = new_node;
        new_node->prev = head;
    } else if (current->next == NULL) {  /* 맨 뒤에 삽입 */
        current->next = new_node;
        new_node->prev = current;
    } else { /* 중간에 삽입 */
        node_t* next = current->next;
        current->next = new_node;
        new_node->prev = current;
        next->prev = new_node;
        new_node->next = next;
    }
    *p_cursor = new_node;
}

static void delete(node_t* head, node_t** p_cursor)
{
    node_t* current = *p_cursor;
    node_t* prev = current->prev;
    node_t* next = current->next;

    /* 커서가 헤드에 위치 */
    if (current == head) {
        return;
    } else if (next == NULL) { /* 커서가 가장 오른쪽에 위치 */
        prev->next = NULL;
        *p_cursor = prev;
    } else {
        prev->next = next;
        next->prev = prev;
        *p_cursor = prev;
    }
    free(current);
}

static void dispose(node_t* head)
{
    node_t* current = head;

    while (current != NULL) {
        node_t* next = current->next;
        free(current);
        current = next;
    }
}
