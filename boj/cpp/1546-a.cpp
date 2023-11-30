#include <bits/stdc++.h>
using namespace std;

int n;
int _input;
int max_v;
vector<int> _list;
int main()
{
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> _input;
        _list.push_back(_input);
    }

    max_v = *max_element(_list.begin(), _list.end());

    cout << (accumulate(_list.begin(), _list.end(), 0.0)) * 100 / max_v / n << "\n";
}