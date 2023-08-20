#include <bits/stdc++.h>
using namespace std;

string a;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a;
	for (auto c : a)
	{
		if (isupper(c))
		{
			cout << (char)(c + 32);
		}
		else
		{
			cout << (char)(c - 32); // toupper(c);
		}
	}
	return 0;
}
