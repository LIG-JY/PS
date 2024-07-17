#include <string.h>
#include <stdlib.h>

/**
 * 206. Reverse Linked List
 *
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode {
    int val;
    struct ListNode* next;
};

struct ListNode* reverseList(struct ListNode* head)
{
    struct ListNode* p;
    struct ListNode* prev = NULL;

    p = head;
    while (p!= NULL) {
        struct ListNode* next = p->next;
        p->next = prev;
        prev = p;
        p = next;
    }

    return prev;
}

int main(void) {
    struct ListNode* node1 = malloc(sizeof(struct ListNode));
    struct ListNode* node2 = malloc(sizeof(struct ListNode));
    struct ListNode* node3 = malloc(sizeof(struct ListNode));

    node1->next = node2;
    node1->val = 1;
    node2->next = node3;
    node2->val = 2;
    node3->next = NULL;
    node3->val = 3;

    struct ListNode* res = reverseList(node1);

    free(node1);
    free(node2);
    free(node3);

    return 0;
}

