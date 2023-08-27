#include <bits/stdc++.h>
using namespace std;

string a, b, res;
int a_len, b_len, len, temp, add;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> a >> b;

	a_len = a.size();
	b_len = b.size();

	if (a_len > b_len)
	{
		for (int i = 1; i <= a_len - b_len; i++)
		{
			b = "0" + b;
		}
		len = a_len;
	}
	else
	{
		for (int i = 1; i <= b_len - a_len; i++)
		{
			a = "0" + a;
		}
		len = b_len;
	}

	res = "";
	temp = 0;
	add = 0;
	for (int i = len - 1; i >= 0; i--)
	{
		add = a[i] - '0' + b[i] - '0' + temp;
		if (add > 1)
		{
			temp = 1;
			res = to_string((add - 2)) + res;
		}
		else
		{
			temp = 0;
			res = to_string(add) + res;
		}
	}
	if (temp == 1)
	{
		res = "1" + res;
	}
	bool flag = false;
	for (auto c : res)
	{
		if (!flag && c != '0')
		{
			flag = true;
		}
		if (flag)
		{
			cout << c;
		}
	}
	if (!flag)
	{
		cout << "0";
	}
}