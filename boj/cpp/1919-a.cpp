#include <bits/stdc++.h>
using namespace std;

int cnt['z' - 'a' + 1];
int res;
int main()
{
	int ch = 0;
	while ((ch = getchar()) != EOF && ch != '\n')
	{
		cnt[ch - 'a']++;
	}
	while ((ch = getchar()) != EOF && ch != '\n')
	{
		cnt[ch - 'a']--;
	}

	for (int i = 0; i < 'z' - 'a' + 1; i++)
	{
		if (cnt[i] < 0)
		{
			res -= cnt[i];
			continue;
		}
		res += cnt[i];
	}

	printf("%d\n", res);

	return 0;
}