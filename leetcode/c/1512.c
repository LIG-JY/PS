#include <string.h>

#define SIZE (100)

/**
 * 1512. Number of Good Pairs
 */

static int get_comb(int n);

int numIdenticalPairs(int* nums, int numsSize)
{
    int hash_table[SIZE + 1];
    int i;
    int res = 0;

    memset(hash_table, 0, SIZE + 1);

    for (i = 0; i < numsSize; ++i) {
        int key = nums[i];
        int value = hash_table[key];
        hash_table[key] = value + 1;
    }

    for (i = 1; i <= SIZE; ++i) {
        if (hash_table[i] > 1) {
            res += get_comb(hash_table[i]);
        }
    }

    return res;
}

static int get_comb(int n)
{
    return n * (n - 1) / 2;
}