#include <bits/stdc++.h>
using namespace std;

long long go(string number);

string n;
bool flag;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;
	for (int i = 1; i < n.size(); i++)
	{
		if (go(n.substr(0, i)) == go(n.substr(i)))
		{
			flag = true;
		}
	}

	if (flag)
	{
		cout << "YES";
	}
	else
	{
		cout << "NO";
	}

	return 0;
}

long long go(string number)
{
	long long res = 1;
	for (char e : number)
	{
		res *= (int)(e - '0');
	}
	return res;
}
