#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (150)    /* (두자리 + 공백) * 50 */

typedef struct node {
    int value;
    struct node* next;
    struct node* prev;
} node_t;

static void dispose(node_t* head);

int main(void)
{
    char buffer[LENGTH + 1];
    int N;
    int M;
    int i;
    int* to_remove = NULL;
    char* token = NULL;
    node_t* head = NULL;
    int res = 0;

    fgets(buffer, LENGTH + 2, stdin);
    /* 입력 오류 처리 생략 */
    sscanf(buffer, "%d %d", &N, &M);

    to_remove = (int*)malloc(M * sizeof(int));
    fgets(buffer, LENGTH + 2, stdin);
    /* 입력 오류 처리 생략 */
    {
        size_t len = strlen(buffer);
        if (buffer[len - 1] == '\n') {
            buffer[len - 1] = '\0';
        }
    }
    token = strtok(buffer, " ");
    for (i = 0; i < M; ++i) {
        to_remove[i] = atoi(token);
        token = strtok(NULL, " ");
    }
    for (i = 0; i < N; ++i) {
        node_t* node;

        node = malloc(sizeof(node_t));
        /* 메모리 할당 오류 생략 */
        node->value = i + 1;
        node->next = NULL;
        node->prev = NULL;
        if (i == 0) {
            node->next = node;
            node->prev = node;
            head = node;
        } else {
            (head->prev)->next = node;
            node->prev = (head->prev);
            head->prev = node;
            node->next = head;
        }
    }

    for (i = 0; i < M; ++i) {
        int left_cnt = 0;
        int right_cnt = 0;

        {
            node_t* cursor = head;
            while (cursor->value != to_remove[i]) {
                ++right_cnt;
                cursor = cursor->next;
            }
        }

        {
            node_t* cursor = head;
            while (cursor->value != to_remove[i]) {
                ++left_cnt;
                cursor = cursor->prev;
            }
        }

        if (left_cnt > right_cnt) {
            /* 3번 연산: 오른쪽으로 이동 */
            int j;
            for (j = 0; j < right_cnt; ++j) {
                head = head->next;
            }
            res += right_cnt;
        } else {
            /* 2번 연산: 왼쪽으로 이동 */
            int j;
            for (j = 0; j < left_cnt; ++j) {
                head = head->prev;
            }
            res += left_cnt;
        }
        /* 1번 연산: 첫번째 원소 제거 */
        {
            node_t* new_head = head->next;
            (head->prev)->next = head->next;
            (head->next)->prev = head->prev;
            if (head == new_head) { /* 노드가 1개인 경우 */
                free(head);
                head = NULL;
            } else {
                free(head);
                head = new_head;
            }
        }
    }
    printf("%d", res);

    free(to_remove);
    dispose(head);

    return 0;
}

static void dispose(node_t* head)
{
    node_t* current;

    if (head == NULL) {
        return;
    }

    current = head->next;
    while (current != head) {
        node_t* next = current->next;
        free(current);
        current = next;
    }
    free(current);
}
