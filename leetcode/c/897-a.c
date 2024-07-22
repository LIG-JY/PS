#include "stdlib.h"

/**
 * 897. Increasing Order Search Tree
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

static void put_node(struct TreeNode** arr, int* size, struct TreeNode* root)
{
    if (root == NULL) {
        return;
    }

    put_node(arr, size, root->left);
    arr[(*size)++] = root;
    put_node(arr, size, root->right);
}

struct TreeNode* increasingBST(struct TreeNode* root)
{
    struct TreeNode* arr[101] = { NULL, };  /* The number of nodes in the given tree will be in the range [1, 100]. */
    int size = 0;
    int i;
    struct TreeNode* res = NULL;

    put_node(arr, &size, root);
    res = arr[0];
    for (i = 0; i < size; ++i) {
        arr[i]->right = arr[i + 1];
        arr[i]->left = NULL;
    }

    return res;
}

int main(void)
{

    return 0;
}
