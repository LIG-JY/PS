#include <bits/stdc++.h>

using namespace std;

int n;
vector<int> sequence(21, -1);
int fibo(int nth, vector<int> &arr)
{
	if (nth == 0)
	{
		return 0;
	}
	else if (nth == 1)
	{
		return 1;
	}
	if (arr[nth] == -1)
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
	cout << fibo(n, sequence) << "\n";

	return 0;
}
