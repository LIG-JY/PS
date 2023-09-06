#include <bits/stdc++.h>

using namespace std;

int n, input, y, m;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;
	while (n--)
	{
		cin >> input;
		y += (input / 30) * 10 + 10;
		m += (input / 60) * 15 + 15;
	}

	if (y > m)
	{
		cout << "M " << m;
	}
	else if (y < m)
	{
		cout << "Y " << y;
	}
	else
	{
		cout << "Y M " << y;
	}
	return 0;
}