#include <bits/stdc++.h>
using namespace std;

int n, x;
vector<int> arr;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	while (n--) {
		cin >> x;
		arr.push_back(x);
	}

	cout << *min_element(arr.begin(), arr.end()) << " " << *max_element(arr.begin(), arr.end()) << "\n";
	return 0;
}