#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string n, m;
	cin >> n >> m;

	reverse(n.begin(), n.end());
	reverse(m.begin(), m.end());
	for (int i = 0; i < 3; i++)
	{
		if (n[i] > m[i])
		{
			cout << n << "\n";
			break;
		}
		else if (n[i] < m[i])
		{
			cout << m << "\n";
			break;
		}
	}
	if (n == m)
	{
		cout << n << "\n";
	}

	return 0;
}
