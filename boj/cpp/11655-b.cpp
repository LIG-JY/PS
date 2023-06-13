#include <bits/stdc++.h>
using namespace std;

string problem, uppercases, lowercases;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	for (int i = 0; i < 26; i++) {
		uppercases += (i + 'A');
		lowercases += (i + 'a');
	}
	getline(cin, problem);
	for (auto e : problem) {
		if (('a' <= e && e <= 'z')) {
			cout << lowercases[(lowercases.find(e) + 13) % 26];
			continue;
		}
		if (('A' <= e && e <= 'Z')) {
			cout << uppercases[(uppercases.find(e) + 13) % 26];
			continue;
		}
		cout << e;
	}
	return 0;
}