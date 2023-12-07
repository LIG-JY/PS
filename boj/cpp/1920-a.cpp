#include <bits/stdc++.h>
using namespace std;

int n, m, _input;
unordered_set<int> table;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    while (n--)
    {
        cin >> _input;
        table.insert(_input);
    }
    cin >> m;
    while (m--)
    {
        cin >> _input;
        cout << (table.count(_input) ? 1 : 0) << "\n";
    }
    return 0;
}