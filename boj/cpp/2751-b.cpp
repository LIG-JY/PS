#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> _list;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    while (n--)
    {
        int input;
        cin >> input;
        _list.push_back(input);
    }
    sort(_list.begin(), _list.end());
    for (const auto &e : _list)
    {
        cout << e << "\n";
    }
    return 0;
}