#include <bits/stdc++.h>

using namespace std;

int t;
string input;

void sol(string &text)
{
	vector<string> res;
	size_t pos;

	while ((pos = text.find(" ") != string::npos))
	{
		res.push_back(text.substr(0, pos));
		text.erase(0, pos + 1);
	}
	res.push_back(text);

	for (auto i : res)
	{
		cout << i << " ";
	}
	cout << "\n";
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> t;
	string bufferflush;
	getline(cin, bufferflush);
	for (int i = 1; i <= t; i++)
	{
		getline(cin, input);
		cout << "Case #" << i << ": ";
		sol(input);
	}

	return 0;
}
