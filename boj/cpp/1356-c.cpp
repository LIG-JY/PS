#include <iostream>
#include <string>

using namespace std;
long long go(const string &target, int begin_idx, int end_idx);

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	bool flag = false;
	string n;
	cin >> n;
	for (size_t i = 0; i < n.size() - 1; i++)
	{
		if (go(n, 0, i) == go(n, i + 1, n.size() - 1))
		{
			flag = true;
			break;
		}
	}

	cout << (flag ? "YES" : "NO");

	return 0;
}

long long go(const string &target, int begin_idx, int end_idx)
{
	long long res = 1;
	for (int i = begin_idx; i <= end_idx; i++)
	{
		res *= (int)(target[i] - '0');
	}
	return res;
}
