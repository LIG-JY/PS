#include <bits/stdc++.h>
using namespace std;

int num;
int cnt[10];
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int res = 1;

    for (int i = 0; i < 3; i++)
    {
        cin >> num;
        res *= num;
    }

    while (true)
    {
        cnt[res % 10]++;
        res /= 10;
        if (res == 0)
        {
            break;
        }
    }

    for (int e : cnt)
    {
        cout << e << "\n";
    }

    return 0;
}
