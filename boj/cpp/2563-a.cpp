#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> table(100, vector<int>(100, 0));
int t, x, y;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--)
	{
		cin >> x >> y;
		for (int i = y; i < y + 10; i++)
		{
			for (int j = x; j < x + 10; j++)
			{
				table[i][j]++;
			}
		}
	}

	int res = 0;
	for (auto i : table)
	{
		for (auto j : i)
		{
			// cout << j;
			if (j > 0)
			{
				res++;
			}
		}
		// cout << "\n";
	}

	cout << res;

	return 0;
}
