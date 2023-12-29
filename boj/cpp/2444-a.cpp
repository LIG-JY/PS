#include <bits/stdc++.h>
using namespace std;

int n;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    // 상단
    for (int i = 1; i <= n - 1; i++)
    {
        for (int j = 1; j <= n - i; j++)
        {
            cout << " ";
        }
        for (int j = 1; j <= 2 * i - 1; j++)
        {
            cout << "*";
        }
        cout << "\n";
    }

    // 가운데
    for (int i = 1; i <= 2 * n - 1; i++)
    {
        cout << "*";
    }
    cout << "\n";

    // 하단
    for (int i = 1; i <= n - 1; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            cout << " ";
        }
        for (int j = 1; j <= 2 * (n - i) - 1; j++)
        {
            cout << "*";
        }
        cout << "\n";
    }

    return 0;
}