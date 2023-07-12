#include <bits/stdc++.h>
using namespace std;

vector<int> input;
int n;
bool aflag = true;
bool dflag = true;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	input.push_back(0);
	for (int i = 1; i <= 8; i++) {
		cin >> n;
		input.push_back(n);
	}
	for (int i = 1; i <= 8; i++) {
		if (input[i] != i) {
			aflag = false;
		}
		if (input[i] != 9 - i) {
			dflag = false;
		}
	}
	if (aflag) {
		cout << "ascending";
		exit(0);
	}
	if (dflag) {
		cout << "descending";
		exit(0);
	}
	cout << "mixed" << "\n";
	return 0;
}