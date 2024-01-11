#include <bits/stdc++.h>
using namespace std;

int n, x;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    int *nums = (int *)malloc(sizeof(int) * n);

    for (int i = 0; i < n; i++)
    {
        cin >> nums[i];
    }

    cin >> x;
    int *cnt = (int *)malloc(sizeof(int) * x);

    int res = 0;
    for (int i = 0; i < n; i++)
    {
        int value = *(nums + i);

        if (value >= x)
        {
            continue;
        }
        if (*(cnt + x - value))
        {
            res++;
        }
        *(cnt + value) = 1;
    }

    cout << res;
    return 0;
}
