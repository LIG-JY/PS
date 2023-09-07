#include <bits/stdc++.h>
using namespace std;

int n, input;
vector<int> line;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> input;

		// Ensure the vector is large enough to accommodate the index "input"
		while (line.size() <= input)
		{
			line.push_back(0);
		}

		if (line[input] == 0)
		{
			line[input] = i; // input => 자리
		}
		else
		{
			line.insert(line.begin() + input, i);
		}
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
