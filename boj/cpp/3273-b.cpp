#include <bits/stdc++.h>
using namespace std;

int n, x;
int main()
{
    scanf("%d", &n);

    int *nums = (int *)calloc(n, sizeof(int));

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &nums[i]);
    }

    scanf("%d", &x);
    int *cnt = (int *)calloc(x, sizeof(int));

    int res = 0;
    for (int i = 0; i < n; i++)
    {
        int value = nums[i];

        if (value >= x)
        {
            continue;
        }
        if (cnt[x - value] == 1)
        {
            res++;
        }
        cnt[value] = 1;
    }

    printf("%d\n", res);

    free(nums);
    free(cnt);

    return 0;
}
