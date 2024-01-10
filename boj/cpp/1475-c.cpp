#include <bits/stdc++.h>
using namespace std;

int N;
int nums[10];
int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	while (N)
	{
		nums[N % 10]++;
		N /= 10;
	}

	int six_nine = (nums[6] + nums[9] + 1) / 2;
	nums[6] = nums[9] = six_nine;

	cout << *max_element(nums, nums + 10);

	return 0;
}
