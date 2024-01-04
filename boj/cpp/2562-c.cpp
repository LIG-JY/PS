#include <bits/stdc++.h>
using namespace std;

int n, max_v, max_idx;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 1; i <= 9; i++)
    {
        cin >> n;
        if (n > max_v)
        {
            max_v = n;
            max_idx = i;
        }
    }

    cout << max_v << "\n"
         << max_idx;
    return 0;
}
