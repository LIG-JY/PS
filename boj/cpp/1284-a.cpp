#include <bits/stdc++.h>
using namespace std;

string input;
int res;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	while (getline(cin, input) && input != "0")
	{
		res = input.size() + 1;
		for (char num : input)
		{
			if (num == '1')
			{
				res += 2;
			}
			else if (num == '0')
			{
				res += 4;
			}
			else
			{
				res += 3;
			}
		}
		cout << res << "\n";
	}
}