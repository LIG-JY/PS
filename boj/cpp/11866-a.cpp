#include <bits/stdc++.h>
using namespace std;

int n, k;
deque<int> q;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;
	for (int i = 1; i <= n; i++)
	{
		q.push_back(i);
	}

	cout << "<";

	while (!q.empty())
	{
		for (int j = 1; j <= k - 1; j++)
		{
			q.push_back(q.front());
			q.pop_front();
		}

		cout << q.front();
		if (q.size() != 1)
		{
			cout << ", ";
		}
		q.pop_front();
	}

	cout << ">";
}
