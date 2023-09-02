#include <bits/stdc++.h>
using namespace std;

int arr[1001];
int idx, start, last, res;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	idx = 1;
	for (int num = 1; num <= 1000 && idx <= 1000; num++)
	{
		for (int j = 1; j <= num && idx <= 1000; j++)
		{
			arr[idx++] = num;
		}
	}

	cin >> start >> last;
	for (int i = start; i <= last; i++)
	{
		res += arr[i];
	}
	cout << res;
	return 0;
}