#include <bits/stdc++.h>

using namespace std;
// linked list
typedef struct Node {
    char value;
    Node* prev;
    Node* next;
} Node;
Node* tail_dummy = (Node*)calloc(1, sizeof(Node));
Node* head = nullptr;
// problem input
char s[100001];
int n;
char cmd[4];

// main
int main() {
    scanf("%s", s);
    // for (int i = 0; i < strlen(s); i++) -> strlen(s) is called every iteration of the loop
    // for (int i = 0; i < length; i++) -> length is called once
    // this can be a huge performance boost
    size_t length = strlen(s);
    for (int i = 0; i < length; i++) {
        Node* new_node = (Node*)calloc(1, sizeof(Node));
        new_node->value = s[i];
        new_node->next = tail_dummy;
        if (tail_dummy->prev == nullptr) {
            head = new_node;
        }
        else {
            (tail_dummy->prev)->next = new_node;
            new_node->prev = tail_dummy->prev;
        }
        tail_dummy->prev = new_node;
    }
    scanf("%d", &n);
    Node* pNode = tail_dummy;
    while (n--) {
        scanf("%s", cmd);
        switch (cmd[0]) {
        case 'L':
            if (pNode != head) {
                pNode = pNode->prev;
            }
            break;
        case 'D':
            if (pNode != tail_dummy) {
                pNode = pNode->next;
            }
            break;
        case 'B':
            if (pNode != head) {
                Node* target = pNode->prev;
                if (target != head) {
                    (target->prev)->next = pNode;
                }
                else {
                    head = pNode;
                }
                pNode->prev = target->prev; // pNode == target->next;
                free(target);
            }
            break;
        default:
            scanf("%s", cmd);
            Node* new_node = (Node*)calloc(1, sizeof(Node));
            new_node->value = cmd[0];
            new_node->next = pNode;
            new_node->prev = pNode->prev;
            if (pNode != head) {
                (pNode->prev)->next = new_node;
            }
            else {
                head = new_node;
            }
            pNode->prev = new_node;
            break;
        }
    }
    // print
    Node* current = head;
    while (current->next != nullptr) {
        printf("%c", current->value);
        current = current->next;
    }
    return 0;
}