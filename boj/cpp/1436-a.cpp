#include <bits/stdc++.h>
using namespace std;

int n;
int basis = 666;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	while (1) {
		size_t pos;
		pos = to_string(basis).find("666");
		if (pos != string::npos) {
			n--;
		}
		if (n == 0) {
			break;
		}
		basis++;
	}
	cout << basis << "\n";
}