#include <bits/stdc++.h>
using namespace std;

void getCommonLetter(const vector<string> &files)
{
	string res = "";
	string file = files[0];

	for (int i = 0; i < file.size(); i++)
	{
		char c = file[i];
		bool flag = false;
		for (int j = 1; j < files.size(); j++)
		{
			if (c != files[j][i])
			{
				flag = true;
				break;
			}
		}
		if (flag)
		{
			res += "?";
		}
		else
		{
			res += c;
		}
	}
	cout << res << "\n";
}

int t;
string input;
vector<string> files;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	for (int i = 1; i <= t; i++)
	{
		cin >> input;
		files.push_back(input);
	}
	if (t == 1)
	{
		cout << files.back();
	}
	else
	{
		getCommonLetter(files);
	}

	return 0;
}
