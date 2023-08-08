#include <bits/stdc++.h>
using namespace std;

int n, k;
int isOut[5001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;
	cout << "<";
	int i = 1;
	int cnt = 0;
	int temp = 0;
	while (cnt < n)
	{
		i = (i - 1) % n + 1;
		if (isOut[i] == 0)
		{
			temp++;
		}

		if (temp == k)
		{
			cout << i;
			isOut[i] = 1;
			cnt++;
			if (cnt < n)
			{
				cout << ", ";
			}
			temp = 0;
		}
		i++;
	}
	cout << ">";
}