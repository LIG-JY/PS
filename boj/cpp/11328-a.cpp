#include <bits/stdc++.h>
using namespace std;

int n;
int cnt['z' - 'a' + 1];
int main()
{
	scanf("%d", &n);
	getchar();
	for (int i = 0; i < n; i++)
	{
		// input string
		int ch = 0;
		for (int round = 1; round <= 2; round++)
		{
			while ((ch = getchar()) != '\n' && ch != ' ' && ch != EOF)
			{
				if (round == 1)
				{
					cnt[ch - 'a']++;
				}
				else
				{
					cnt[ch - 'a']--;
				}
			}
			while (ch != ' ' && ch != EOF && ch != '\n')
			{
				ch = getchar();
			}
		}
		bool flag = 1;
		for (int k = 0; k < 'z' - 'a' + 1; k++)
		{
			if (cnt[k] != 0)
			{
				flag = 0;
				break;
			}
		}
		if (flag)
		{
			printf("Possible\n");
		}
		else
		{
			printf("Impossible\n");
		}
		for (int a = 0; a < 'z' - 'a' + 1; a++)
		{
			cnt[a] = 0;
		}
	}
	return 0;
}
