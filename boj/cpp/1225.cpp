#include <bits/stdc++.h>

using namespace std;

string A, B;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> A >> B;
	long long res = 0;
	for (char c : A)
	{
		for (char d : B)
		{
			res += (c - '0') * (d - '0');
		}
	}
	cout << res;
	return 0;
}
