#include <bits/stdc++.h>
using namespace std;

string input;
int res;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 1; i <= 8; i++)
	{
		cin >> input;
		if (i % 2 == 1)
		{
			for (int j = 0; j < input.size(); j++)
			{
				if ((input[j] == 'F') && (j % 2 == 0))
				{
					res++;
				}
			}
		}
		else
		{
			for (int j = 0; j < input.size(); j++)
			{
				if ((input[j] == 'F') && (j % 2 == 1))
				{
					res++;
				}
			}
		}
	}
	cout << res;

	return 0;
}
