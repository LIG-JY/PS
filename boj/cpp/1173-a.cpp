#include <bits/stdc++.h>
using namespace std;

int N, m, M, T, R, cnt, t_cnt;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> m >> M >> T >> R;
	int status = m;
	if (status + T > M)
	{
		cout << -1 << "\n";
		return 0;
	}
	while (t_cnt < N)
	{
		if (status + T <= M)
		{
			status += T;
			t_cnt++;
		}
		else
		{
			status = max(status - R, m);
		}
		cnt++;
	}
	cout << cnt << "\n";
	return 0;
}
