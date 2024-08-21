#include <stdlib.h>

#if 0
933. Number of Recent Calls
Runtime: 217ms Beats 26.85%
Memory: 42.04MB Beats 34.23%
#endif

#define CAPACITY (10000)

typedef struct {
    int times[CAPACITY];
    int length;
} RecentCounter;


RecentCounter* recentCounterCreate(void)
{
    RecentCounter* recentCounter = malloc(sizeof(RecentCounter));
    recentCounter->length = 0;

    return recentCounter;
}

int recentCounterPing(RecentCounter* obj, int t)
{
    int res = 0;
    obj->times[obj->length] = t;
    int i = obj->length;
    while (i >= 0) {
        if (obj->times[i] < t - 3000) {
            break;
        }
        ++res;
        --i;
    }
    ++(obj->length);

    return res;
}

void recentCounterFree(RecentCounter* obj)
{
    free(obj);
}

/**
 * Your RecentCounter struct will be instantiated and called as such:
 * RecentCounter* obj = recentCounterCreate();
 * int param_1 = recentCounterPing(obj, t);
 
 * recentCounterFree(obj);
*/