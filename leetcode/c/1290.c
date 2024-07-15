#include <string.h>

/**
 * 1290. Convert Binary Number in a Linked List to Integer
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

int getDecimalValue(struct ListNode* head) {
    int res = 0;

    while (head != NULL) {
        res = 2 * res + head->val;
        head = head->next;
    }

    return res;
}