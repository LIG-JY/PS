#include <bits/stdc++.h>
using namespace std;

void pad(string &res)
{
	while (res.size() < 3)
	{
		res = "0" + res;
	}
}

string getBinary(char n)
{
	int num = n - '0';
	if (num > 7)
	{
		return "";
	}
	if (num == 0)
	{
		return "0";
	}
	string res = "";
	while (num)
	{
		res = ((num & 1) ? "1" : "0") + res;
		num >>= 1;
	}
	return res;
}

string b, binary;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> b;
	for (int i = 0; i < b.size(); i++)
	{
		char c = b[i];
		binary = getBinary(c);
		if (i > 0)
		{
			pad(binary);
		}
		cout << binary;
	}
	// 36ms
	return 0;
}
