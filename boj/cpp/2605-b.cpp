#include <bits/stdc++.h>
using namespace std;

int n, input;
vector<int> line(101);
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> input;

		line.insert(line.begin() + input, i);
	}

	for (int i = n - 1; i >= 0; i--)
	{
		cout << line[i];
		if (i > 0)
		{
			cout << " ";
		}
	}

	return 0;
}
