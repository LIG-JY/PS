#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int main() {
	vector<int> a { 1, 2, 3, 4, 5, 6, 7 ,8 ,9, 10};
	int sum = accumulate(a.begin(), a.end(), 0); // (시작 iter, 끝 iter, 초기값)
	cout << sum << "\n";
	int max_val = *max_element(a.begin(), a.end());
	auto max_idx = max_element(a.begin(), a.end()); // iter 범위에서 최대값가지는 iter 찾기
	int min_val = *min_element(a.begin(), a.end());
	auto min_idx = min_element(a.begin(), a.end());

	cout << "max : " << max_val << " " << "min : " << min_val << "\n";
	cout << "max_idx : " << max_idx - a.begin() << "\n";
	cout << "min_idx : " << min_idx - a.begin() << "\n";
	return 0;
}
