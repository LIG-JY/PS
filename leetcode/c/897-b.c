#include <stdio.h>

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

static struct TreeNode* increasingBSTHelper(struct TreeNode* root, struct TreeNode* tail)
{
    if (root == NULL) {
        return tail;
    }

    struct TreeNode* new_root = increasingBSTHelper(root->left, root);
    root->left = NULL;
    root->right = increasingBSTHelper(root->right, tail);

    return new_root;
}

struct TreeNode* increasingBST(struct TreeNode* root)
{
    return increasingBSTHelper(root, NULL);
}