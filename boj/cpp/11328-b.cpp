#include <bits/stdc++.h>
using namespace std;

int n;
int cnt['z' - 'a' + 1];
int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i < n; ++i)
	{
		string s1, s2;
		cin >> s1 >> s2;
		for (char c : s1)
		{
			cnt[c - 'a']++;
		}
		for (char c : s2)
		{
			cnt[c - 'a']--;
		}
		bool ok = true;
		for (int i = 0; i < 'z' - 'a' + 1; ++i)
		{
			if (cnt[i] != 0)
			{
				ok = false;
				break;
			}
		}
		if (ok)
		{
			cout << "Possible\n";
		}
		else
		{
			cout << "Impossible\n";
		}
		fill(cnt, cnt + 'z' - 'a' + 1, 0);
	}
	return 0;
}
