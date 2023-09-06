#include <iostream>
using namespace std;

int n, highest, input, res(1);
int st[1000000];
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		cin >> input;
		st[i] = input;
	}
	highest = st[n];
	for (int i = n - 1; i >= 1; i--)
	{
		if (highest < st[i])
		{
			highest = st[i];
			res++;
		}
	}
	cout << res;
	return 0;
}
