#include <bits/stdc++.h>
using namespace std;

int n, input;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 1; i <= 8; i++) {
		cin >> n;
		input = (input * 10 + n);
	}
	if (input == 12345678) {
		cout << "ascending";
		exit(0);
	}
	if (input == 87654321) {
		cout << "descending";
		exit(0);
	}
	cout << "mixed" << "\n";
	return 0;
}