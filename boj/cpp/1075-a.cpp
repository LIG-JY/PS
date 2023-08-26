#include <bits/stdc++.h>

using namespace std;

int n, f, res;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n >> f;
	res = n - (n % 100);
	for (int i = 0; i <= 99; i++)
	{
		if ((res + i) % f == 0)
		{
			res = i;
			break;
		}
	}
	if (res < 10)
	{
		cout << "0" << res;
	}
	else
	{
		cout << res;
	}
	return 0;
}
