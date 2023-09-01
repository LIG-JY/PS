#include <bits/stdc++.h>
using namespace std;

int flex[15][15];
int t, k, n;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 1; i < 15; i++)
	{
		flex[0][i] = i;
	}
	for (int floor = 1; floor < 15; floor++)
	{
		int cumsum = 0;
		for (int i = 1; i < 15; i++)
		{
			cumsum += flex[floor - 1][i];
			flex[floor][i] = cumsum;
		}
	}
	// for (int i = 0; i < 15; i++)
	// {
	// 	for (int floor = 1; floor < 15; floor++)
	// 	{
	// 		cout << flex[i][floor] << "|";
	// 	}
	// 	cout << "\n";
	// }
	cin >> t;
	while (t--)
	{
		cin >> k >> n;
		cout << flex[k][n] << "\n";
	}
	return 0;
}