#include <stdlib.h>

#if 0
933. Number of Recent Calls
Runtime: 284ms Beats 14.77%
Memory: 44.80MB Beats 12.08%
#endif

typedef struct node {
    int val;
    struct node* next;
} node_t;

typedef struct {
    int counter;
    node_t* head;
} RecentCounter;


RecentCounter* recentCounterCreate(void)
{
    RecentCounter* recentCounter = malloc(sizeof(RecentCounter));
    recentCounter->counter = 0;
    recentCounter->head = NULL;

    return recentCounter;
}

int recentCounterPing(RecentCounter* obj, int t)
{
    node_t* new_node = malloc(sizeof(node_t));
    new_node->next = NULL;
    new_node->val = t;

    new_node->next = obj->head;
    obj->head = new_node;

    int res = 0;
    node_t* ph = obj->head;
    while (ph != NULL) {
        if (ph->val >= t - 3000 && ph->val <= t) {
            ++res;
        } else {
            break;
        }
        ph = ph->next;
    }
    obj->counter = res;
    return res;
}

void recentCounterFree(RecentCounter* obj)
{
    node_t* p = obj->head;

    while (p != NULL) {
        node_t* next = p->next;
        free(p);
        p = next;
    }
    free(obj);
}

/**
 * Your RecentCounter struct will be instantiated and called as such:
 * RecentCounter* obj = recentCounterCreate();
 * int param_1 = recentCounterPing(obj, t);
 
 * recentCounterFree(obj);
*/