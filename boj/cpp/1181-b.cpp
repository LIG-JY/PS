#include <bits/stdc++.h>
using namespace std;

int n;
vector<string> _list;
set<string> _set;
string _input;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    while (n--)
    {
        cin >> _input;
        _set.insert(_input);
    }

    _list.assign(_set.begin(), _set.end());
    sort(_list.begin(), _list.end(), [](const string &a, const string &b)
         { return a.size() == b.size() ? a < b : a.size() < b.size(); });

    for (auto e : _list)
    {
        cout << e << "\n";
    }

    return 0;
}