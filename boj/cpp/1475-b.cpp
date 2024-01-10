#include <bits/stdc++.h>
using namespace std;

string num;
int nums[10];
int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> num;

	for (char e : num)
	{
		int index = (int)(e - '0');
		nums[index]++;
	}

	int six_nine = (nums[6] + nums[9]) / 2 + (nums[6] + nums[9]) % 2;
	nums[6] = nums[9] = six_nine;

	cout << *max_element(nums, nums + 10);

	return 0;
}
