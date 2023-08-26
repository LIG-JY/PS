#include <bits/stdc++.h>

using namespace std;

string input;
map<char, int> dial;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int START_NUM = 3;
	for (char a = 'A'; a <= 'O'; a++)
	{
		dial[a] = START_NUM;
		if (a % 3 == 1)
		{
			START_NUM++;
		}
	}
	for (char a = 'P'; a <= 'S'; a++)
	{
		dial[a] = 8;
	}
	for (char a = 'T'; a <= 'V'; a++)
	{
		dial[a] = 9;
	}
	for (char a = 'W'; a <= 'Z'; a++)
	{
		dial[a] = 10;
	}
	// ASCII A : 65

	cin >> input;
	int res = 0;
	for (auto i : input)
	{
		res += dial[i];
	}
	cout << res;

	return 0;
}
