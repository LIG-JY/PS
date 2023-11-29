#include <bits/stdc++.h>
using namespace std;

int n;
vector<string> _list;
set<string> _set;
string _input;

bool cmp(string &a, string &b)
{
    if (a.size() == b.size())
    {
        return a < b;
    }
    return a.size() < b.size();
}

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

    for (auto e : _set)
    {
        _list.push_back(e);
    }
    sort(_list.begin(), _list.end(), cmp);

    for (auto e : _list)
    {
        cout << e << "\n";
    }

    return 0;
}