#include <bits/stdc++.h>

using namespace std;
// linked list
typedef struct Node {
    char value;
    Node *prev;
    Node *next;
} Node;
Node *dummy = (Node *) calloc(1, sizeof(Node));
int len = 0;
// problem input
char s[100001];
int n;
char cmd[4];

// main
int main() {
    scanf("%s", s);
    size_t length = (int) strlen(s);
    for (int i = 0; i < length; i++) {
        Node *tail = dummy;
        Node *new_node = (Node *) calloc(1, sizeof(Node));
        new_node->value = s[i];
        new_node->next = tail;
        if (len == 0) {
            new_node->prev = nullptr;
        } else {
            tail->prev->next = new_node;
            new_node->prev = tail->prev;
        }
        tail->prev = new_node;
        len++;
    }
    scanf("%d", &n);
    Node *pNode = dummy;
    while (n--) {
        scanf("%s", cmd);
        switch (cmd[0]) {
            case 'L':
                if (pNode->prev != nullptr) pNode = pNode->prev;
                break;
            case 'D':
                if (pNode->next != nullptr) pNode = pNode->next;
                break;
            case 'B':
                if (len > 0 && pNode->prev != nullptr) {
                    Node *target = pNode->prev;
                    if (target->prev != nullptr) target->prev->next = pNode;
                    pNode->prev = target->prev;
                    free(target);
                    len--;
                }
                break;
            default:
                scanf("%s", cmd);
                Node *new_node = (Node *) calloc(1, sizeof(Node));
                new_node->value = cmd[0];
                new_node->next = pNode;
                new_node->prev = pNode->prev;
                if (pNode->prev != nullptr) pNode->prev->next = new_node;
                pNode->prev = new_node;
                len++;
                break;
        }
    }
    // find head
    Node *head_node = dummy;
    for (int i = 0; i < len; i++) {
        head_node = head_node->prev;
    }
    for (int i = 0; i < len; i++) {
        printf("%c", head_node->value);
        head_node = head_node->next;
    }
    return 0;
}