#include <bits/stdc++.h>
using namespace std;

int n, k;
deque<int> table;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;

	for (int i = 1; i <= n; i++)
	{
		table.push_back(i);
	}

	cout << "<";
	while (!table.empty())
	{
		if (table.size() == 1)
		{
			cout << table.front() << ">";
			break;
		}
		for (int j = 1; j <= k - 1; j++)
		{
			table.push_back(table.front());
			table.pop_front();
		}
		cout << table.front() << ", ";
		table.pop_front();
	}
	return 0;
}
