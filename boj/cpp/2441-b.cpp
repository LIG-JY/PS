#include <bits/stdc++.h>
using namespace std;

int n;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int outer = 0; outer < n; outer++)
    {
        int inner = 0;
        for (; inner < outer; inner++)
        {
            cout << " ";
        }
        for (; inner < n; inner++)
        {
            cout << "*";
        }
        cout << "\n";
    }

    return 0;
}