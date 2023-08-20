#include <bits/stdc++.h>
using namespace std;

int t, a, b;
long long num;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--)
	{
		num = 1;
		cin >> a >> b;
		if (a == 1)
		{
			cout << 1 << "\n";
			continue;
		}
		if (a % 10 == 0)
		{
			cout << 10 << "\n";
			continue;
		}
		while (b--)
		{
			num = (num % 10) * a;
		}
		cout << num % 10 << "\n";
	}

	return 0;
}
