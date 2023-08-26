#include <bits/stdc++.h>

using namespace std;

int x, y, w, h;
vector<int> res;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> x >> y >> w >> h;
	res.push_back(x);
	res.push_back(y);
	res.push_back(w - x);
	res.push_back(h - y);
	sort(res.begin(), res.end());
	cout << *res.begin();

	return 0;
}
