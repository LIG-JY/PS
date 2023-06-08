#include <bits/stdc++.h>
using namespace std;

string a;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> a;
	auto i = a.begin();
	auto j = a.end() - 1;
	while (i < j) {
		if ((*i) != (*j)) {
			cout << 0 << "\n";
			exit(0);
		}
		i++;
		j--;
	}
	cout << 1 << "\n";
    return 0;
}