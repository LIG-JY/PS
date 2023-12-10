#include <bits/stdc++.h>
using namespace std;

int n;
deque<int> _list;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        _list.push_back(i);
    }

    int last = -1;
    while (!_list.empty())
    {
        // 젤 위 카드 버리기
        last = _list.front();
        _list.pop_front();

        // 젤 위 카드 아래로 옮기기
        if (!_list.empty())
        {
            _list.push_back(_list.front());
            _list.pop_front();
        }
    }
    cout << last;
}