#include <bits/stdc++.h>
using namespace std;

string a, b;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> a;
	b = a; // copy value
	reverse(b.begin(), b.end());
	if (b == a) {
		cout << 1 << "\n";
		exit(0);
	}
	cout << 0 << "\n";
	return 0;
}