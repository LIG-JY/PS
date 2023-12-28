#include <bits/stdc++.h>
using namespace std;

int n;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < i; j++)
        {
            cout << " ";
        }
        for (int k = i; k < n; k++)
        {
            cout << "*";
        }
        cout << "\n";
    }

    return 0;
}