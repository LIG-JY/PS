#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>

#define LENGTH (100000)
#define INPUT_LENGTH (3)

typedef struct node {
    char value;
    struct node* next;
    struct node* prev;
} node_t;

static void dispose(node_t* head);

static void insert(node_t* head, node_t** p_cursor, char ch);

static void delete(node_t** p_cursor);

int main(void)
{
    char buffer[LENGTH + 1];
    size_t len;
    int M;
    node_t* head = NULL;
    node_t* cursor = NULL;

    fgets(buffer, LENGTH + 2, stdin);
    /* 입력 오류 처리 생략 */
    len = strlen(buffer);
    if (buffer[len - 1] == '\n') {
        buffer[len - 1] = '\0';
    }
    --len;

    /* 링크드 리스트 만들기 */
    head = malloc(sizeof(node_t));
    head->value = 0;
    head->prev = NULL;
    head->next = NULL;
    cursor = head;
    {
        size_t i;
        node_t* current;

        for (i = 0; i < len; ++i) {
            current = malloc(sizeof(node_t));
            current->value = buffer[i];
            current->next = NULL;
            current->prev = NULL;
            cursor->next = current;
            current->prev = cursor;
            cursor = current;
        }
    }
    // head -> a

    /* 명령어 수행 */
    {
        size_t i;
        char order;
        char input;

        fgets(buffer, 8, stdin);    /* M(최대 6자리)과 개행문자 입력 */
        /* 입력 오류 처리 생략 */
        sscanf(buffer, "%d", &M);

        for (i = 0; i < M; ++i) {
            fgets(buffer, INPUT_LENGTH + 2, stdin);
            /* 입력 오류 처리 생략 */
            sscanf(buffer, "%c %c", &order, &input);    /* scanf format string에 공백 포함 */
            switch (order) {
            case 'L': {
                if (cursor != head) {
                    cursor = cursor->prev;
                }
                break;
            }
            case 'D': {
                if (cursor->next != NULL) {
                    cursor = cursor->next;
                }
                break;
            }
            case 'B': {
                if (cursor != head) {
                    delete(&cursor);
                }
                break;
            }
            case 'P': {
                insert(head, &cursor, input);
                break;
            }
            default: {
                assert(0);
            }
            }
        }
    }
    /* 출력 */
    cursor = head->next;
    while (cursor != NULL) {
        printf("%c", cursor->value);
        cursor = cursor->next;
    }

    dispose(head);

    return 0;
}

static void dispose(node_t* head)
{
    node_t* p_node = head;

    while (p_node != NULL) {
        node_t* next = p_node->next;
        free(p_node);
        p_node = next;
    }
}

static void insert(node_t* head, node_t** p_cursor, char ch)
{
    node_t* current = *p_cursor;
    node_t* new_node;

    new_node = malloc(sizeof(node_t));
    /* 동적 할당 실패 처리 생략 */
    new_node->value = ch;
    new_node->next = NULL;
    new_node->prev = NULL;

    if (current == head) {  /* 가장 앞에 삽입(헤드 바로 뒤) */
        node_t* next = current->next;
        head->next = new_node;
        new_node->prev = head;
        next->prev = new_node;
        new_node->next = next;
    } else if (current->next == NULL) { /* 가장 뒤에 삽입 */
        current->next = new_node;
        new_node->prev = current;
        new_node->next = NULL;
    } else {
        node_t* next = current->next;
        current->next = new_node;
        new_node->prev = current;
        next->prev = new_node;
        new_node->next = next;
    }
    /* 커서는 새로운 노드를 참조 */
    *p_cursor = new_node;
}

static void delete(node_t** p_cursor)
{
    node_t* target = *p_cursor;
    node_t* prev = target->prev;
    node_t* next = target->next;

    if (next != NULL) { /* case1: 중간에서 삭제 */
        (next)->prev = prev;
    }
    prev->next = next;  /* case1: 중간에서 삭제, case2: 맨 뒤 삭제 */
    /* 커서는 기존에 참조하던 노드의 이전을 참조*/
    *p_cursor = prev;
    free(target);
}
