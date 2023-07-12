#include <bits/stdc++.h>
using namespace std;

int n, input, res, cnt[42];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	n = 10;
	while (n--) {
		cin >> input;
		cnt[input % 42]++;
	}
	for (int e : cnt) {
		if (e) {
			res++;
		}
	}
	cout << res;
}