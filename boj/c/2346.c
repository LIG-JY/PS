#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define LENGTH (5000)    /* (4자리 + 공백) * 1000 */

typedef struct node {
    int value;
    int step;
    struct node* next;
    struct node* prev;
} node_t;

int main(void)
{
    char buffer[LENGTH + 1];
    int N;
    int i;
    char* token = NULL;
    node_t* head = NULL;
    node_t* tail = NULL;
    node_t* node_to_remove = NULL;

    if (!fgets(buffer, LENGTH + 1, stdin)) {
        fprintf(stderr, "Error reading input\n");
        return 1;
    }
    if (sscanf(buffer, "%d", &N) != 1) {
        fprintf(stderr, "Error parsing N\n");
        return 1;
    }

    if (!fgets(buffer, LENGTH + 1, stdin)) {
        fprintf(stderr, "Error reading input\n");
        return 1;
    }
    token = strtok(buffer, " ");
    i = 1;
    while (token != NULL) {
        int step = atoi(token);
        node_t* new_node = (node_t*)malloc(sizeof(node_t));
        if (!new_node) {
            fprintf(stderr, "Memory allocation failed\n");
            return 1;
        }
        new_node->value = i;
        new_node->step = step;
        if (head == NULL) {
            head = new_node;
            new_node->next = new_node;
            new_node->prev = new_node;
        } else {
            tail->next = new_node;
            new_node->prev = tail;
            new_node->next = head;
            head->prev = new_node;
        }
        tail = new_node;
        token = strtok(NULL, " ");
        ++i;
    }

    node_to_remove = head;
    while (N--) {
        node_t* temp;
        int step = node_to_remove->step;
        printf("%d ", node_to_remove->value);

        /* Remove the node */
        node_to_remove->prev->next = node_to_remove->next;
        node_to_remove->next->prev = node_to_remove->prev;

        temp = node_to_remove;
        if (step > 0) {
            for (i = 0; i < step; i++) {
                node_to_remove = node_to_remove->next;
            }
        } else if (step < 0) {
            for (i = step; i < 0; i++) {
                node_to_remove = node_to_remove->prev;
            }
        }

        /* Free the removed node */
        free(temp);
    }

    return 0;
}
