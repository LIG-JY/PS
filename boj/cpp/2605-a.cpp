#include <bits/stdc++.h>
using namespace std;

int n, input, line[101];
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> input;
		if (line[input] == 0)
		{
			line[input] = i; // input => 자리
		}
		else
		{
			for (int j = i - 1; j > input; j--)
			{
				line[j] = line[j - 1];
			}
			line[input] = i;
		}
	}

	for (int i = n - 1; i >= 0; i--)
	{
		cout << line[i];
		if (i > 0)
		{
			cout << " ";
		}
	}

	return 0;
}
