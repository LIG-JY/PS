#include <bits/stdc++.h>
using namespace std;

string s;
int table[10];
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s;
	for (int i = 0; i < 10; i++)
	{
		table[i] = 0;
	}
	for (auto c : s)
	{
		table[c - '0']++;
	}
	int x = 0; // 6,9 제외 최소 필요한 판 개수
	int y = 0; // 6,9 합쳐서 개수 세기
	for (int i = 0; i < 10; i++)
	{
		if (i != 6 && i != 9)
		{
			if (x < table[i])
			{
				x = table[i];
			}
		}
		else
		{
			y += table[i];
		}
	}
	if (y % 2 == 1)
	{
		y = y / 2 + 1;
	}
	else
	{
		y = y / 2;
	}
	cout << max(x, y);
}