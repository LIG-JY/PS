#include <bits/stdc++.h>
using namespace std;

int t, n, m, value;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--)
	{
		cin >> n >> m;
		deque<pair<int, int>> q;
		int cnt = 0;
		int loc = 0;
		for (int i = 0; i < n; i++)
		{
			cin >> value;
			pair<int, int> p = {value, i};
			q.push_back(p);
		}
		while (1)
		{
			auto maxLocation = max_element(q.begin(),
										   q.end(),
										   [](const pair<int, int> &a, const pair<int, int> &b) -> bool
										   { return a.first < b.first; }); // 최대값 구하기 (a : current, b : max), 비교함수 true면 update 하지 않는다.
			while (q.front().first != maxLocation->first)
			{
				q.push_back(q.front());
				q.pop_front(); // 최대값이 front일 때까지 반복작업
			}
			loc = q.front().second;
			q.pop_front(); // 제거
			cnt++;
			if (loc == m)
			{
				break;
			}
		}
		cout << cnt << "\n";
	}
}