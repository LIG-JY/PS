#include <bits/stdc++.h>
using namespace std;


vector <pair<int, int>> v;
bool cmp (pair<int, int> a, pair<int, int> b) {
	return a.first > b.first;
}
int main() {
	for (int i = 10; i >= 1; i--) {
		v.push_back({i, 10-i}); // {} : pair 초기화 용도
	}
	sort(v.begin(), v.end());
	for (auto it : v) cout << it.first << " : " << it.second << "\n";
	sort(v.begin(), v.end(), cmp);
	for (auto it : v) cout << it.first << " : " << it.second << "\n";
	return 0;
}