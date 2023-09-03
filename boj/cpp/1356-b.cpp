#include <iostream>
#include <string>

using namespace std;

long long go(const string &number);

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	bool flag = false;
	string n;
	cin >> n;
	for (size_t i = 1; i < n.size(); i++)
	{
		if (go(n.substr(0, i)) == go(n.substr(i)))
		{
			flag = true;
			break;
		}
	}

	cout << (flag ? "YES" : "NO");

	return 0;
}

long long go(const string &number)
{
	long long res = 1;
	for (char e : number)
	{
		res *= (int)(e - '0');
	}
	return res;
}
