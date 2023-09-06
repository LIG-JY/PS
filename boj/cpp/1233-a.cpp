#include <bits/stdc++.h>

using namespace std;

int s1, s2, s3;
int table[81];
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> s1 >> s2 >> s3;

	for (int i = 1; i <= s1; i++)
	{
		for (int j = 1; j <= s2; j++)
		{
			for (int k = 1; k <= s3; k++)
			{
				table[i + j + k]++;
			}
		}
	}
	int *max_pos = max_element(table, table + 81);
	cout << max_pos - table;

	return 0;
}