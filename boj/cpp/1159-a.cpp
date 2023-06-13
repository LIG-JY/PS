#include <bits/stdc++.h>
using namespace std;

int N;
string name;
map<char, int> m;
bool surrender = true;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N;
	for (int i = 0; i < N ; i++) {
		cin >> name;
		m[name[0]] += 1;
	}
	for (auto e: m) {
		if (e.second >= 5) {
			cout << e.first;
			surrender = false;
		}
	}
	if (surrender) {
		cout << "PREDAJA";
	}
	return 0;
}