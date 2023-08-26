#include <bits/stdc++.h>

using namespace std;

string input;
string dial;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	dial = "00ADGJMPTW"; // ASCII 0 : 48

	cin >> input;
	int res = 0;
	for (char i : input)
	{
		for (char d : dial)
		{
			if (i >= d)
			{
				res++;
			}
		}
	}
	cout << res;

	return 0;
}
