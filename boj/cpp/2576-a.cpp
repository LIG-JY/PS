#include <bits/stdc++.h>
using namespace std;

int n, min_v, odd_sum;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    min_v = 100;

    for (int i = 1; i <= 7; i++)
    {
        cin >> n;
        if (n & 1)
        {
            odd_sum += n;
            if (n < min_v)
            {
                min_v = n;
            }
        }
    }

    if (odd_sum == 0)
    {
        cout << -1 << "\n";
    }
    else
    {
        cout << odd_sum << "\n"
             << min_v;
    }
    return 0;
}
