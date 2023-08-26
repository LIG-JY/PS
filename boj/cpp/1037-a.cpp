#include <bits/stdc++.h>

using namespace std;

int n, input;
vector<int> divisor_list;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;
	while (n--)
	{
		cin >> input;
		divisor_list.push_back(input);
	}

	sort(divisor_list.begin(), divisor_list.end());

	cout << (*divisor_list.begin()) * (*(divisor_list.end() - 1));

	return 0;
}
