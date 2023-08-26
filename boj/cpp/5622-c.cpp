#include <bits/stdc++.h>

using namespace std;

string input;
map<char, int> dial;

void initDial()
{
	int groups[8] = {3, 3, 3, 3, 3, 4, 3, 4}; // 각 숫자그룹별 알파벳 개수
	int num = 3;							  // 현재 번호
	char ch = 'A';							  // 시작 알파벳

	for (int i = 0; i < 8; i++)
	{
		for (int j = 0; j < groups[i]; j++)
		{
			dial[ch++] = num;
		}
		num++;
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	initDial();

	cin >> input;
	int res = 0;
	for (auto ch : input)
	{
		res += dial[ch];
	}
	cout << res;

	return 0;
}
