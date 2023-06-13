#include <bits/stdc++.h>
using namespace std;

int N, cnt[26];
string name, res;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N;
	for (int i = 0; i < N ; i++) {
		cin >> name;
		cnt[name[0] - 'a'] += 1;
	}
	for (int i = 0; i < 26 ; i++) {
		if (cnt[i] >= 5) {
			res += i + 'a';
		}
	}
	if (res.size()) {
		cout << res;
		exit(0);
	}
	cout << "PREDAJA";
	return 0;
}