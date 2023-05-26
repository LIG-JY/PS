#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
int main() {
	vector<int> a { 1, 2, 3, 3, 3, 4};
	cout << lower_bound(a.begin(), a.end(), 3) - a.begin() << "\n"; // 시작하는 지점 반환
	cout << upper_bound(a.begin(), a.end(), 3) - a.begin() << "\n"; // 초과하는 지점 반환
	cout << * upper_bound(a.begin(), a.end(), 3) << "\n"; // 5라서 index 5의 값 4
	cout << * lower_bound(a.begin(), a.end(), 3) << "\n"; // 2라서 index 2의 값 3
	cout << upper_bound(a.begin(), a.end(), 3) - lower_bound(a.begin(), a.end(), 3) << "\n"; // 3이 몇 개인지 확인
	return 0;
}
