#include <bits/stdc++.h>
using namespace std;

list<char> l;
string s;
int n;
char command, character;
int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> s;
	for (char c : s)
	{
		l.push_back(c);
	}
	auto cursor = l.end();
	cin >> n;
	while (n--)
	{
		cin >> command;
		switch (command)
		{
		case 'P':
			cin >> character;
			l.insert(cursor, character);
			break;
		case 'L':
			if (!l.empty() && cursor != l.begin()) cursor--;
			break;
		case 'D':
			if (!l.empty() && cursor != l.end()) cursor++;
			break;
		default:
			if (!l.empty() && cursor != l.begin())
			{
				cursor = l.erase(--cursor);
			}
		}
	}
	for (auto it = l.begin(); it != l.end(); it++)
	{
		cout << *it;
	}
	return 0;
}