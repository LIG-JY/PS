#include <bits/stdc++.h>
using namespace std;

vector <int> v;
int main() {
	for (int i = 1; i <= 5; i++) {
		v.push_back(i);
		v.push_back(i); // 중복해서 push_back
	}
	for (auto it : v) cout << it << " ";
	cout << "\n";

	auto w = unique(v.begin(), v.end()); // O(N)
	cout << w - v.begin() << "\n"; // w, v.begin() 모두 iterator위치 따라서 주소와 유사하다.
	for (auto it : v) cout << it << " ";
	cout << "\n";
	v.erase(w, v.end());
	for (auto it : v) cout << it << " ";
	return 0;
}
