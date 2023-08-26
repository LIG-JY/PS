#include <bits/stdc++.h>

using namespace std;

int n, arr[21];
int fibo(int nth, int (&arr)[21])
{
	if (nth == 0)
	{
		arr[nth] = 0;
		return 0;
	}
	else if (nth == 1)
	{
		arr[nth] = 1;
		return 1;
	}
	if (!arr[nth])
	{
		arr[nth] = fibo(nth - 1, arr) + fibo(nth - 2, arr);
	}
	return arr[nth];
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;
	cout << fibo(n, arr) << "\n";

	return 0;
}
