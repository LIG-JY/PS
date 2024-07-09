#include <stdio.h>
#include <string.h>
#include <stdlib.h>

static int s_count = 0;

typedef struct node {
    int value;
    struct node* next;
} node_t;

static void insert(node_t** phead, int n)
{
    node_t* tail;
    node_t* new_node = malloc(sizeof(node_t));
    new_node->value = n;
    new_node->next = new_node;  /* 원형 연결 리스트 */

    ++s_count;
    /* 빈 원형 연결 리스트에 삽입 */
    if (*phead == NULL) {
        *phead = new_node;
        return;
    }

    tail = *phead;
    while (tail->next != *phead) {
        tail = tail->next;
    }
    tail->next = new_node;
    new_node->next = *phead;
}

int main(void)
{
    int N;
    int K;
    char buffer[10];
    int i;
    node_t* head = NULL;
    node_t* cur = NULL;
    node_t* prev = NULL;

    fgets(buffer, 11, stdin);

    sscanf(buffer, "%d%d", &N, &K);

    for (i = 1; i <= N; ++i) {
        insert(&head, i);
    }

    prev = head;
    while (prev->next != head) {
        prev = prev->next;
    }

    printf("<");
    cur = head;
    i = 1;
    while (s_count > 0) {
        if (i == K) {
            node_t* next = cur->next;
            if (s_count != 1) {
                printf("%d, ", cur->value);
            } else {
                printf("%d>", cur->value);
            }

            if (cur == head) {
                head = next;
            }
            free(cur);
            if (s_count > 1) {
                cur = next;
                prev->next = cur;
            }
            --s_count;
            i = 1;
            continue;
        }
        prev = cur;
        cur = cur->next;
        ++i;
    }

    return 0;
}
