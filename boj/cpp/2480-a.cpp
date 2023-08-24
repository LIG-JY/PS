#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, res;
	int dice[7];

	memset(dice, 0, sizeof(int) * 7);
	for (int i = 1; i <= 3; i++)
	{
		cin >> n;
		dice[n]++;
	}

	res = 0;
	for (int i = 1; i <= 6; i++)
	{
		if (dice[i] == 3)
		{
			cout << 10000 + i * 1000;
			return 0;
		}
		else if (dice[i] == 2)
		{
			cout << 1000 + i * 100;
			return 0;
		}
		else if (dice[i] == 1)
		{
			if (res < i)
			{
				res = i;
			}
		}
	}
	cout << res * 100;

	return 0;
}
