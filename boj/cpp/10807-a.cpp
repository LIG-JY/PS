#include <bits/stdc++.h>
using namespace std;

int n, v;
int main()
{
    scanf("%d", &n);

    int *cnt = (int *)calloc(n + 100, sizeof(int));
    for (int i = 0; i < n; i++)
    {
        int index = 0;
        scanf("%d", &index);
        cnt[index + 100]++;
    }

    scanf("%d", &v);

    printf("%d", cnt[v + 100]);

    return 0;
}
