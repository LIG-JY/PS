#include<bits/stdc++.h>
using namespace std;

int arr[9];
int sum = 0;
pair<int, int> res;
void comb() {
	for (int i = 0; i < 9; i++) {
		for (int j = i + 1; j < 9; j++) {
			if (sum -arr[i] - arr[j] == 100) {
					res = {arr[i] , arr[j]};
					return;	
			}
		}
	}
	return;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	for (int i=0; i < 9; i++) {
		cin >> arr[i];
	}
	for (int e : arr) {
		sum += e;
	}
	comb();
	// debug
	cout << res.first << " " << res.second << '\n';
	sort(arr, arr + 9);
	for (int i = 0; i < 9; i++) {
		if (arr[i] == res.first || arr[i] == res.second) {
			continue;
		}
		cout << arr[i] << '\n';
	}
    return 0;
}