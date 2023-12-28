#include <bits/stdc++.h>
using namespace std;

int n;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int outer = 1; outer <= n; outer++)
    {
        for (int inner = 1; inner <= n - outer; inner++)
        {
            cout << " ";
        }
        for (int inner = 1; inner <= 2 * outer - 1; inner++)
        {
            cout << "*";
        }
        cout << "\n";
    }

    return 0;
}