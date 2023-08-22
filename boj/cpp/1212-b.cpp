#include <bits/stdc++.h>
using namespace std;

void remove_pad(string &res)
{
	while (res.size() > 1 && res[0] == '0')
	{
		res.erase(0, 1);
	}
}

string b, binary, table[8] = {"000", "001", "010", "011", "100", "101", "110", "111"};
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> b;
	for (int i = 0; i < b.size(); i++)
	{
		int index = b[i] - '0';
		if (index > 7)
		{
			return 0;
		}
		string test = table[index];
		if (i == 0)
		{
			remove_pad(test);
		}
		cout << test;
	}
	// 16ms
	return 0;
}
