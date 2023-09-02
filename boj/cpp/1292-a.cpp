#include <bits/stdc++.h>
using namespace std;

int arr[1001];
int num, temp, start, last, res;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 1; i <= 1000; i++)
	{
		if (temp == 0)
		{
			num++;
			temp = num;
		}
		arr[i] = num;
		temp--;
	}

	cin >> start >> last;
	for (int i = start; i <= last; i++)
	{
		res += arr[i];
	}
	cout << res;
}